/**
This file is part of Chart Glazer.

Chart Glazer is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Chart Glazer is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Chart Glazer.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.jss.ise.chartglazer.shop.kiosk;

import edu.jss.ise.chartglazer.shared.CGLogger;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Hashtable;
import org.apache.batik.svggen.SVGGraphics2D;

/**
 * Handles the writing of the text content onto the rectangles.
 * @author rishabh
 */
public class TextManager
{
	/**
	 * Draws the text inside the <code>boundingRectanlge</code>.
	 * @param textContent Text to draw.
	 * @param boundingRectangle The actual box bounding our application.
	 * @param generator The SVGGraphics2D generator object.
	 * @param textFont The font attributes of the text to be drawn.
	 * @param pad The inside padding distance between the text and the bounding rectangle.
	 */
	public void createTextContent(String textContent, Rectangle boundingRectangle, SVGGraphics2D generator, Font textFont, int pad)
	{
		// The LineBreakMeasurer used to line-break the paragraph.
		LineBreakMeasurer lineMeasurer = null;
		// index of the first character in the paragraph.
		int paragraphStart;
		// index of the first character after the end of the paragraph.
		int paragraphEnd;
		Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

		int fontSize = textFont.getSize();
		
		map.put(TextAttribute.FAMILY, textFont.getName());
		map.put(TextAttribute.SIZE, new Float(textFont.getSize()));

		AttributedString inputTextAttributedString = new AttributedString(textContent);

		// Create a new LineBreakMeasurer from the paragraph.
		// It will be cached and re-used.

		AttributedCharacterIterator paragraph = inputTextAttributedString.getIterator();
		paragraphStart = paragraph.getBeginIndex();
		paragraphEnd = paragraph.getEndIndex();
		FontRenderContext frc = generator.getFontRenderContext();
		lineMeasurer = new LineBreakMeasurer(paragraph, frc);

		// Set break width to width of Component.
		float breakWidth = (float) boundingRectangle.getWidth() - pad;
		float drawPosY = 0;

		// Set position to the index of the first character in the paragraph.
		lineMeasurer.setPosition(paragraphStart);

		float completeParaHeight = 0;

		// FIXME This loop may not be required
//		while (lineMeasurer.getPosition() < paragraphEnd)
//		{
//			TextLayout layout = lineMeasurer.nextLayout(breakWidth);
//			completeParaHeight += layout.getAscent();
//		}

		for (int i = fontSize; i >= 1; i--)
		{
			inputTextAttributedString = new AttributedString(textContent, map);
			// Create a new LineBreakMeasurer from the paragraph.
			// It will be cached and re-used.
			paragraph = inputTextAttributedString.getIterator();
			paragraphStart = paragraph.getBeginIndex();
			paragraphEnd = paragraph.getEndIndex();
			frc = generator.getFontRenderContext();
			lineMeasurer = new LineBreakMeasurer(paragraph, frc);

			completeParaHeight = 0;
			// Set position to the index of the first character in the paragraph.
			lineMeasurer.setPosition(paragraphStart);

			while (lineMeasurer.getPosition() < paragraphEnd)
			{
				TextLayout layout = lineMeasurer.nextLayout(breakWidth);
				completeParaHeight += layout.getAscent();
			}

			CGLogger.trace("[" + i + "] : completeParaHeight = " + completeParaHeight + ", helloBox.getHeight() - pad = " + (boundingRectangle.getHeight() - pad) + ", map.get(TextAttribute.SIZE).toString() = " + map.get(TextAttribute.SIZE).toString());

			if (completeParaHeight > (boundingRectangle.getHeight() - (pad * 2)))
			{
				map.clear();
				map.put(TextAttribute.FAMILY, textFont.getFontName());
				fontSize--;
				map.put(TextAttribute.SIZE, new Float(fontSize));
			}
			else
			{
				break;
			}
		}

		// MOD:
		drawPosY = ((boundingRectangle.y + (boundingRectangle.height / 2)) - (completeParaHeight / 2));
		// ORIG: drawPosY = (float) ((boundingRectangle.y  + (boundingRectangle.getHeight() - pad - completeParaHeight) / 2));

		// Set position to the index of the first character in the paragraph.
		lineMeasurer.setPosition(paragraphStart);

		// Get lines until the entire paragraph has been displayed.
		while (lineMeasurer.getPosition() < paragraphEnd)
		{
			// Retrieve next layout. A cleverer program would also cache
			// these layouts until the component is re-sized.
			TextLayout layout = lineMeasurer.nextLayout(breakWidth);

			// Compute pen x position.
			float drawPosX = (boundingRectangle.x + (breakWidth - layout.getAdvance()) / 2) + (pad / 2);

			// Move y-coordinate by the ascent of the layout.
			drawPosY += layout.getAscent();

			// Draw the TextLayout at (drawPosX, drawPosY).
			layout.draw(generator, drawPosX, drawPosY);

			// Move y-coordinate in preparation for next layout.
			drawPosY += layout.getDescent() + layout.getLeading();
		}
	}
}
