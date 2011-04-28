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
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * An auxiliary rectangle which will act as a supporting rectangle.
 * A rectangular shape implementation built on top of the <code>java.awt.Rectangle</code> class.
 * @author rishabh
 */
public class cgAuxRectangle extends cgAuxShape
{
	/**
	 * The core rectangle object is the bare metal (skeletal framework) of the rectangle.
	 * It will be painted and stylized later on.
	 */
	protected Rectangle rectangle;

	/**
	 * Creates an empty rectangle, whose width and height are zero.
	 */
	public cgAuxRectangle()
	{
		super();
		rectangle = new Rectangle();
	}

	/**
	 * Constructs the rectangle given the shapeCenter and size.
	 * @param shapeCenter 
	 * @param size
	 * @throws IllegalArgumentException In case <code>size</code> was sent as null.
	 */
	public cgAuxRectangle(Point shapeCenter, Dimension size) throws IllegalArgumentException
	{
		// because textCenter equals shapeCenter, the call is made by passing <code>shapeCenter</code> instead of <code>textCenter</code>.
		super(shapeCenter);

		// do not allow null size Dimensions.
		if (null == size)
		{
			throw new IllegalArgumentException("The Dimension size cannot be null.");
		}

		// proceed if everything is in order.
		this.size = new Dimension(size);
		rectangle = new Rectangle(super.shapeCenter, this.size);
	}

	/**
	 * Once the rectangle is drawn-in-memory, it is returned to the drawing API (for example, Apache Batik) for rendering.
	 * @return this rectangle, type-casted as a shape.
	 */
	@Override
	public Shape getShape()
	{
		return (Shape) rectangle;
	}
}
