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
import edu.jss.ise.chartglazer.data.interim.assist.draw.ConvergingRadialData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.DrawingManagerData;
import edu.jss.ise.chartglazer.data.output.SVGDocumentData;
import edu.jss.ise.chartglazer.process.draw.IDrawDiagram;
import edu.jss.ise.chartglazer.shared.CGLogger;
import edu.jss.ise.chartglazer.shared.CommonVariables;
import edu.jss.ise.chartglazer.shared.IShapeTypes;
import edu.jss.ise.chartglazer.shop.kiosk.Painter;
import edu.jss.ise.chartglazer.shop.kiosk.ShapesManager;
import edu.jss.ise.chartglazer.shop.kiosk.TextManager;
import java.awt.Shape;

/**
 * Draws the Converging Radial diagram, which consists of 3 rectangles converging towards a circle.
 * @author rishabh
 */
public class ConvergingRadialDraw implements IDrawDiagram
{
	ConvergingRadialData crData;
	TextManager crTextManager;
	Painter crPainter;
	ShapesManager shopKeeper;
	Shape s;
	private int pad = CommonVariables.DEFAULT_PADDING;

	/**
	 * Draws the Converging Radial diagram, which consists of 3 rectangles converging towards a circle.
	 */
	public void drawDiagram(DrawingManagerData dmData, SVGDocumentData outputDiagram, AppearanceInputData appearanceSpecs) throws Exception
	{
		crData = (ConvergingRadialData) dmData;
		crTextManager = new TextManager();

		crPainter = new Painter(appearanceSpecs.getTaskBackgroundBlend1Color(), appearanceSpecs.getTaskBackgroundBlend2Color(), crData.getNumberOfSubtasks());

		// TODO draw the shapes on outputDiagram
		CGLogger.trace("Now drawing diagram for BasicProcess...");

		shopKeeper = new ShapesManager();

		// draw the connecting lines before the shapes are drawn so the extra long lines are overlapped with the shapes

		outputDiagram.getGenerator().setStroke(appearanceSpecs.getBorderStroke());
		outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
		// draw left rectangle to middle circle line
		outputDiagram.getGenerator().drawLine(crData.getLeftRectangleLinePoint().x, crData.getLeftRectangleLinePoint().y, crData.getLeftCircleLinePoint().x, crData.getLeftCircleLinePoint().y);

		// draw middle rectangle to middle circle line
		outputDiagram.getGenerator().drawLine(crData.getMiddleRectangleLinePoint().x, crData.getMiddleRectangleLinePoint().y, crData.getMiddleCircleLinePoint().x, crData.getMiddleCircleLinePoint().y);

		// draw right rectangle to middle circle line
		outputDiagram.getGenerator().drawLine(crData.getRightRectangleLinePoint().x, crData.getRightRectangleLinePoint().y, crData.getRightCircleLinePoint().x, crData.getRightCircleLinePoint().y);

		// draw left rectangle
		s = shopKeeper.createSubtaskShape(IShapeTypes.TASK_RECTANGLE, crData.getLeftRectanglePoint(), null, crData.getRectangleDimension(), null);
		// subtask background
		outputDiagram.getGenerator().setPaint(crPainter.getBlendedColors(1));
		outputDiagram.getGenerator().fill(s);
		// subtask border
		outputDiagram.getGenerator().setStroke(appearanceSpecs.getBorderStroke());
		outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
		// after setting the subtask background and border, draw the shape
		outputDiagram.getGenerator().draw(s);

		// draw middle rectangle
		s = shopKeeper.createSubtaskShape(IShapeTypes.TASK_RECTANGLE, crData.getMiddleRectanglePoint(), null, crData.getRectangleDimension(), null);
		// subtask background
		outputDiagram.getGenerator().setPaint(crPainter.getBlendedColors(2));
		outputDiagram.getGenerator().fill(s);
		// subtask border
		outputDiagram.getGenerator().setStroke(appearanceSpecs.getBorderStroke());
		outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
		// after setting the subtask background and border, draw the shape
		outputDiagram.getGenerator().draw(s);

		// draw middle circle
		s = shopKeeper.createSubtaskShape(IShapeTypes.ELLIPSE, crData.getMiddleCirclePoint(), null, crData.getMiddleCircleFramingRectangleDimension(), null);
		// subtask background
		outputDiagram.getGenerator().setPaint(crPainter.getBlendedColors(0));
		outputDiagram.getGenerator().fill(s);
		// subtask border
		outputDiagram.getGenerator().setStroke(appearanceSpecs.getBorderStroke());
		outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
		// after setting the subtask background and border, draw the shape
		outputDiagram.getGenerator().draw(s);

		// draw right rectangle
		s = shopKeeper.createSubtaskShape(IShapeTypes.TASK_RECTANGLE, crData.getRightRectanglePoint(), null, crData.getRectangleDimension(), null);
		// subtask background
		outputDiagram.getGenerator().setPaint(crPainter.getBlendedColors(1));
		outputDiagram.getGenerator().fill(s);
		// subtask border
		outputDiagram.getGenerator().setStroke(appearanceSpecs.getBorderStroke());
		outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
		// after setting the subtask background and border, draw the shape
		outputDiagram.getGenerator().draw(s);

		// write the text onto the left subtask rectangle
		outputDiagram.getGenerator().setPaint(appearanceSpecs.getFontColor());
		crTextManager.createTextContent(crData.getLeftRectangleString(), crData.getLeftTextBoundingRectangle(), outputDiagram.getGenerator(), appearanceSpecs.getTextFont(), pad);

		// write the text onto the middle subtask rectangle
		outputDiagram.getGenerator().setPaint(appearanceSpecs.getFontColor());
		crTextManager.createTextContent(crData.getMiddleRectangleString(), crData.getMiddleTextBoundingRectangle(), outputDiagram.getGenerator(), appearanceSpecs.getTextFont(), pad);

		// write the text onto the right subtask rectangle
		outputDiagram.getGenerator().setPaint(appearanceSpecs.getFontColor());
		crTextManager.createTextContent(crData.getRightRectangleString(), crData.getRightTextBoundingRectangle(), outputDiagram.getGenerator(), appearanceSpecs.getTextFont(), pad);

		// write the text onto the middle subtask circle
		outputDiagram.getGenerator().setPaint(appearanceSpecs.getFontColor());
		crTextManager.createTextContent(crData.getMiddleCircleString(), crData.getCircleTextBoundingRectangle(), outputDiagram.getGenerator(), appearanceSpecs.getTextFont(), 30);
	}
}
