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
import java.awt.geom.RoundRectangle2D;

/**
 * A rectangular shape implementation built on top of the <code>java.awt.Rectangle</code> class.
 * @author rishabh
 */
public class cgTaskRectangle extends cgShape
{
	/**
	 * The core rectangle object is the bare metal (skeletal framework) of the rectangle.
	 * It will be painted and stylized later on.
	 */
	protected RoundRectangle2D rectangle;
	/**
	 *
	 */
	protected float arcWidth = 15.0f;
	/**
	 *
	 */
	protected float arcHeight = 15.0f;

	/**
	 * Creates an empty rectangle, whose width and height are zero.
	 */
	public cgTaskRectangle()
	{
		super();
		rectangle = new RoundRectangle2D.Float();
	}

	/**
	 * Creates a new rectangle based on <code>shapeCenter</code>, <code>size</code>, <code>textCenter</code>, <code>textContent</code>.
	 * @param shapeCenter The center coordinates of the shape.
	 * @param size The width and height of the rectangle in a <code>Dimension</code> object.
	 * @throws IllegalArgumentException In case <code>size</code> was sent as null.
	 */
	public cgTaskRectangle(Point shapeCenter, Dimension size) throws IllegalArgumentException
	{
		super(shapeCenter, size);

		rectangle = new RoundRectangle2D.Float(super.shapeCenter.x, super.shapeCenter.y, this.size.width, this.size.height, this.arcWidth, this.arcHeight);
	}

	/**
	 * In the case of a rectangle, the <code>textCenter</code> can be ignored.
	 * It will be assumed to be equal to <code>shapeCenter</code>.
	 * @param shapeCenter The center coordinates of the shape.
	 * @param size The width and height of the rectangle in a <code>Dimension</code> object.
	 * @param textContent The textual content that must be placed inside this shape.
	 * @throws IllegalArgumentException In case <code>size</code> was sent as null.
	 */
	public cgTaskRectangle(Point shapeCenter, Dimension size, String textContent) throws IllegalArgumentException
	{
		// because textCenter equals shapeCenter, the call is made by passing <code>shapeCenter</code> instead of <code>textCenter</code>.	        
		super(shapeCenter, size);

		rectangle = new RoundRectangle2D.Float(super.shapeCenter.x, super.shapeCenter.y, this.size.width, this.size.height, this.arcWidth, this.arcHeight);
	}

	/**
	 * Once the rectangle is drawn-in-memory, it is returned to the drawing API (for example, Apache Batik) for rendering.
	 * @return this rectangle, type-casted as a Shape.
	 */
	@Override
	public Shape getShape()
	{
		return (Shape) rectangle;
	}
}
