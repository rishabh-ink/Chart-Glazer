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
package edu.jss.ise.chartglazer.data.input;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

/**
 * Contains user appearance selection info.
 * @author rishabh
 */
public class AppearanceInputData
{
	/**
	 * The font face of the displayed text.
	 */
	protected Font textFont;
	/**
	 * The blend 1 fill color of the subtask (box i.e. rectangle, circle etc.) shape.
	 */
	protected Color taskBackgroundBlend1Color;
	/**
	 * The blend 2 fill color of the subtask (box i.e. rectangle, circle etc.) shape.
	 */
	protected Color taskBackgroundBlend2Color;
	/**
	 * The stroke color of the subtask.
	 */
	protected Color taskBorderColor;
	/**
	 * The (font-face) color of the text that is written inside the subtask shape.
	 */
	protected Color fontColor;

	/**
	 * The thickness of the border.
	 */
	protected float borderStrokeWidth;


	/**
	 * Initializes the data members to default values. This is used as a failsafe. Always use the other constructor.
	 */
	public AppearanceInputData()
	{
		textFont = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
		taskBackgroundBlend1Color = Color.LIGHT_GRAY;
		taskBorderColor = Color.GRAY;
		fontColor = Color.DARK_GRAY;
	}

	/**
	 * Initializes the data members to the given values.
	 * @param fontFaceName The name of the font to be used. This is a string equal to the name of an installed font on the system.
	 * @param fontStyle The bit mask of the style to be used. Usually, this is a bit mask of combinations (bitwise ops) of <code>Font.BOLD</code>, <code>Font.PLAIN</code>. Other styles may also be used.
	 * @param fontSize The size of the font in points. This is the value of the max font size. If the text doesn't fit inside the shape, this value may be reduced so as to fit that text.
	 * @param taskBackgroundBlend1Color The blend 1 fill color of the subtask (box i.e. rectangle, circle etc.) shape.
	 * @param taskBackgroundBlend2Color The blend 2 fill color of the subtask (box i.e. rectangle, circle etc.) shape.
	 * @param taskBorderColor The stroke color of the subtask.
	 * @param fontColor The (font-face) color of the text that is written inside the subtask shape.
	 */
	public AppearanceInputData(String fontFaceName, int fontStyle, int fontSize, Color taskBackgroundBlend1Color, Color taskBackgroundBlend2Color, Color taskBorderColor, Color fontColor, float borderStrokeWidth)
	{
		this.setTextFont(fontFaceName, fontStyle, fontSize);
		this.setTaskBackgroundBlend1Color(taskBackgroundBlend1Color);
		this.setTaskBackgroundBlend2Color(taskBackgroundBlend2Color);
		this.setTaskBorderColor(taskBorderColor);
		this.setFontColor(fontColor);
		this.borderStrokeWidth = borderStrokeWidth;
	}

	/**
	 * @return The font face of the displayed text.
	 */
	public Font getTextFont()
	{
		return textFont;
	}

	/**
	 * @return The (font-face) color of the text that is written inside the subtask shape.
	 */
	public Color getFontColor()
	{
		return fontColor;
	}

	/**
	 * @return The blend 1 fill color of the subtask (box i.e. rectangle, circle etc.) shape.
	 */
	public Color getTaskBackgroundBlend1Color()
	{
		return taskBackgroundBlend1Color;
	}

	/**
	 * @return The blend 2 fill color of the subtask (box i.e. rectangle, circle etc.) shape.
	 */
	public Color getTaskBackgroundBlend2Color()
	{
		return taskBackgroundBlend2Color;
	}

	/**
	 * @return The stroke color of the subtask.
	 */
	public Color getTaskBorderColor()
	{
		return taskBorderColor;
	}

	/**
	 * @return The thickness of the border.
	 */
	public Stroke getBorderStroke()
	{
		return new BasicStroke(this.borderStrokeWidth);
	}

	/**
	 * @param borderStrokeWidth The thickness of the border.
	 */
	public void setBorderStrokeWidth(Double borderStrokeWidth)
	{
		this.borderStrokeWidth = borderStrokeWidth.floatValue();
	}

	/**
	 * @param fontFaceName The name of the font to be used. This is a string equal to the name of an installed font on the system.
	 * @param fontStyle The bit mask of the style to be used. Usually, this is a bit mask of combinations (bitwise ops) of <code>Font.BOLD</code>, <code>Font.PLAIN</code>. Other styles may also be used.
	 * @param fontSize The size of the font in points. This is the value of the max font size. If the text doesn't fit inside the shape, this value may be reduced so as to fit that text.
	 */
	public void setTextFont(String fontFaceName, int fontStyle, int fontSize)
	{
		this.textFont = new Font(fontFaceName, fontStyle, fontSize);
	}

	/**
	 * @param fontColor The (font-face) color of the text that is written inside the subtask shape.
	 */
	public void setFontColor(Color fontColor)
	{
		this.fontColor = fontColor;
	}

	/**
	 * @param taskBackgroundBlend1Color The blend 1 fill color of the subtask (box i.e. rectangle, circle etc.) shape.
	 */
	public void setTaskBackgroundBlend1Color(Color taskBackgroundBlend1Color)
	{
		this.taskBackgroundBlend1Color = taskBackgroundBlend1Color;
	}

	/**
	 * @param taskBackgroundBlend2Color The blend 2 fill color of the subtask (box i.e. rectangle, circle etc.) shape.
	 */
	public void setTaskBackgroundBlend2Color(Color taskBackgroundBlend2Color)
	{
		this.taskBackgroundBlend2Color = taskBackgroundBlend2Color;
	}



	/**
	 * @param taskBorderColor The stroke color of the subtask.
	 */
	public void setTaskBorderColor(Color taskBorderColor)
	{
		this.taskBorderColor = taskBorderColor;
	}

	/**
	 * @return The values of all the data members of this <code>AppearanceInputData</code> object.
	 */
	@Override
	public String toString()
	{
		return ("[Font: " + textFont.toString() + ", Font-face Color: " + fontColor.toString() + ", Task Background Color: " + taskBackgroundBlend1Color + ", Task Border Color: " + taskBorderColor + "]");
	}
}
