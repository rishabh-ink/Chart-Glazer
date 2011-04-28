package edu.jss.ise.chartglazer.shop.kiosk;

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


import edu.jss.ise.chartglazer.shared.CGLogger;
import edu.jss.ise.chartglazer.shop.showcase.cgTaskRectangle;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;
import edu.jss.ise.chartglazer.shared.IShapeTypes;
import edu.jss.ise.chartglazer.shop.showcase.cgAuxTriangle;
import edu.jss.ise.chartglazer.shop.showcase.cgTaskEllipse;
import java.util.logging.Level;

/**
 * Deals with extraction of a requested shape.
 * @author rishabh
 */
public class ShapesManager
{
	/**
	 * Creates (draws-in-memory) the requested shape.
	 * @param shapeType one of types.IShapeTypes constant values denoting the shape type.
	 * @param shapeCenter The center (x, y) coordinates of this shape.
	 * @param textCenter The coordinates of  text anchor (middle) for the text which is going to be displayed.
	 * @param size The size (width, height) of this shape.
	 * @param textContent The textual content that must be written inside.
	 * @return A Shape object that is completely rendered, painted and stylized.
	 * @throws IllegalArgumentException In case of illegal arguments, rethrow to Glazer class.
	 */
	public Shape createSubtaskShape(int shapeType, Point shapeCenter, Point textCenter, Dimension size, String textContent) throws IllegalArgumentException
	{
		// TODO delete textCenter and textContent from here, because now TextManager will deal with text, not ShapeManager
		CGLogger.trace("Creating shape: [shapeType = " + shapeType + ", shapeCenter = " + shapeCenter.toString() + ", size = " + size.toString() + ", textContent = " + textContent);

		Shape currentShape = null;

		try
		{
			switch(shapeType)
			{
				case IShapeTypes.TASK_RECTANGLE:
				{
					cgTaskRectangle tr = new cgTaskRectangle(shapeCenter, size);
					currentShape = tr.getShape();
					break;
				}

				case IShapeTypes.ELLIPSE:
				{
					cgTaskEllipse te = new cgTaskEllipse(shapeCenter, size);
					currentShape = te.getShape();
					break;
				}

				default:
				{
					CGLogger.trace(Level.SEVERE, "Received invalid shape type: " + shapeType);
					throw new IllegalArgumentException("Received invalid shape type: " + shapeType);
				}
			}

			// TODO Paint the shape
			// TODO Style the shape
		}
		catch(IllegalArgumentException iae)
		{
			// all exceptions are handled by the Glazer, controller class
			throw iae;
		}

		return currentShape;
	}

	/**
	 * Creates (draws-in-memory) the requested shape.
	 * @param shapeType one of types.IShapeTypes constant values denoting the shape type.
	 * @param shapeCenter The center (x, y) coordinates of this shape.
	 * @param length The length of the aux shape.
	 * @param faceDirection The direction in which this aux shape should face.
	 * @return A Shape object that is completely rendered, painted and stylized.
	 * @throws IllegalArgumentException In case of illegal arguments, rethrow to Glazer class.
	 */
	public Shape createAuxShape(int shapeType, Point shapeCenter, int length, int faceDirection) throws IllegalArgumentException
	{
		Shape currentShape = null;

		try
		{
			switch(shapeType)
			{
				case IShapeTypes.AUX_TRIANGLE:
				{
					cgAuxTriangle at = new cgAuxTriangle(shapeCenter, length, faceDirection);
					currentShape = at.getShape();
					break;
				}

				default:
				{
					CGLogger.trace(Level.SEVERE, "Received invalid shape type: " + shapeType);
					throw new IllegalArgumentException("Received invalid shape type: " + shapeType);

				}
			}

			// TODO Paint the shape
			// TODO Style the shape
		}
		catch(IllegalArgumentException iae)
		{
			// all exceptions are handled by the Glazer, controller class
			throw iae;
		}

		return currentShape;
	}
}
