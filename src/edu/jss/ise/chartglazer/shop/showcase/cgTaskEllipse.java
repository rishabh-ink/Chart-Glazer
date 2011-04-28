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
import java.awt.geom.Ellipse2D;

/**
 * Draws a ellipse using the Ellipse2D class.
 * @author rishabh
 */
public class cgTaskEllipse extends cgShape
{
	/**
	 * This is the ellipse which will be returned to <code>DrawingManager</code>.
	 */
	protected Ellipse2D ellipse;

	/**
	 * Empty ellipse.
	 */
	public cgTaskEllipse()
	{
		super();
		ellipse = new Ellipse2D.Double();
	}

	/**
	 * Creates a new ellipse based on the given shapeCenter and size values.
	 */
	public cgTaskEllipse(Point shapeCenter, Dimension size)
	{
		super(shapeCenter, size);
		ellipse = new Ellipse2D.Double(shapeCenter.x, shapeCenter.y, size.width, size.height);
	}

	@Override
	public Shape getShape()
	{
		return ellipse;
	}
}
