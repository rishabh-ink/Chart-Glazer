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
package edu.jss.ise.chartglazer.process.calc;

import edu.jss.ise.chartglazer.data.interim.assist.calc.CoordinateManagerData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.DrawingManagerData;

/**
 * Provides a standard format for all assistant classes of <code>CoordinateManager</code>.
 * @author naren
 */
public interface ICalculateCoordinates
{
	/**
	 * This is the standard function that all the assistant classes of <code>CoordinateManager</code> must implement.
	 * @param cmData The interim information that is required by the <code>CoordinateManager</code> class.
	 * @return Common data required for drawing the diagram.
	 * @throws Exception
	 */
	public DrawingManagerData calculateCoordinates(CoordinateManagerData cmData) throws Exception;
}
