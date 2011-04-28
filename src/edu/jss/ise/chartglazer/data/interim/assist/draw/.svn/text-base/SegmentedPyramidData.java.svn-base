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

import edu.jss.ise.chartglazer.shop.showcase.cgAuxTriangle;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * // TODO put segmented pyramid  image here
 * @author rishabh
 */
public class SegmentedPyramidData extends DrawingManagerData
{
	/**
	 * <img src="" alt="Left hand side triangle."></img>
	 */
	public static final int LEFT_TRIANGLE = 0;
	/**
	 * <img src="" alt="Middle triangle."></img>
	 */
	public static final int MIDDLE_TRIANGLE = 1;
	/**
	 * <img src="" alt="Right hand side triangle."></img>
	 */
	public static final int RIGHT_TRIANGLE = 2;
	/**
	 * <img src="" alt="Top triangle."></img>
	 */
	public static final int TOP_TRIANGLE = 3;
	/**
	 * <img src="" alt="Big outer triangle."></img>
	 */
	public static final int OUTER_TRIANGLE = 4;

	/**
	 * Contains the base center coordinates of the four triangles in this Segmented Pyramid diagram.
	 */
	protected Point[] baseCenterPointsArray;
	/**
	 * Specifies a bounding rectangle inside which the text will be wrapped.
	 */
	protected Rectangle[] textBoundingRectangle;
	/**
	 * The length of the side of the four equilateral triangles.
	 * All the four triangles in this Segmented Pyramid diagram are equilateral and have the same dimensions.
	 */
	protected int triangleSideLength;

	/**
	 * The side length of the outer triangle, which encloses the other four triangles.
	 */
	protected int outerTriangleSideLength;

	/**
	 * The two side triangles and the top triangle face NORTH, while the middle triangle faces SOUTH.
	 * Order of declaration is left-triangle, middle-triangle, right-triangle, top-triangle.
	 */
	protected final int facingDirection[] = { cgAuxTriangle.FACE_NORTH, cgAuxTriangle.FACE_SOUTH, cgAuxTriangle.FACE_NORTH, cgAuxTriangle.FACE_NORTH };

	/**
	 * Allocates memory for the data members.
	 * @param diagramType The type of diagram currently being drawn.
	 * @param numberOfSubTasks The type of diagram currently being drawn.
	 */
	public SegmentedPyramidData(int diagramType, int numberOfSubTasks)
	{
		super(diagramType, numberOfSubTasks);

		baseCenterPointsArray[LEFT_TRIANGLE] = new Point();
		textBoundingRectangle[LEFT_TRIANGLE] = new Rectangle();

		baseCenterPointsArray[MIDDLE_TRIANGLE] = new Point();
		textBoundingRectangle[MIDDLE_TRIANGLE] = new Rectangle();

		baseCenterPointsArray[RIGHT_TRIANGLE] = new Point();
		textBoundingRectangle[RIGHT_TRIANGLE] = new Rectangle();

		baseCenterPointsArray[TOP_TRIANGLE] = new Point();
		textBoundingRectangle[TOP_TRIANGLE] = new Rectangle();

		baseCenterPointsArray[OUTER_TRIANGLE] = new Point();
		textBoundingRectangle[OUTER_TRIANGLE] = new Rectangle();
	}

	/**
	 * @param i The index at which this new value should be set.
	 * @param baseCenterPointsArray Contains the base center coordinates of the four triangles in this Segmented Pyramid diagram.
	 */
	public void setBaseCenterPointsArray(int i, Point baseCenterPointsArray)
	{
		this.baseCenterPointsArray[i] = baseCenterPointsArray;
	}

	/**
	 * @param i The index at which this new value should be set.
	 * @param textBoundingRectangle Specifies a bounding rectangle inside which the text will be wrapped.
	 */
	public void setTextBoundingRectangle(int i, Rectangle textBoundingRectangle)
	{
		this.textBoundingRectangle[i] = textBoundingRectangle;
	}

	/**
	 * All the four triangles in this Segmented Pyramid diagram are equilateral and have the same dimensions.
	 * @param triangleSideLength The length of the side of the four equilateral triangles.
	 */
	public void setTriangleSideLength(int triangleSideLength)
	{
		this.triangleSideLength = triangleSideLength;
	}

	/**
	 * @param i The index at which the base center point should be obtained.
	 * @return Contains the base center coordinates of the four triangles in this Segmented Pyramid diagram.
	 */
	public Point getBaseCenterPointsArray(int i)
	{
		return baseCenterPointsArray[i];
	}

	/**
	 * @param i The index at which the bounding rectangle should be obtained.
	 * @return Specifies a bounding rectangle inside which the text will be wrapped.
	 */
	public Rectangle getTextBoundingRectangle(int i)
	{
		return textBoundingRectangle[i];
	}

	/**
	 * @return The length of the side of the four equilateral triangles.
	 */
	public int getTriangleSideLength()
	{
		return triangleSideLength;
	}

	/**
	 * @return The side length of the outer triangle, which encloses the other four triangles.
	 */
	public int getOuterTriangleSideLength()
	{
		return outerTriangleSideLength;
	}

	/**
	 * @param outerTriangleSideLength The side length of the outer triangle, which encloses the other four triangles.
	 */
	public void setOuterTriangleSideLength(int outerTriangleSideLength)
	{
		this.outerTriangleSideLength = outerTriangleSideLength;
	}
}
