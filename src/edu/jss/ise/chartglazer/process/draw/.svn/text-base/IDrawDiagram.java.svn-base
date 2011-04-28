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

/**
 * Provides a standard format for all assistant classes of <code>DrawingManager</code>.
 * @author Rishabh
 */
public interface IDrawDiagram
{
	/**
	 * This is the standard function that all the assistant classes of <code>DrawingManager</code> must implement.
	 * @param dmData The interim information that is required by the <code>DrawingManager</code> class.
	 * @param outputDiagram This object hold the entire drawn-in-memory drawing of the diagram.
	 * @param appearanceSpecs Contains font face, style, color selection info.
	 * @throws Exception If some problem occurs, the Exception propagates up the call stack and is finally handled in the UI.
	 */
	public void drawDiagram(DrawingManagerData dmData, SVGDocumentData outputDiagram, AppearanceInputData appearanceSpecs)  throws Exception;
}
