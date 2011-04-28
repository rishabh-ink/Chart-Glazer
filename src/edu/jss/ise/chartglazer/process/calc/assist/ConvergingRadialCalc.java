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
package edu.jss.ise.chartglazer.process.calc.assist;

import edu.jss.ise.chartglazer.data.interim.assist.calc.CoordinateManagerData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.ConvergingRadialData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.DrawingManagerData;
import edu.jss.ise.chartglazer.process.calc.ICalculateCoordinates;
import edu.jss.ise.chartglazer.shared.CGLogger;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Calculates the coordinates of the Converging Radial diagram, which consists of 3 rectangles converging towards a circle.
 * @author rishabh
 */
public class ConvergingRadialCalc implements ICalculateCoordinates
{
	/**
	 * The width of the converging rectangle is equal to the horizontal division width (screen width / 3.)
	 * The height is <code>RECTANGLE_HEIGHT_PERCENTAGE</code> multiplied by the horizontal division width.
	 */
	private double RECTANGLE_HEIGHT_PERCENTAGE = 0.6;
	/**
	 * This value is always 4 because we will always divide the screen into 4 equal parts, because 3 rectangles are to be drawn.
	 */
	private final int NUMBER_OF_RECTANGLES_IN_CONVERGING_RADIAL_DIAGRAM = 4;
	private Point leftRectangle = new Point();
	private Point middleRectangle = new Point();
	private Point rightRectangle = new Point();
	private Point leftRectangleLinePoint = new Point();
	private Point rightRectangleLinePoint = new Point();
	private Point middleRectangleLinePoint = new Point();
	private Point leftCircleLinePoint = new Point();
	private Point rightCircleLinePoint = new Point();
	private Point middleCircleLinePoint = new Point();
	private Point middleCircle = new Point();
	private Dimension rectangleDimension = new Dimension();
	private Dimension middleCircleFrameDimension = new Dimension();
	private Rectangle leftTextBoundingRectangle = new Rectangle();
	private Rectangle rightTextBoundingRectangle = new Rectangle();
	private Rectangle middleTextBoundingRectangle = new Rectangle();
	private Rectangle circleTextBoundingRectangle = new Rectangle();
	private String leftRectangleString;
	private String rightRectangleString;
	private String middleRectangleString;
	private String middleCircleString;
	private double horizontalDivisionWidth;
	private double verticalDivisionHeight;

	private void setupTextContent(CoordinateManagerData cmData)
	{
		CGLogger.trace("Setting up text string contents...");

		// setup text content for root (middle circle)
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
		rootNode = (DefaultMutableTreeNode) cmData.getInputDiagram().getRoot();

		middleCircleString = new String(rootNode.toString());
		CGLogger.trace("middleCircleString = " + middleCircleString);

		// setup text content for the first child (left rectangle)
		DefaultMutableTreeNode inputTreeChild = new DefaultMutableTreeNode();
		inputTreeChild = cmData.getInputDiagram().getNextNode();
		leftRectangleString = new String(inputTreeChild.toString());
		CGLogger.trace("leftRectangleString = " + leftRectangleString);

		// setup text content for the second child (middle rectangle)
		inputTreeChild = inputTreeChild.getNextNode();
		middleRectangleString = new String(inputTreeChild.toString());
		CGLogger.trace("middleRectangleString = " + middleRectangleString);

		// setup text content for the third child (right rectangle)
		inputTreeChild = inputTreeChild.getNextNode();
		rightRectangleString = new String(inputTreeChild.toString());
		CGLogger.trace("rightRectangleString = " + rightRectangleString);

		CGLogger.trace("Done setting up text string contents!");
	}

	private void setupDimensions()
	{
		CGLogger.trace("Setting up dimensions...");

		// setup all rectangles' dimensions
		rectangleDimension.setSize(horizontalDivisionWidth, verticalDivisionHeight * RECTANGLE_HEIGHT_PERCENTAGE);
		CGLogger.trace("rectangleDimension = " + rectangleDimension.toString());

		// setup middle circle frame dimensions
		middleCircleFrameDimension.setSize(horizontalDivisionWidth, horizontalDivisionWidth);
		CGLogger.trace("middleCircleFrameDimension = " + middleCircleFrameDimension.toString());
	}

	private void setupCoordinates()
	{
		CGLogger.trace("Setting up coordinates...");
		// setup left rectangle
		leftRectangle.x = (int) (horizontalDivisionWidth - (rectangleDimension.width / 2));
		leftRectangle.y = (int) ((2 * verticalDivisionHeight) - (rectangleDimension.height / 2));
		CGLogger.trace("leftRectangle = " + leftRectangle.toString());

		// setup middle rectangle
		middleRectangle.x = (int) ((2 * horizontalDivisionWidth) - (rectangleDimension.width / 2));
		middleRectangle.y = (int) (verticalDivisionHeight - (rectangleDimension.height / 2));
		CGLogger.trace("middleRectangle = " + middleRectangle.toString());

		// setup right rectangle
		rightRectangle.x = (int) ((3 * horizontalDivisionWidth) - (rectangleDimension.width / 2));
		rightRectangle.y = (int) ((2 * verticalDivisionHeight) - (rectangleDimension.height / 2));
		CGLogger.trace("rightRectangle = " + rightRectangle.toString());

		// setup middle circle
		middleCircle.x = (int) ((2 * horizontalDivisionWidth) - (middleCircleFrameDimension.width / 2));
		middleCircle.y = (int) ((3 * verticalDivisionHeight) - (middleCircleFrameDimension.height / 2));
		CGLogger.trace("middleCircle = " + middleCircle);

		CGLogger.trace("Done setting up coordinates!");
	}

	private void setupLineCoordinates()
	{
		CGLogger.trace("Setting up line coordinates...");

		// setup line from left rectangle to middle circle
		leftRectangleLinePoint.x = (leftRectangle.x + rectangleDimension.width);
		leftRectangleLinePoint.y = (leftRectangle.y + rectangleDimension.height);
		CGLogger.trace("leftRectangleLinePoint = " + leftRectangleLinePoint.toString());

		leftCircleLinePoint.x = middleCircle.x + (middleCircleFrameDimension.width / 2);
		leftCircleLinePoint.y = middleCircle.y + (middleCircleFrameDimension.height / 2);
		CGLogger.trace("leftCircleLinePoint = " + leftCircleLinePoint.toString());


		// setup line from middle rectangle to middle circle
		middleRectangleLinePoint.x = (middleRectangle.x + (rectangleDimension.width / 2));
		middleRectangleLinePoint.y = (middleRectangle.y + rectangleDimension.height);
		CGLogger.trace("middleRectangleLinePoint = " + middleRectangleLinePoint.toString());

		middleCircleLinePoint.x = middleCircle.x  + (middleCircleFrameDimension.width / 2);
		middleCircleLinePoint.y = middleCircle.y  + (middleCircleFrameDimension.height / 2);
		CGLogger.trace("middleCircleLinePoint = " + middleCircleLinePoint.toString());

		// setup line from right rectangle to middle circle
		rightRectangleLinePoint.x = rightRectangle.x;
		rightRectangleLinePoint.y = (rightRectangle.y + rectangleDimension.height);
		CGLogger.trace("rightRectangleLinePoint = " + rightRectangleLinePoint.toString());

		rightCircleLinePoint.x = middleCircle.x  + (middleCircleFrameDimension.width / 2);
		rightCircleLinePoint.y = middleCircle.y  + (middleCircleFrameDimension.height / 2);
		CGLogger.trace("rightCircleLinePoint = " + rightCircleLinePoint.toString());

		CGLogger.trace("Done setting up line coordinates!");
	}

	private void setupBoundingRectangles()
	{
		CGLogger.trace("Setting up bounding rectangles...");

		leftTextBoundingRectangle = new Rectangle(leftRectangle, rectangleDimension);
		CGLogger.trace("leftTextBoundingRectangle = " + leftTextBoundingRectangle.toString());
		
		rightTextBoundingRectangle = new Rectangle(rightRectangle, rectangleDimension);
		CGLogger.trace("rightTextBoundingRectangle = " + rightTextBoundingRectangle.toString());
		
		middleTextBoundingRectangle = new Rectangle(middleRectangle, rectangleDimension);
		CGLogger.trace("middleTextBoundingRectangle = " + middleTextBoundingRectangle.toString());

		circleTextBoundingRectangle = new Rectangle(middleCircle, middleCircleFrameDimension);
		CGLogger.trace("circleTextBoundingRectangle = " + circleTextBoundingRectangle.toString());

		CGLogger.trace("Done setting up bounding rectangles!");
	}

	/**
	 * Calculates coordinates for the Converging Radial diagram.
	 */
	public DrawingManagerData calculateCoordinates(CoordinateManagerData cmData) throws Exception
	{
		CGLogger.trace("Calculating coordinates for Converging Radial...");

		ConvergingRadialData crReturnData = new ConvergingRadialData(cmData.getDiagramType(), cmData.getNumberOfSubtasks());

		// divide the screen equally
		horizontalDivisionWidth = cmData.getDiagramDimensions().width / NUMBER_OF_RECTANGLES_IN_CONVERGING_RADIAL_DIAGRAM;
		verticalDivisionHeight = cmData.getDiagramDimensions().height / NUMBER_OF_RECTANGLES_IN_CONVERGING_RADIAL_DIAGRAM;
		CGLogger.trace("horizontalDivisionWidth = " + horizontalDivisionWidth);
		CGLogger.trace("verticalDivisionHeight = " + verticalDivisionHeight);

		// setup text strings for all the shapes
		setupTextContent(cmData);

		// setup dimensions
		setupDimensions();


		// setup coordinates
		setupCoordinates();

		// setup line coordinates
		setupLineCoordinates();

		// setup bounding rectangles
		setupBoundingRectangles();

		crReturnData.setLeftCircleLinePoint(leftCircleLinePoint);
		crReturnData.setLeftRectangleLinePoint(leftRectangleLinePoint);
		crReturnData.setLeftRectanglePoint(leftRectangle);
		crReturnData.setLeftRectangleString(leftRectangleString);
		crReturnData.setLeftTextBoundingRectangle(leftTextBoundingRectangle);

		crReturnData.setMiddleCircleFramingRectangleDimension(middleCircleFrameDimension);

		crReturnData.setMiddleCircleLinePoint(middleCircleLinePoint);
		crReturnData.setMiddleCirclePoint(middleCircle);
		crReturnData.setMiddleCircleString(middleCircleString);
		crReturnData.setCircleTextBoundingRectangle(circleTextBoundingRectangle);

		crReturnData.setMiddleRectangleLinePoint(middleRectangleLinePoint);
		crReturnData.setMiddleRectanglePoint(middleRectangle);
		crReturnData.setMiddleRectangleString(middleRectangleString);
		crReturnData.setMiddleTextBoundingRectangle(middleTextBoundingRectangle);

		crReturnData.setRectangleDimension(rectangleDimension);

		crReturnData.setRightCircleLinePoint(rightCircleLinePoint);
		crReturnData.setRightRectangleLinePoint(rightRectangleLinePoint);
		crReturnData.setRightRectanglePoint(rightRectangle);
		crReturnData.setRightRectangleString(rightRectangleString);
		crReturnData.setRightTextBoundingRectangle(rightTextBoundingRectangle);

		return crReturnData;
	}
}
