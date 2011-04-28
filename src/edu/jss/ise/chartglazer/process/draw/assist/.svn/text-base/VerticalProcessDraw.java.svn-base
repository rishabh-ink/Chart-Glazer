/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.jss.ise.chartglazer.process.draw.assist;

import edu.jss.ise.chartglazer.data.input.AppearanceInputData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.VerticalProcessData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.DrawingManagerData;
import edu.jss.ise.chartglazer.data.output.SVGDocumentData;
import edu.jss.ise.chartglazer.process.draw.IDrawDiagram;
import edu.jss.ise.chartglazer.shared.CGLogger;
import edu.jss.ise.chartglazer.shared.CommonVariables;
import edu.jss.ise.chartglazer.shared.IShapeTypes;
import edu.jss.ise.chartglazer.shop.kiosk.Painter;
import edu.jss.ise.chartglazer.shop.kiosk.ShapesManager;
import edu.jss.ise.chartglazer.shop.kiosk.TextManager;
import edu.jss.ise.chartglazer.shop.showcase.cgAuxTriangle;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.logging.Level;


/**
 * This class is responsible for drawing the Basic Process diagram by using the data provided by the <code>CoordinateManager</code> class.
 * @author naren
 */

public class VerticalProcessDraw implements IDrawDiagram
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
	public VerticalProcessDraw()
	{
		CGLogger.trace("Constructing BasicProcess object...");
		padding = CommonVariables.DEFAULT_PADDING;
		rectangleDimensions = new Dimension();
	}

	/**
	 * Constructor to assign padding value.
	 * @param padding The padding value is the distance between the text content and the bounding rectangle.
	 */
	public VerticalProcessDraw(int padding)
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
		VerticalProcessData vpData = (VerticalProcessData) dmData;
		TextManager bpTextManager = new TextManager();

		Painter vpPainter = new Painter(appearanceSpecs.getTaskBackgroundBlend1Color(), appearanceSpecs.getTaskBackgroundBlend2Color(), vpData.getNumberOfSubtasks());

		// TODO draw the shapes on outputDiagram
		CGLogger.trace("Now drawing diagram for BasicProcess...");

		ShapesManager shopKeeper = new ShapesManager();

		// common stroke settings for all
		outputDiagram.getGenerator().setStroke(appearanceSpecs.getBorderStroke());

		for (int i = 0; i < vpData.getNumberOfSubtasks(); i++)
		{

			CGLogger.trace("bpData.getShapeCenterPointsArray(" + i + ") = " + vpData.getShapeCenterPointsArray(i));
			CGLogger.trace("bpData.getTextCenterPointsArray(" + i + ") = " + vpData.getTextCenterPointsArray(i));

			Shape subtaskShape = shopKeeper.createSubtaskShape(IShapeTypes.TASK_RECTANGLE, vpData.getShapeCenterPointsArray()[i], vpData.getTextCenterPointsArray(i), vpData.getSubTaskRectangleDimensions(), vpData.getTextContent()[i]);

			if(i <= vpData.getNumberOfSubtasks() - 2)
			{
				CGLogger.trace("bpData.getArrowBaseCenterPointsArray(i) = " + vpData.getArrowBaseCenterPointsArray(i));
				Shape auxShape = shopKeeper.createAuxShape(IShapeTypes.AUX_TRIANGLE, vpData.getArrowBaseCenterPointsArray(i), vpData.getArrowTriangleBaseLength(), cgAuxTriangle.FACE_SOUTH);

				// draw the triangular arrow
				outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
				outputDiagram.getGenerator().draw(auxShape);
			}
			
			outputDiagram.getGenerator().setPaint(vpPainter.getBlendedColors(i));
			outputDiagram.getGenerator().fill(subtaskShape);

			outputDiagram.getGenerator().setPaint(appearanceSpecs.getTaskBorderColor());
			outputDiagram.getGenerator().draw(subtaskShape);

			outputDiagram.getGenerator().setPaint(appearanceSpecs.getFontColor());
			bpTextManager.createTextContent(vpData.getTextContent()[i], vpData.getBoundingRectangle(i), outputDiagram.getGenerator(), appearanceSpecs.getTextFont(), this.padding);
		}

	}
}
