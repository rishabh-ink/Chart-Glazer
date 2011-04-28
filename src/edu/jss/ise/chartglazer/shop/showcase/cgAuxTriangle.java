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

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;

/**
 *
 * @author rishabh
 */
public class cgAuxTriangle extends cgAuxShape
{
	/**
	 * Pass this constant as an argument to get a north-facing (top side) triangle.
	 */
	public static final int FACE_NORTH = 12;
	/**
	 * Pass this constant as an argument to get a east-facing (right-hand side) triangle.
	 */
	public static final int FACE_EAST = 3;
	/**
	 * Pass this constant as an argument to get a south-facing (bottom side) triangle.
	 */
	public static final int FACE_SOUTH = 6;
	/**
	 * Pass this constant as an argument to get a west-facing (left-hand side) triangle.
	 */
	public static final int FACE_WEST = 9;

	/**
	 * Array of x coordinates of the three sides of the triangle.
	 */
	private int xArray[] = { 0, 0, 0 };
	/**
	 * Array of y coordinates of the three sides of the triangle.
	 */
	private int yArray[] = { 0, 0, 0 };

	/**
	 * This rendered <code>triangle</code> is the <code>Shape</code> object that is returned back.
	 */
	protected Polygon triangle;

	/**
	 * Draws a triangle, of side length equal to <code>length</code> at the requested <code>baseCenter</code> point.
	 * @param baseCenter The midpoint of the base of the triangle.
	 * @param length The length of the side of this equilateral triangle.
	 * @param faceWhere One of the four directions, <code>FACE_NORTH</code>, <code>FACE_EAST</code>, <code>FACE_SOUTH</code> or <code>FACE_WEST</code>, that the triangle must face.
	 */
	public cgAuxTriangle(Point baseCenter, int length, int faceWhere)
	{
		super(baseCenter);
		int lengthSquared = (int) Math.pow(length, 2);
		int halfLengthSquared = (int) Math.pow((length / 2), 2);
		int height = (int) Math.sqrt(lengthSquared - halfLengthSquared);

		switch(faceWhere)
		{
			case FACE_SOUTH:
			{
				xArray[0] = baseCenter.x - (length / 2);
				yArray[0] = (baseCenter.y);

				xArray[1] = baseCenter.x + (length / 2);
				yArray[1] = (baseCenter.y);

				xArray[2] = baseCenter.x;
				yArray[2] = (baseCenter.y + height);


				break;
			}

			case FACE_EAST:
			{
				xArray[0] = baseCenter.x;
				yArray[0] = (baseCenter.y + (length / 2));

				xArray[1] = baseCenter.x;
				yArray[1] = (baseCenter.y - (length / 2));

				xArray[2] = baseCenter.x + height;
				yArray[2] = baseCenter.y;



				break;
			}

			case FACE_NORTH:
			{
				xArray[0] = baseCenter.x - (length / 2);
				yArray[0] = (baseCenter.y);

				xArray[1] = baseCenter.x + (length / 2);
				yArray[1] = (baseCenter.y);

				xArray[2] = baseCenter.x;
				yArray[2] = (baseCenter.y - height);
				break;
			}

			case FACE_WEST:
			{
				xArray[0] = baseCenter.x;
				yArray[0] = (baseCenter.y + (length / 2));

				xArray[1] = baseCenter.x;
				yArray[1] = (baseCenter.y - (length / 2));

				xArray[2] = baseCenter.x  - height;
				yArray[2] = baseCenter.y;


				break;
			}
		}

		 triangle = new Polygon(xArray, yArray, 3);
	}

	/**
	 * Calls the <code>toString</code> method of this <code>triangle</code>, which is a <code>Polygon</code> object.
	 * @return
	 */
	@Override
	public String toString()
	{
		return ("[" + super.toString() + ", " + this.triangle.toString() + "]");
	}



	@Override
	public Shape getShape()
	{
		return this.triangle;
	}
}
