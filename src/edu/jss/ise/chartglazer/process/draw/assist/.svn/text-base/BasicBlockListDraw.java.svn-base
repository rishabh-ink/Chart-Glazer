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
package edu.jss.ise.chartglazer.process.draw.assist;

import edu.jss.ise.chartglazer.data.input.AppearanceInputData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.BasicBlockListData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.DrawingManagerData;
import edu.jss.ise.chartglazer.data.output.SVGDocumentData;
import edu.jss.ise.chartglazer.process.draw.IDrawDiagram;
import edu.jss.ise.chartglazer.shared.CGLogger;
import edu.jss.ise.chartglazer.shared.CommonVariables;
import edu.jss.ise.chartglazer.shared.IShapeTypes;
import edu.jss.ise.chartglazer.shop.kiosk.Painter;
import edu.jss.ise.chartglazer.shop.kiosk.ShapesManager;
import edu.jss.ise.chartglazer.shop.kiosk.TextManager;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.logging.Level;

/**
 * This class is responsible for drawing the Basic Process diagram by using the data provided by the <code>CoordinateManager</code> class.
 * @author rishabh
 */
public class BasicBlockListDraw implements IDrawDiagram
{
	/**
	 * The padding value is the distance between the text content and the bounding rectangle.
	 */
	private int padding;


	/**
	 * The dimensions of the bounding rectangle.
	 */
	private Dimension rectangleDimensions;

	/**
	 * Empty constructor.
	 */
	public BasicBlockListDraw()
	{
		CGLogger.trace("Constructing BasicProcess object...");
		padding = CommonVariables.DEFAULT_PADDING;
		rectangleDimensions = new Dimension();
	}

	/**
	 * Constructor to assign padding value.
	 * @param padding The padding value is the distance between the text content and the bounding rectangle.
	 */
	public BasicBlockListDraw(int padding)
	{
		if (padding <= 0)
		{
			CGLogger.trace(Level.WARNING, "padding was sent an invalid value of, " + padding + ", thus will use DEFAULT_PADDING = " + CommonVariables.DEFAULT_PADDING);
			padding = CommonVariables.DEFAULT_PADDING;
		}
		else
		{
			this.padding = padding;
		}
	}

	/**
	 * Draws the BasicProcess diagram in the <code>SVGDocumentData</code>'s <code>outputDiagram</code> object.
	 */
	public void drawDiagram(DrawingManagerData dmData, SVGDocumentData outputDiagram, AppearanceInputData appearanceSpecs) throws Exception
	{
		
		BasicBlockListData bblData = (BasicBlockListData) dmData;
		TextManager bpTextManager = new TextManager();

		Painter bblPainter = new Painter(appearanceSpecs.getTaskBackgroundBlend1Color(), appearanceSpecs.getTaskBackgroundBlend2Color(), bblData.getNumberOfSubtasks());

		// TODO draw the shapes on outputDiagram
		CGLogger.trace("Now drawing diagram for BasicBlockList...");

		ShapesManager shopKeeper = new ShapesManager();

		// outputDiagram.getGenerator().setPaint(Color.BLACK);

		for (int i = 0; i < bblData.getNumberOfSubtasks(); i++)
		{

			CGLogger.trace("bblData.getShapeCenterPointsArray(" + i + ") = " + bblData.getShapeCenterPointsArray(i));
			CGLogger.trace("bblData.getTextCenterPointsArray(" + i + ") = " + bblData.getTextCenterPointsArray(i));

			CGLogger.trace(appearanceSpecs.toString());

			Shape s = shopKeeper.createSubtaskShape(IShapeTypes.TASK_RECTANGLE, bblData.getShapeCenterPointsArray()[i], bblData.getTextCenterPointsArray(i), bblData.getSubTaskRectangleDimensions(), bblData.getTextContent()[i]);

			// subtask background
			outputDiagram.getGenerator().setPaint(bblPainter.getBlendedColors(i));
			outputDiagram.getGenerator().fill(s);

			// subtask border
			outputDiagram.getGenerator().setStroke(appearanceSpecs.getBorderStroke());
			outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
			outputDiagram.getGenerator().draw(s);

			// subtask text content
			outputDiagram.getGenerator().setPaint(appearanceSpecs.getFontColor());
			bpTextManager.createTextContent(bblData.getTextContent()[i], bblData.getBoundingRectangle(i), outputDiagram.getGenerator(), appearanceSpecs.getTextFont(), this.padding);
		}
	}
}
