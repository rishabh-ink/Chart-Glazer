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
import edu.jss.ise.chartglazer.data.interim.assist.draw.BasicProcessData;
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
import edu.jss.ise.chartglazer.shop.showcase.cgAuxTriangle;

/**
 * This class is responsible for drawing the Basic Process diagram by using the data provided by the <code>CoordinateManager</code> class.
 * @author rishabh
 */
public class BasicProcessDraw implements IDrawDiagram
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
	public BasicProcessDraw()
	{
		CGLogger.trace("Constructing BasicProcess object...");
		padding = CommonVariables.DEFAULT_PADDING;
		rectangleDimensions = new Dimension();
	}

	/**
	 * Constructor to assign padding value.
	 * @param padding The padding value is the distance between the text content and the bounding rectangle.
	 */
	public BasicProcessDraw(int padding)
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
	 * Draws the BasicProcess diagram in the <code>SVGDocumentData</code>'subtaskShape <code>outputDiagram</code> object.
	 */
	public void drawDiagram(DrawingManagerData dmData, SVGDocumentData outputDiagram, AppearanceInputData appearanceSpecs) throws Exception
	{
		BasicProcessData bpData = (BasicProcessData) dmData;
		TextManager bpTextManager = new TextManager();

		Painter bpPainter = new Painter(appearanceSpecs.getTaskBackgroundBlend1Color(), appearanceSpecs.getTaskBackgroundBlend2Color(), bpData.getNumberOfSubtasks());

		// TODO draw the shapes on outputDiagram
		CGLogger.trace("Now drawing diagram for BasicProcess...");

		ShapesManager shopKeeper = new ShapesManager();

		// common stroke settings for all
		outputDiagram.getGenerator().setStroke(appearanceSpecs.getBorderStroke());

		for (int i = 0; i < bpData.getNumberOfSubtasks(); i++)
		{
			CGLogger.trace("bpData.getShapeCenterPointsArray(" + i + ") = " + bpData.getShapeCenterPointsArray(i));
			CGLogger.trace("bpData.getTextCenterPointsArray(" + i + ") = " + bpData.getTextCenterPointsArray(i));

			CGLogger.trace(appearanceSpecs.toString());
			
			Shape subtaskShape = shopKeeper.createSubtaskShape(IShapeTypes.TASK_RECTANGLE, bpData.getShapeCenterPointsArray(i), bpData.getTextCenterPointsArray(i), bpData.getSubTaskRectangleDimensions(), bpData.getTextContent()[i]);

			if(i <= bpData.getNumberOfSubtasks() - 2)
			{
				CGLogger.trace("bpData.getArrowBaseCenterPointsArray(i) = " + bpData.getArrowBaseCenterPointsArray(i));
				Shape auxShape = shopKeeper.createAuxShape(IShapeTypes.AUX_TRIANGLE, bpData.getArrowBaseCenterPointsArray(i), bpData.getArrowTriangleBaseLength(), cgAuxTriangle.FACE_EAST);
				
				// draw the triangular arrow
				outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
				outputDiagram.getGenerator().draw(auxShape);
			}
			
			// subtask background
			outputDiagram.getGenerator().setPaint(bpPainter.getBlendedColors(i));
			outputDiagram.getGenerator().fill(subtaskShape);

			// subtask border
			outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());

			// after setting the subtask background and border, draw the shape
			outputDiagram.getGenerator().draw(subtaskShape);

			

			// subtask text content
			outputDiagram.getGenerator().setPaint(appearanceSpecs.getFontColor());
			bpTextManager.createTextContent(bpData.getTextContent()[i], bpData.getBoundingRectangle(i), outputDiagram.getGenerator(), appearanceSpecs.getTextFont(), this.padding);

			
		}
	}
}
