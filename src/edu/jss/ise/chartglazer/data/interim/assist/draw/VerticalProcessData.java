/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.jss.ise.chartglazer.data.interim.assist.draw;

import edu.jss.ise.chartglazer.shared.CGLogger;
import edu.jss.ise.chartglazer.shop.showcase.cgAuxTriangle;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.logging.Level;


/**
 *
 * @author naren
 */
public class VerticalProcessData extends DrawingManagerData
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

	/**
	 * These points gives the base center points of the triangles and is used to point to the next process.
	 */
	protected Point[] arrowBaseCenterPointsArray;

	/**
	 * The side length of the equilateral triangle which is used as an arrow.
	 */
	protected int arrowBaseLength;

	/**
	 * One of the four directions, <code>FACE_NORTH</code>, <code>FACE_EAST</code>, <code>FACE_SOUTH</code> or <code>FACE_WEST</code>, that the triangle must face.
	 */
	protected int arrowFacingDirection;


	/**
	 *
	 * @param diagramType
	 * @param numberOfSubTasks
	 */
	public VerticalProcessData(int diagramType, int numberOfSubTasks)
	{
		super(diagramType, numberOfSubTasks);

		//Array a = new Array()''

		shapeCenterPointsArray = new Point[numberOfSubTasks];
		textCenterPointsArray = new Point[numberOfSubTasks];
		textContent = new String[numberOfSubTasks];
		subTaskRectangleDimensions = new Dimension();
		boundingRectangle = new Rectangle[numberOfSubTasks];
		arrowBaseCenterPointsArray = new Point[numberOfSubTasks];

		for (int i = 0; i < numberOfSubTasks; i++)
		{
			shapeCenterPointsArray[i] = new Point();
			textCenterPointsArray[i] = new Point();
			textContent[i] = new String();
			boundingRectangle[i] = new Rectangle();
			arrowBaseCenterPointsArray[i] = new Point();
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

	/**
	 * @param i The index of the point which is required.
	 * @return The base center point of the arrow mark (triangle.)
	 */
	public Point getArrowBaseCenterPointsArray(int i)
	{
		return arrowBaseCenterPointsArray[i];
	}

	/**
	 * @return The base center point of the arrow mark (triangle.)
	 */
	public Point[] getArrowBaseCenterPointsArray()
	{
		return arrowBaseCenterPointsArray;
	}



	/**
	 * @return One of the four directions, <code>FACE_NORTH</code>, <code>FACE_EAST</code>, <code>FACE_SOUTH</code> or <code>FACE_WEST</code>, that the triangle must face.
	 */
	public int getArrowFacingDirection()
	{
		return arrowFacingDirection;
	}

	/**
	 * @param arrowFacingDirection One of the four directions, <code>FACE_NORTH</code>, <code>FACE_EAST</code>, <code>FACE_SOUTH</code> or <code>FACE_WEST</code>, that the triangle must face.
	 */
	public void setArrowFacingDirection(int arrowFacingDirection)
	{
		switch(arrowFacingDirection)
		{
			case cgAuxTriangle.FACE_NORTH:
			case cgAuxTriangle.FACE_EAST:
			case cgAuxTriangle.FACE_SOUTH:
			case cgAuxTriangle.FACE_WEST:

				this.arrowFacingDirection = arrowFacingDirection;
				break;

			default:
				CGLogger.trace(Level.SEVERE, "Arrow facing direction was passed a wrong direction value." + arrowFacingDirection);
				throw new IllegalArgumentException("Arrow facing direction was passed a wrong direction value: " + arrowFacingDirection);
		}
	}

	/**
	 * @param i The index of the point which is to be set.
	 * @param arrowBaseCenterPointsArray The base center point of the arrow mark (triangle.)
	 */
	public void setArrowBaseCenterPointsArray(int i, Point arrowBaseCenterPointsArray)
	{
		this.arrowBaseCenterPointsArray[i] = arrowBaseCenterPointsArray;
	}

	/**
	 * @param arrowTriangleBaseLength The side length of the equilateral triangle which is used as an arrow.
	 */
	public void setArrowTriangleBaseLength(int arrowTriangleBaseLength)
	{
		this.arrowBaseLength = arrowTriangleBaseLength;
	}

	/**
	 * @return The side length of the equilateral triangle which is used as an arrow.
	 */
	public int getArrowTriangleBaseLength()
	{
		return arrowBaseLength;
	}

}
