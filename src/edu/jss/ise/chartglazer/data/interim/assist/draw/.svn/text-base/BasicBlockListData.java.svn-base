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
 * This class holds the intermediate geometric coordinate data for the Basic Process diagram provided by the <code>CoordinateManager</code> class.
 * @author rishabh
 */
public class BasicBlockListData extends DrawingManagerData
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
	 * This rectangle is used by the <code>TextManager</code> to limit itself to render the text within the bounding rectangle.
	 */
	protected Rectangle[] boundingRectangle;

	@Override
	public String toString()
	{
		StringBuilder memberData = new StringBuilder();

		for(int i = 0; i < this.numberOfSubtasks; i++)
		{
			memberData.append("\n@ " + i + ": shapeCenterPoint = " + this.getShapeCenterPointsArray(i) + ", textCenterPoint = "+ this.getTextCenterPointsArray(i) + ", textContent = " + this.textContent[i]);
		}

		memberData.append(", subTaskRectangleDimensions = " + subTaskRectangleDimensions.toString());

		return super.toString() + memberData;
	}

	/**
	 *
	 * @param diagramType
	 * @param numberOfSubTasks
	 */
	public BasicBlockListData(int diagramType, int numberOfSubTasks)
	{
		super(diagramType, numberOfSubTasks);

		//Array a = new Array()''

		shapeCenterPointsArray = new Point[numberOfSubTasks];
		textCenterPointsArray = new Point[numberOfSubTasks];
		textContent = new String[numberOfSubTasks];
		subTaskRectangleDimensions = new Dimension();
		boundingRectangle = new Rectangle[numberOfSubTasks];

		for (int i = 0; i < numberOfSubTasks; i++)
		{
			shapeCenterPointsArray[i] = new Point();
			textCenterPointsArray[i] = new Point();
			textContent[i] = new String();
			boundingRectangle[i] = new Rectangle();
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
	 *
	 * @param i
	 * @param shapeCenterPoint
	 */
	public void setShapeCenterPointsArray(int i, Point shapeCenterPoint)
	{
		this.shapeCenterPointsArray[i].setLocation(shapeCenterPoint);
	}

	/**
	 *
	 * @param i
	 * @param textCenterPoint
	 */
	public void setTextCenterPointsArray(int i, Point textCenterPoint)
	{
		this.textCenterPointsArray[i].setLocation(textCenterPoint);
	}

	/**
	 * @param i
	 * @param textContent Contains the strings which are in the JTree, which are to be written inside the drawn shapes.
	 */
	public void setTextContent(int i, String textContent)
	{
		this.textContent[i] = textContent;
	}
}
