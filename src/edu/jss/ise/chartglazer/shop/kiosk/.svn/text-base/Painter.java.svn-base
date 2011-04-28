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
package edu.jss.ise.chartglazer.shop.kiosk;

import java.awt.Color;

/**
 * Creates a nice blended mix of two given colors.
 * @author rishabh
 */
public class Painter
{
	/**
	 * A nice blend of two given colors.
	 */
	protected Color[] blendedColors;


	/**
	 * Blends the two given colors.
	 * @param colorFrom The starting color of the blend. The first subtask background color is equal to this color.
	 * @param colorTo The ending color of the blend.
	 * @param numberOfSubtasks The number of color blends to be calculated.
	 */
	public Painter(Color colorFrom, Color colorTo, int numberOfSubtasks)
	{
		int changeFactor[] = {0, 0, 0};

		this.blendedColors = new Color[numberOfSubtasks];

		this.blendedColors[0] = colorFrom;

		if(1 == numberOfSubtasks)
		{
			return;
		}

		if(2 == numberOfSubtasks)
		{

			this.blendedColors[1] = colorTo;
			return;
		}
		else
		{
			int colorFromArray[] = {colorFrom.getRed(), colorFrom.getGreen(), colorFrom.getBlue()};
			int colorToArray[] = {colorTo.getRed(), colorTo.getGreen(), colorTo.getBlue()};

			for(int i = 0; i < 3; i++)
			{
				changeFactor[i] = ((colorToArray[i] - colorFromArray[i]) / (numberOfSubtasks - 1));
			}

			for(int i = 1; i <= (numberOfSubtasks - 2); i++)
			{
				this.blendedColors[i] = new Color(blendedColors[i - 1].getRed() + changeFactor[0], blendedColors[i - 1].getGreen() + changeFactor[1], blendedColors[i - 1].getBlue() + changeFactor[2]);
			}

			this.blendedColors[numberOfSubtasks - 1] = colorTo;
		}
	}

	/**
	 * @param i The subtask position for which the color is required.
	 * @return The color blend for subtask at position <code>i</code>.
	 */
	public Color getBlendedColors(int i)
	{
		return this.blendedColors[i];
	}
}
