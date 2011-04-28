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
package edu.jss.ise.chartglazer.process.draw;

import edu.jss.ise.chartglazer.data.input.AppearanceInputData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.DrawingManagerData;
import edu.jss.ise.chartglazer.data.output.SVGDocumentData;
import edu.jss.ise.chartglazer.process.calc.CoordinateManager;
import edu.jss.ise.chartglazer.process.draw.assist.BasicBlockListDraw;
import edu.jss.ise.chartglazer.process.draw.assist.BasicProcessDraw;
import edu.jss.ise.chartglazer.process.draw.assist.ConvergingRadialDraw;
import edu.jss.ise.chartglazer.process.draw.assist.HierarchyDraw;
import edu.jss.ise.chartglazer.process.draw.assist.NondirectionalCycleDraw;
import edu.jss.ise.chartglazer.process.draw.assist.VerticalProcessDraw;
import edu.jss.ise.chartglazer.shared.CGLogger;
import edu.jss.ise.chartglazer.shared.IDiagramTypes;
import java.util.logging.Level;

/**
 * This class is responsible of drawing the diagrams based on the data provided by the <code>CoordinateManager</code> class.
 * @author rishabh
 */
public class DrawingManager
{
	/**
	 * Empty constructor.
	 */
	public DrawingManager()
	{
	}
	
	/**
	 * Delegates the drawing work to it's assistant classes based on the diagram type.
	 * @param dmData Contains common data required by all diagrams.
	 * @param outputDiagram Contains the SVG document data on to which the diagram must be drawn.
	 * @param appearanceSpecs Contains info about font face, size, color schemes etc.
	 * @throws Exception
	 */
	public void drawDiagram(DrawingManagerData dmData, SVGDocumentData outputDiagram, AppearanceInputData appearanceSpecs) throws Exception
	{
		
		switch(dmData.getDiagramType())
		{
			case IDiagramTypes.BASIC_PROCESS:
			{
				CGLogger.trace("Entering diagram drawing case for IDiagramTypes.BASIC_PROCESS...");
				BasicProcessDraw bpDraw = new BasicProcessDraw();
				bpDraw.drawDiagram(dmData, outputDiagram, appearanceSpecs);
				break;
			}

			case IDiagramTypes.NONDIRECTIONAL_CYCLE:
			{
				CGLogger.trace("Entering diagram drawing case for IDiagramTypes.NONDIRECTIONAL_CYCLE...");
				NondirectionalCycleDraw ncDraw = new NondirectionalCycleDraw();
				ncDraw.drawDiagram(dmData, outputDiagram, appearanceSpecs);
				break;
			}

			case IDiagramTypes.VERTICAL_PROCESS:
			{
				CGLogger.trace("Entering diagram drawing case for IDiagramTypes.VERTICAL_PROCESS...");
				VerticalProcessDraw vpDraw = new VerticalProcessDraw();
				vpDraw.drawDiagram(dmData, outputDiagram, appearanceSpecs);
				break;
			}

			case IDiagramTypes.HIERARCHY:
			{
				CGLogger.trace("Entering diagram drawing case for IDiagramTypes.HIERARCHY...");
				HierarchyDraw hDraw = new HierarchyDraw();
				hDraw.drawDiagram(dmData, outputDiagram, appearanceSpecs);
				break;
			}

			case IDiagramTypes.BASIC_BLOCK_LIST:
			{
				CGLogger.trace("Entering diagram drawing case for IDiagramTypes.BASIC_BLOCK_LIST...");
				BasicBlockListDraw bblDraw = new BasicBlockListDraw();
				bblDraw.drawDiagram(dmData, outputDiagram, appearanceSpecs);
				break;
			}

			case IDiagramTypes.CONVERGING_RADIAL:
			{
				CGLogger.trace("Entering diagram drawing case for IDiagramTypes.CONVERGING_RADIAL...");
				ConvergingRadialDraw crDraw = new ConvergingRadialDraw();
				crDraw.drawDiagram(dmData, outputDiagram, appearanceSpecs);
				break;
			}

			default:
			case IDiagramTypes.UNINITIALIZED:
			{
				CGLogger.trace(Level.SEVERE, CoordinateManager.class.getName() + ".calculateCoordinates(): An invalid diagram type was encountered.");
				throw new Exception(CoordinateManager.class.getName() + ".calculateCoordinates(): An invalid diagram type was encountered.");
			}
		}

		//return outputDiagram;
	}
}
