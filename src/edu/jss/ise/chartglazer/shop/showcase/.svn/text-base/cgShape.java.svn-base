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
package edu.jss.ise.chartglazer.shop.showcase;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;

/**
 * Contains the common features for all the shapes:
 * A Point object holds the center point of each shape.
 * @author rishabh
 */
abstract public class cgShape
{

	/**
	 * The center coordinates of the shape. The entire shape is centered about this point. Usually, this is equal to <code>textCenter</code>.
	 * @see textCenter
	 */
	protected Point shapeCenter;
	/**
	 * The dimensions (width x height) of this shape.
	 */
	protected Dimension size;

	/**
	 * Creates empty implementaions for data members.
	 */
	public cgShape()
	{
		
		this.shapeCenter = new Point();
		this.size = new Dimension();
	}

	/**
	 * Some shapes do not need text content (for example, arrow marks etc.) so no text for them.
	 * @param shapeCenter The center coordinates of the shape.
	 //* @param size The dimensions (width x height) of this shape.
	 * @throws IllegalArgumentException In case <code>shapeCenter</code> was sent as null.
	 */
	public cgShape(Point shapeCenter) throws IllegalArgumentException
	{
		
		this.shapeCenter = new Point(shapeCenter);
		//this.size = new Dimension(size);
	}

	/**
	 * Some shapes do not need text content (for example, arrow marks etc.) so no text for them.
	 * @param shapeCenter The center coordinates of the shape.
	 * @param size The dimensions (width x height) of this shape.
	 * @throws IllegalArgumentException In case <code>shapeCenter</code> was sent as null.
	 */
	public cgShape(Point shapeCenter, Dimension size) throws IllegalArgumentException
	{
		this.shapeCenter = new Point(shapeCenter);
		this.size = new Dimension(size);
	}

	/**
	 * After drawing-in-memory the shape, return the <code>Shape</code> object.
	 * Thus any of the drawing libraries (for example, Apache Batik) can use this shape.
	 * All sub-classes of <code>cgShape</code> are supposed to override this method. For example, the <code>cgRectangle</code> class will return it's <code>Rectangle</code> object.
	 * @return The drawn-in-memory shape in a <code>Shape</code> object.
	 * @see chartglazershapes.cgShape
	 * @see java.awt.Rectangle
	 * @see java.awt.Shape
	 */
	abstract public Shape getShape();

	/**
	 * @return The center coordinates of the shape. The entire shape is centered about this point. Usually, this is equal to <code>textCenter</code>.
	 */
	public Point getShapeCenter()
	{
		return shapeCenter;
	}

	/**
	 * @return The current dimensions (width x height) of this rectangle.
	 */
	public Dimension getSize()
	{
		return size;
	}

	/**
	 * @param shapeCenter The center coordinates of the shape. The entire shape is centered about this point. Usually, this is equal to <code>textCenter</code>.
	 */
	public void setShapeCenter(Point shapeCenter)
	{
		this.shapeCenter = shapeCenter;
	}

	/**
	 * @param size The new dimensions (width x height) of this rectangle.
	 */
	public void setSize(Dimension size)
	{
		this.size = size;
	}

	@Override
	public String toString()
	{
		return ("[shapeCenter=" + this.shapeCenter.toString() + ", size=" + this.size.toString() +"]");
	}

	
}
