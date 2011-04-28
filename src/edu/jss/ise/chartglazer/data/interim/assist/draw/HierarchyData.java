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

import edu.jss.ise.chartglazer.process.calc.assist.HierarchyCalc;
import edu.jss.ise.chartglazer.shop.showcase.cgAuxLine;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * This class holds the intermediate geometric coordinate data for the Hierarchy diagram provided by the <code>CoordinateManager</code> class.
 * @author naren
 */
public class HierarchyData extends DrawingManagerData
{
	/**
	 * The center coordinates of the shape. The entire shape is centered about this point. Usually, this is equal to <code>textCenter</code>.
	 */
	protected Point[] shapeCenterPointsArray;
	/**
	 * The coordinates of the text anchor (middle) for the text which is going to be displayed. Usually, this is equal to <code>shapeCenter</code>.
	 */
	protected Point[] textCenterPointsArray;
	/**
	 * Contains the strings which are in the JTree, which are to be written inside the drawn shapes.
	 */
	protected String[] textContent;
	/**
	 * The dimensions of the bounding rectangle for the text.
	 */
	protected Dimension subTaskRectangleDimensions;
		/**
	 * This set of lines gives the connecting line between any parent and its child.
	 */
	protected cgAuxLine[] connectingLines;
	/**
	 * This rectangle is used by the <code>TextManager</code> to limit itself to render the text within the bounding rectangle.
	 * The text content is made to fit inside this bounding rectangle.
	 */
	protected Rectangle[] boundingRectangle;

	/**
	 * Contains the number of nodes in each level.
	 * First index of child array holds number of children in first level, second index of child array holds number of children in second level and so on.
	 * Excluding the root.
	 * @deprecated Using a static memory allocation will consume heap memory unnecessarily.
	 */
	@Deprecated
	protected int[] child = new int[HierarchyCalc.BIG_NUMBER];

	public HierarchyData(int diagramType, int numberOfSubTasks)
	{
		super(diagramType, numberOfSubTasks);

		shapeCenterPointsArray = new Point[numberOfSubTasks];
		textCenterPointsArray = new Point[numberOfSubTasks];
		textContent = new String[numberOfSubTasks];
		subTaskRectangleDimensions = new Dimension();
		boundingRectangle = new Rectangle[numberOfSubTasks];
		connectingLines = new cgAuxLine[numberOfSubTasks - 1];
		for (int i = 0; i < numberOfSubTasks; i++)
		{
			shapeCenterPointsArray[i] = new Point();
			textCenterPointsArray[i] = new Point();
			textContent[i] = new String();
			boundingRectangle[i] = new Rectangle();
		}

		for (int i = 0; i < numberOfSubTasks - 1; i++)
		{
			connectingLines[i] = new cgAuxLine();
		}
	}

	/**
	 * @param i The index at which the array is stored in memory.
	 * @return This rectangle is used by the <code>TextManager</code> to limit itself to render the text within the bounding rectangle.
	 */
	public Rectangle getBoundingRectangle(int i)
	{
		return boundingRectangle[i];
	}

	/**
	 * @param i The index at which the array is stored in memory.
	 * @param boundingRectangle This rectangle is used by the <code>TextManager</code> to limit itself to render the text within the bounding rectangle.
	 */
	public void setBoundingRectangle(int i, Rectangle boundingRectangle)
	{
		this.boundingRectangle[i] = boundingRectangle;
	}

	/**
	 * @return The center coordinates of the shape. The entire shape is centered about this point. Usually, this is equal to <code>textCenter</code>.
	 */
	public Point[] getShapeCenterPointsArray()
	{
		return shapeCenterPointsArray;
	}

	/**
	 * @return The coordinates of the text anchor (middle) for the text which is going to be displayed. Usually, this is equal to <code>shapeCenter</code>.
	 */
	public Point[] getTextCenterPointsArray()
	{
		return textCenterPointsArray;
	}

	/**
	 * @param i The index of the Point which is required.
	 * @return The center coordinates of the shape. The entire shape is centered about this point. Usually, this is equal to <code>textCenter</code>.
	 */
	public Point getShapeCenterPointsArray(int i)
	{
		return shapeCenterPointsArray[i];
	}

	/**
	 * @param i The index of the Point which is required.
	 * @return The coordinates of the text anchor (middle) for the text which is going to be displayed. Usually, this is equal to <code>shapeCenter</code>.
	 */
	public Point getTextCenterPointsArray(int i)
	{
		return textCenterPointsArray[i];
	}

	/**
	 * @return Contains the strings which are in the JTree, which are to be written inside the drawn shapes.
	 */
	public String[] getTextContent()
	{
		return textContent;
	}

	/**
	 * @return The dimensions of the bounding rectangle for the text.
	 */
	public Dimension getSubTaskRectangleDimensions()
	{
		return subTaskRectangleDimensions;
	}

	/**
	 * @param subTaskRectangleDimensions The dimensions of the bounding rectangle for the text.
	 */
	public void setSubTaskRectangleDimensions(Dimension subTaskRectangleDimensions)
	{
		this.subTaskRectangleDimensions.setSize(subTaskRectangleDimensions);
	}

	/**
	 * @param i The index at which the value is to be set.
	 * @param shapeCenterPoint The center coordinates of the shape. The entire shape is centered about this point. Usually, this is equal to <code>textCenter</code>.
	 */
	public void setShapeCenterPointsArray(int i, Point shapeCenterPoint)
	{
		this.shapeCenterPointsArray[i].setLocation(shapeCenterPoint);
	}

	/**
	 * @param i The index at which the value is to be set.
	 * @param textCenterPoint The coordinates of the text anchor (middle) for the text which is going to be displayed. Usually, this is equal to <code>shapeCenter</code>.
	 */
	public void setTextCenterPointsArray(int i, Point textCenterPoint)
	{
		this.textCenterPointsArray[i].setLocation(textCenterPoint);
	}

	/**
	 * @param i The index at which the value is to be set.
	 * @param textContent Contains the strings which are in the JTree, which are to be written inside the drawn shapes.
	 */
	public void setTextContent(int i, String textContent)
	{
		this.textContent[i] = textContent;
	}

	/**
	 * @param i The index at which the value is to be obtained.
	 * @return The line connecting the subtasks at index, <code>i</code>.
	 */
	public cgAuxLine getConnectingLines(int i)
	{
		return connectingLines[i];
	}

	/**
	 * @param i The index at which the value is to be set.
	 * @param p1 The starting point of the line.
	 * @param p2 The ending point of the line.
	 */
	public void setConnectingLines(int i, Point p1, Point p2)
	{

		Dimension d = new Dimension();
		d = getSubTaskRectangleDimensions();
		Point p = new Point((p1.x + (d.width / 2)), ((p1.y + (d.height))));
//		p = p1(x + (d.width/2),y+(d.height));
		connectingLines[i].setP1(p);
		Point pp = new Point((p2.x + (d.width / 2)), ((p2.y)));
		connectingLines[i].setP2(pp);
	}

	/**
	 * Returns the values of the </code>child</code> array.
	 * @return The values of the </code>child</code> array.
	 * @see #child
	 */
	public int[] getChild()
	{
		return child;
	}

	/**
	 * Sets the values of the </code>child</code> array.
	 * @param child The values of the </code>child</code> array.
	 * @see #child
	 */
	public void setChild(int[] child)
	{
		this.child = child;
	}
}
