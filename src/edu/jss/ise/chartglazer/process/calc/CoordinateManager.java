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
import edu.jss.ise.chartglazer.data.interim.assist.draw.BasicProcessData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.DrawingManagerData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.HierarchyData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.VerticalProcessData;
import edu.jss.ise.chartglazer.process.calc.assist.BasicBlockListCalc;
import edu.jss.ise.chartglazer.process.calc.assist.BasicProcessCalc;
import edu.jss.ise.chartglazer.process.calc.assist.ConvergingRadialCalc;
import edu.jss.ise.chartglazer.process.calc.assist.HierarchyCalc;
import edu.jss.ise.chartglazer.process.calc.assist.NondirectionalCycleCalc;
import edu.jss.ise.chartglazer.process.calc.assist.VerticalProcessCalc;
import edu.jss.ise.chartglazer.shared.CGLogger;
import edu.jss.ise.chartglazer.shared.IDiagramTypes;
import java.util.logging.Level;

/**
 * This class deals with the overall management of coordinate calculation.
 * @author rishabh
 */
public class CoordinateManager
{
	/**
	 * This holds the interim information that is required by the <code>CoordinateManager</code> class.
	 */
	CoordinateManagerData cmData;
	/**
	 * This holds the interim information that is required by the <code>DrawingManager</code> class.
	 */
	DrawingManagerData dmData;

	/**
	 * Allocates memory for the <code>CoordinateManagerData</code> class object, <code>cmData</code>.
	 */
	public CoordinateManager()
	{
		cmData = new CoordinateManagerData();
	}

	/**
	 * @param cmData This holds the interim information that is required by the <code>CoordinateManager</code> class.
	 */
	public void setCmData(CoordinateManagerData cmData)
	{
		this.cmData = cmData;
	}

	/**
	 * Delegates the coordinate calculation work to it's assistant classes based on the diagram type.
	 * @return The calculated coordinates in a form which is understood by <code>DiagramManager</code>.
	 * @throws Exception All exceptions are handled in the main Glazer class.
	 */
	public DrawingManagerData calculateCoordinates() throws Exception
	{
		CGLogger.trace("cmData is " + cmData.toString());

		switch (cmData.getDiagramType())
		{
			case IDiagramTypes.BASIC_PROCESS:
			{
				CGLogger.trace("Entering coordinate calculation case for IDiagramTypes.BASIC_PROCESS...");
				BasicProcessCalc bpCalc = new BasicProcessCalc();
				
				dmData = bpCalc.calculateCoordinates(this.cmData);

				break;
			}

			case IDiagramTypes.NONDIRECTIONAL_CYCLE:
			{
				CGLogger.trace("Entering coordinate calculation case for IDiagramTypes.NONDIRECTIONAL_CYCLE...");
				NondirectionalCycleCalc ncCalc = new NondirectionalCycleCalc();
				dmData = ncCalc.calculateCoordinates(this.cmData);
				break;
			}

			case IDiagramTypes.VERTICAL_PROCESS:
			{
				CGLogger.trace("Entering coordinate calculation case for IDiagramTypes.VERTICAL_PROCESS...");
				VerticalProcessCalc vpCalc = new VerticalProcessCalc();
				
				dmData = vpCalc.calculateCoordinates(this.cmData);
				break;
			}

			case IDiagramTypes.HIERARCHY:
			{
				CGLogger.trace("Entering coordinate calculation case for IDiagramTypes.HIERARCHY...");
				HierarchyCalc hCalc = new HierarchyCalc();
				
				dmData = hCalc.calculateCoordinates(this.cmData);
				break;
			}

			case IDiagramTypes.BASIC_BLOCK_LIST:
			{
				CGLogger.trace("Entering coordinate calculation case for IDiagramTypes.BASIC_BLOCK_LIST...");
				BasicBlockListCalc bblCalc = new BasicBlockListCalc();
				

				dmData = bblCalc.calculateCoordinates(this.cmData);

				break;
			}

			case IDiagramTypes.CONVERGING_RADIAL:
			{
				CGLogger.trace("Entering coordinate calculation case for IDiagramTypes.CONVERGING_RADIAL...");
				ConvergingRadialCalc crCalc = new ConvergingRadialCalc();


				dmData = crCalc.calculateCoordinates(this.cmData);

				break;
			}

			default:
			case IDiagramTypes.UNINITIALIZED:
			{
				CGLogger.trace(Level.SEVERE, CoordinateManager.class.getName() + ".calculateCoordinates(): An invalid diagram type was encountered.");
				throw new Exception(CoordinateManager.class.getName() + ".calculateCoordinates(): An invalid diagram type was encountered.");
			}
		}

		return dmData;
	}
}
