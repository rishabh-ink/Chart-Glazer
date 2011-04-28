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
import edu.jss.ise.chartglazer.data.interim.assist.draw.DrawingManagerData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.HierarchyData;
import edu.jss.ise.chartglazer.data.output.SVGDocumentData;
import edu.jss.ise.chartglazer.process.draw.IDrawDiagram;
import edu.jss.ise.chartglazer.shared.CGLogger;
import edu.jss.ise.chartglazer.shared.CommonVariables;
import edu.jss.ise.chartglazer.shared.IShapeTypes;
import edu.jss.ise.chartglazer.shop.kiosk.Painter;
import edu.jss.ise.chartglazer.shop.kiosk.ShapesManager;
import edu.jss.ise.chartglazer.shop.kiosk.TextManager;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Shape;
import java.util.logging.Level;

/**
 * This class is responsible for drawing the Basic Process diagram by using the data provided by the <code>CoordinateManager</code> class.
 * @author rishabh
 */
public class HierarchyDraw implements IDrawDiagram
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
	public HierarchyDraw()
	{
		CGLogger.trace("Constructing BasicProcess object...");
		padding = CommonVariables.DEFAULT_PADDING;
		rectangleDimensions = new Dimension();
	}

	/**
	 * Constructor to assign padding value.
	 * @param padding The padding value is the distance between the text content and the bounding rectangle.
	 */
	public HierarchyDraw(int padding)
	{
		if (padding <= 0)
		{
			CGLogger.trace(Level.WARNING, "padding was sent an invalid value of, " + padding + ", thus will use DEFAULT_PADDING = " + CommonVariables.DEFAULT_PADDING);
			padding = CommonVariables.DEFAULT_PADDING;
		} else
		{
			this.padding = padding;
		}
	}

	/**
	 * Draws the Hierarchy diagram in the <code>SVGDocumentData</code>'s <code>outputDiagram</code> object.
	 */
	public void drawDiagram(DrawingManagerData dmData, SVGDocumentData outputDiagram, AppearanceInputData appearanceSpecs) throws Exception
	{
		HierarchyData hData = (HierarchyData) dmData;
		TextManager hTextManager = new TextManager();
		Point a = new Point();
		Point b = new Point();

		// TODO draw the shapes on outputDiagram
		CGLogger.trace("Now drawing diagram for BasicProcess...");

		ShapesManager shopKeeper = new ShapesManager();

		Painter hPainter = new Painter(appearanceSpecs.getTaskBackgroundBlend1Color(), appearanceSpecs.getTaskBackgroundBlend2Color(), hData.getNumberOfSubtasks());

		// common stroke setting for all: boxes and lines etc.
		outputDiagram.getGenerator().setStroke(appearanceSpecs.getBorderStroke());

		for (int i = 0; i < hData.getTextContent().length; i++)
		{
			CGLogger.trace("bpData.getShapeCenterPointsArray(" + i + ") = " + hData.getShapeCenterPointsArray(i));
			CGLogger.trace("bpData.getTextCenterPointsArray(" + i + ") = " + hData.getTextCenterPointsArray(i));
			CGLogger.trace("IShapeTypes.RECTANGLE = " + IShapeTypes.TASK_RECTANGLE);
			Shape s = shopKeeper.createSubtaskShape(IShapeTypes.TASK_RECTANGLE, hData.getShapeCenterPointsArray()[i], hData.getTextCenterPointsArray(i), hData.getSubTaskRectangleDimensions(), hData.getTextContent()[i]);
			outputDiagram.getGenerator().setPaint(hPainter.getBlendedColors(i));
			outputDiagram.getGenerator().fill(s);

			
			outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
			outputDiagram.getGenerator().draw(s);


			outputDiagram.getGenerator().setPaint(appearanceSpecs.getFontColor());
			hTextManager.createTextContent(hData.getTextContent()[i], hData.getBoundingRectangle(i), outputDiagram.getGenerator(), appearanceSpecs.getTextFont(), this.padding);
			//outputDiagram.getGenerator().drawString(hData.getTextContent()[i], 10, 20 * (i + 1));
		}


		outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
		for (int i = 0; i < hData.getTextContent().length - 1; i++)
		{
			a = hData.getConnectingLines(i).getP1();
			b = hData.getConnectingLines(i).getP2();
			outputDiagram.getGenerator().drawLine(a.x, a.y, b.x, b.y);

		}
	}
}
