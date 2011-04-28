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
package edu.jss.ise.chartglazer.data.interim.assist.draw;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Draws a converging radial consisting of 3 rectangles converging towards a circle.
 * @author rishabh
 */
public class ConvergingRadialData extends DrawingManagerData
{
	/**
	 * Left side rectangle's top left coordinates. The width of this rectangle is equal to the horizontal division width (screen width / 3.) The height is <code>RECTANGLE_HEIGHT_PERCENTAGE</code> * horizontal division width.
	 * <img src="" alt="Left side rectangle's top left coordinates."></img>
	 */
	protected Point leftRectanglePoint;

	/**
	 * Right side rectangle's top left coordinates. The width of this rectangle is equal to the horizontal division width (screen width / 3.) The height is <code>RECTANGLE_HEIGHT_PERCENTAGE</code> * horizontal division width.
	 * <img src="" alt="Right side rectangle's top left coordinates."></img>
	 */
	protected Point rightRectanglePoint;

	/**
	 * Middle rectangle's top left coordinates. The width of this rectangle is equal to the horizontal division width (screen width / 3.) The height is <code>RECTANGLE_HEIGHT_PERCENTAGE</code> * horizontal division width.
	 * <img src="" alt="Middle rectangle's top left coordinates."></img>
	 */
	protected Point middleRectanglePoint;

	/**
	 * Middle circle's framing rectangle's top left coordinates. The radius is equal to the horizontal division width.
	 * <img src="" alt="Middle circle's center coordinates."></img>
	 */
	protected Point middleCirclePoint;

	/**
	 * The dimension of the three rectangles.
	 * The width of this rectangle is equal to the horizontal division width (screen width / 3.) The height is <code>RECTANGLE_HEIGHT_PERCENTAGE</code> * horizontal division width.
	 */
	protected Dimension rectangleDimension;

	/**
	 * The starting point of the line from left rectangle to the circle.
	 */
	protected Point leftRectangleLinePoint;

	/**
	 * Returns the starting point of the line from left rectangle to the circle.
	 * @return The starting point of the line from left rectangle to the circle.
	 */
	public Point getLeftRectangleLinePoint()
	{
		return leftRectangleLinePoint;
	}

	/**
	 * Sets the starting point of the line from left rectangle to the circle.
	 * @param leftRectangleLinePoint The starting point of the line from left rectangle to the circle.
	 */
	public void setLeftRectangleLinePoint(Point leftRectangleLinePoint)
	{
		this.leftRectangleLinePoint = leftRectangleLinePoint;
	}

	/**
	 * The starting point of the line from right rectangle to the circle.
	 */
	protected Point rightRectangleLinePoint;

	/**
	 * Returns the starting point of the line from right rectangle to the circle.
	 * @return The starting point of the line from right rectangle to the circle.
	 */
	public Point getRightRectangleLinePoint()
	{
		return rightRectangleLinePoint;
	}

	/**
	 * Sets the starting point of the line from right rectangle to the circle.
	 * @param rightRectangleLinePoint The starting point of the line from right rectangle to the circle.
	 */
	public void setRightRectangleLinePoint(Point rightRectangleLinePoint)
	{
		this.rightRectangleLinePoint = rightRectangleLinePoint;
	}

	/**
	 * The starting point of the line from middle rectangle to the circle.
	 */
	protected Point middleRectangleLinePoint;

	/**
	 * Sets the starting point of the line from middle rectangle to the circle.
	 * @param middleRectangleLinePoint The starting point of the line from middle rectangle to the circle.
	 */
	public void setMiddleRectangleLinePoint(Point middleRectangleLinePoint)
	{
		this.middleRectangleLinePoint = middleRectangleLinePoint;
	}

	/**
	 * Returns the starting point of the line from middle rectangle to the circle.
	 * @return The starting point of the line from middle rectangle to the circle.
	 */
	public Point getMiddleRectangleLinePoint()
	{
		return middleRectangleLinePoint;
	}

	/**
	 * The ending point of the line from left rectangle to the circle.
	 */
	protected Point leftCircleLinePoint;

	/**
	 * Returns the ending point of the line from left rectangle to the circle.
	 * @return The ending point of the line from left rectangle to the circle.
	 */
	public Point getLeftCircleLinePoint()
	{
		return leftCircleLinePoint;
	}

	/**
	 * Sets the ending point of the line from left rectangle to the circle.
	 * @param leftCircleLinePoint The ending point of the line from left rectangle to the circle.
	 */
	public void setLeftCircleLinePoint(Point leftCircleLinePoint)
	{
		this.leftCircleLinePoint = leftCircleLinePoint;
	}
	
	/**
	 * The ending point of the line from right rectangle to the circle.
	 */
	protected Point rightCircleLinePoint;

	/**
	 * Returns the ending point of the line from right rectangle to the circle.
	 * @return The ending point of the line from right rectangle to the circle.
	 */
	public Point getRightCircleLinePoint()
	{
		return rightCircleLinePoint;
	}

	/**
	 * Sets the ending point of the line from right rectangle to the circle.
	 * @param rightCircleLinePoint The ending point of the line from right rectangle to the circle.
	 */
	public void setRightCircleLinePoint(Point rightCircleLinePoint)
	{
		this.rightCircleLinePoint = rightCircleLinePoint;
	}

	/**
	 * The ending point of the line from middle rectangle to the circle.
	 */
	protected Point middleCircleLinePoint;

	/**
	 * Returns the ending point of the line from middle rectangle to the circle.
	 * @return The ending point of the line from middle rectangle to the circle.
	 */
	public Point getMiddleCircleLinePoint()
	{
		return middleCircleLinePoint;
	}

	/**
	 * Sets the ending point of the line from middle rectangle to the circle.
	 * @param middleCircleLinePoint The ending point of the line from middle rectangle to the circle.
	 */
	public void setMiddleCircleLinePoint(Point middleCircleLinePoint)
	{
		this.middleCircleLinePoint = middleCircleLinePoint;
	}

	/**
	 * The dimensions of the framing rectangle of the middle circle.
	 */
	protected Dimension middleCircleFramingRectangleDimension;

	/**
	 * The bounding rectangle for the left rectangle text content.
	 */
	protected Rectangle leftTextBoundingRectangle;

	/**
	 * Returns the bounding rectangle for the left rectangle text content.
	 * @return The bounding rectangle for the left rectangle text content.
	 */
	public Rectangle getLeftTextBoundingRectangle()
	{
		return leftTextBoundingRectangle;
	}

	/**
	 * Sets the bounding rectangle for the left rectangle text content.
	 * @param leftTextBoundingRectangle The bounding rectangle for the left rectangle text content.
	 */
	public void setLeftTextBoundingRectangle(Rectangle leftTextBoundingRectangle)
	{
		this.leftTextBoundingRectangle = leftTextBoundingRectangle;
	}

	/**
	 * The bounding rectangle for the middle rectangle text content.
	 */
	protected Rectangle middleTextBoundingRectangle;

	/**
	 * Returns the bounding rectangle for the middle rectangle text content.
	 * @return The bounding rectangle for the middle rectangle text content.
	 */
	public Rectangle getMiddleTextBoundingRectangle()
	{
		return middleTextBoundingRectangle;
	}

	/**
	 * Sets the bounding rectangle for the middle rectangle text content.
	 * @param middleTextBoundingRectangle The bounding rectangle for the middle rectangle text content.
	 */
	public void setMiddleTextBoundingRectangle(Rectangle middleTextBoundingRectangle)
	{
		this.middleTextBoundingRectangle = middleTextBoundingRectangle;
	}

	/**
	 * The bounding rectangle for the right rectangle text content.
	 */
	protected Rectangle rightTextBoundingRectangle;

	/**
	 * Returns the bounding rectangle for the right rectangle text content.
	 * @return The bounding rectangle for the right rectangle text content.
	 */
	public Rectangle getRightTextBoundingRectangle()
	{
		return rightTextBoundingRectangle;
	}

	/**
	 * Sets the bounding rectangle for the right rectangle text content.
	 * @param rightTextBoundingRectangle The bounding rectangle for the right rectangle text content.
	 */
	public void setRightTextBoundingRectangle(Rectangle rightTextBoundingRectangle)
	{
		this.rightTextBoundingRectangle = rightTextBoundingRectangle;
	}

	/**
	 * The bounding rectangle for the circle rectangle text content.
	 */
	protected Rectangle circleTextBoundingRectangle;

	/**
	 * Returns the bounding rectangle for the circle rectangle text content.
	 * @return The bounding rectangle for the circle rectangle text content.
	 */
	public Rectangle getCircleTextBoundingRectangle()
	{
		return circleTextBoundingRectangle;
	}

	/**
	 * Sets the bounding rectangle for the circle rectangle text content.
	 * @param circleTextBoundingRectangle The bounding rectangle for the circle rectangle text content.
	 */
	public void setCircleTextBoundingRectangle(Rectangle circleTextBoundingRectangle)
	{
		this.circleTextBoundingRectangle = circleTextBoundingRectangle;
	}

	/**
	 * The text content of the left rectangle.
	 */
	protected String leftRectangleString;

	/**
	 * Returns the text content of the left rectangle.
	 * @return The text content of the left rectangle.
	 */
	public String getLeftRectangleString()
	{
		return leftRectangleString;
	}

	/**
	 * Sets the text content of the left rectangle.
	 * @param leftRectangleString The text content of the left rectangle.
	 */
	public void setLeftRectangleString(String leftRectangleString)
	{
		this.leftRectangleString = new String(leftRectangleString);
	}

	/**
	 * The text content of the right rectangle.
	 */
	protected String rightRectangleString;

	/**
	 * Returns the text content of the right rectangle.
	 * @return The text content of the right rectangle.
	 */
	public String getRightRectangleString()
	{
		return rightRectangleString;
	}

	/**
	 * Sets the text content of the right rectangle.
	 * @param rightRectangleString The text content of the right rectangle.
	 */
	public void setRightRectangleString(String rightRectangleString)
	{
		this.rightRectangleString = new String(rightRectangleString);
	}

	/**
	 * The text content of the middle rectangle.
	 */
	protected String middleRectangleString;

	/**
	 * Returns the text content of the middle rectangle.
	 * @return The text content of the middle rectangle.
	 */
	public String getMiddleRectangleString()
	{
		return middleRectangleString;
	}

	/**
	 * Sets the text content of the middle rectangle.
	 * @param middleRectangleString The text content of the middle rectangle.
	 */
	public void setMiddleRectangleString(String middleRectangleString)
	{
		this.middleRectangleString = new String(middleRectangleString);
	}

	/**
	 * The text content of the middle circle.
	 */
	protected String middleCircleString;

	/**
	 * Returns the text content of the middle circle.
	 * @return The text content of the middle circle.
	 */
	public String getMiddleCircleString()
	{
		return middleCircleString;
	}

	/**
	 * Sets the text content of the middle circle.
	 * @param middleCircleString The text content of the middle circle.
	 */
	public void setMiddleCircleString(String middleCircleString)
	{
		this.middleCircleString = new String(middleCircleString);
	}

	/**
	 * Initializes the data members.
	 * @param diagramType The type of diagram currently being drawn.
	 * @param numberOfSubtasks The type of diagram currently being drawn.
	 */
	public ConvergingRadialData(int diagramType, int numberOfSubtasks)
	{
		super(diagramType, numberOfSubtasks);

		circleTextBoundingRectangle = new Rectangle();
		leftCircleLinePoint = new Point();
		leftRectangleLinePoint = new Point();
		leftRectanglePoint = new Point();
		leftTextBoundingRectangle = new Rectangle();
		

		middleCircleFramingRectangleDimension = new Dimension();
		middleCircleLinePoint = new Point();
		middleCirclePoint = new Point();
		middleRectangleLinePoint = new Point();
		middleRectanglePoint = new Point();
		middleTextBoundingRectangle = new Rectangle();
		

		rectangleDimension = new Dimension();
		rightCircleLinePoint = new Point();
		rightRectangleLinePoint = new Point();
		rightRectanglePoint = new Point();
		rightTextBoundingRectangle = new Rectangle();
		
	}

	/**
	 * Returns the coordinates of the three rectangles and the circle.
	 * @return The coordinates of the three rectangles and the circle.
	 */
	@Override
	public String toString()
	{
		return (super.toString() + "[ leftRectanglePoint=" + leftRectanglePoint + "\n middleRectanglePoint=" + middleRectanglePoint + "\n rightRectanglePoint=" + rightRectanglePoint + "\n middleCirclePoint=" + middleCirclePoint + "\n leftCircleLinePoint=" + leftCircleLinePoint + "\n rightCircleLinePoint=" + rightCircleLinePoint + "\n middleCircleLinePoint=" + middleCircleLinePoint + "\n leftRectangleLinePoint=" + leftRectangleLinePoint + "\n rightRectangleLinePoint=" + rightRectangleLinePoint + "\n middleRectangleLinePoint=" + middleRectangleLinePoint + " ]");
	}

	/**
	 * Returns left side rectangle's top left coordinates.
	 * @return Left side rectangle's top left coordinates.
	 */
	public Point getLeftRectanglePoint()
	{
		return leftRectanglePoint;
	}

	/**
	 * Returns middle circle's framing rectangle's top left coordinates.
	 * @return Middle circle's framing rectangle's top left coordinates.
	 */
	public Point getMiddleCirclePoint()
	{
		return middleCirclePoint;
	}

	/**
	 * Returns middle rectangle's top left coordinates.
	 * @return Middle rectangle's top left coordinates.
	 */
	public Point getMiddleRectanglePoint()
	{
		return middleRectanglePoint;
	}

	/**
	 * Returns right side rectangle's top left coordinates.
	 * @return Right side rectangle's top left coordinates.
	 */
	public Point getRightRectanglePoint()
	{
		return rightRectanglePoint;
	}

	/**
	 * Returns the dimensions of the framing rectangle of the middle circle.
	 * @return The dimensions of the framing rectangle of the middle circle.
	 */
	public Dimension getMiddleCircleFramingRectangleDimension()
	{
		return middleCircleFramingRectangleDimension;
	}

	/**
	 * Returns the dimension of the three rectangles.
	 * The width of this rectangle is equal to the horizontal division width (screen width / 3.) The height is <code>RECTANGLE_HEIGHT_PERCENTAGE</code> * horizontal division width.
	 * @return The dimension of the three rectangles.
	 */
	public Dimension getRectangleDimension()
	{
		return rectangleDimension;
	}

	/**
	 * Sets left side rectangle's top left coordinates.
	 * @param leftRectanglePoint Left side rectangle's top left coordinates.
	 */
	public void setLeftRectanglePoint(Point leftRectanglePoint)
	{
		this.leftRectanglePoint = leftRectanglePoint;
	}

	/**
	 * Sets the dimensions of the framing rectangle of the middle circle.
	 * @param middleCircleFramingRectangleDimension The dimensions of the framing rectangle of the middle circle.
	 */
	public void setMiddleCircleFramingRectangleDimension(Dimension middleCircleFramingRectangleDimension)
	{
		this.middleCircleFramingRectangleDimension = middleCircleFramingRectangleDimension;
	}

	/**
	 * Sets middle circle's framing rectangle's top left coordinates.
	 * @param middleCirclePoint Middle circle's framing rectangle's top left coordinates.
	 */
	public void setMiddleCirclePoint(Point middleCirclePoint)
	{
		this.middleCirclePoint = middleCirclePoint;
	}

	/**
	 * Sets middle circle's framing rectangle's top left coordinates.
	 * @param middleRectanglePoint Middle circle's framing rectangle's top left coordinates.
	 */
	public void setMiddleRectanglePoint(Point middleRectanglePoint)
	{
		this.middleRectanglePoint = middleRectanglePoint;
	}

	/**
	 * Sets the dimension of the three rectangles.
	 * @param rectangleDimension The dimension of the three rectangles.
	 */
	public void setRectangleDimension(Dimension rectangleDimension)
	{
		this.rectangleDimension = rectangleDimension;
	}

	/**
	 * Sets right side rectangle's top left coordinates.
	 * @param rightRectanglePoint Right side rectangle's top left coordinates.
	 */
	public void setRightRectanglePoint(Point rightRectanglePoint)
	{
		this.rightRectanglePoint = rightRectanglePoint;
	}
}
