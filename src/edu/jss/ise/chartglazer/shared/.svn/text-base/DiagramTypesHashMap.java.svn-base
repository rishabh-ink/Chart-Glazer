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
package edu.jss.ise.chartglazer.shared;

import java.util.HashMap;
import java.util.logging.Level;

/**
 *
 * @author rishabh
 */
public class DiagramTypesHashMap
{
	/**
	 * Contains a HashMap of all the diagram types and their corresponding int values.
	 */
	protected static HashMap<String, Integer> diagramTypesHashMap;

	/**
	 * Creates new keys and assigns integer values to them.
	 */
	public static void setupDiagramTypesHashMap()
	{
		diagramTypesHashMap = new HashMap<String, Integer>();

		CGLogger.trace("Setting up (String, Integer) diagram type key, value pairs.");
		diagramTypesHashMap.put("UNINITIALIZED", IDiagramTypes.UNINITIALIZED);
		diagramTypesHashMap.put("Basic Process", IDiagramTypes.BASIC_PROCESS);
		//diagramTypesHashMap.put("Vertical Arrow List", IDiagramTypes.VERTICAL_ARROW_LIST);
		//diagramTypesHashMap.put("Vertical Bullet List", IDiagramTypes.VERTICAL_BULLET_LIST);
		//diagramTypesHashMap.put("Basic Chevron Process", IDiagramTypes.BASIC_CHEVRON_PROCESS);
		diagramTypesHashMap.put("Nondirectional Cycle", IDiagramTypes.NONDIRECTIONAL_CYCLE);
		diagramTypesHashMap.put("Vertical Process", IDiagramTypes.VERTICAL_PROCESS);
		diagramTypesHashMap.put("Hierarchy", IDiagramTypes.HIERARCHY);
		diagramTypesHashMap.put("Basic Block List", IDiagramTypes.BASIC_BLOCK_LIST);
		//diagramTypesHashMap.put("Segmented Pyramid", IDiagramTypes.SEGMENTED_PYRAMID);
		diagramTypesHashMap.put("Converging Radial", IDiagramTypes.CONVERGING_RADIAL);


		// TODO add more (key, value) pairs for other diagram types here.
	}

	/**
	 * @param key The key to search for.
	 * @return The value associated with this key.
	 */
	public static Integer getValue(String key)
	{
		if (diagramTypesHashMap.containsKey(key))
		{
			return diagramTypesHashMap.get(key);
		}
		else
		{
			CGLogger.trace(Level.WARNING, "The HashMap was provided a non-existant key.");
			return IDiagramTypes.UNINITIALIZED;
		}
	}
}
