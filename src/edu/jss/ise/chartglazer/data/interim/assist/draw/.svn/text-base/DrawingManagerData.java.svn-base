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
package edu.jss.ise.chartglazer.data.interim.assist.draw;

/**
 * This is the abstract root class. It contains common data required by all diagrams.
 * The other classes can extend the functionality of this class.
 * @author rishabh
 */
abstract public class DrawingManagerData
{
	/**
	 * The type of diagram currently being drawn.
	 */
	protected int diagramType;

	/**
	 * The number of subtasks to be drawn.
	 */
	protected int numberOfSubtasks;

	/**
	 * Constructor will just set the diagramType to the current diagram being drawn.
	 * @param diagramType The code of the current diagram being drawn.
	 * @param numberOfSubtasks The number of subtasks to be drawn.
	 */
	public DrawingManagerData(int diagramType, int numberOfSubtasks)
	{
		this.diagramType = diagramType;
		this.numberOfSubtasks = numberOfSubtasks;
	}

	/**
	 * @return The type of diagram currently being drawn.
	 */
	public int getDiagramType()
	{
		return diagramType;
	}

	/**
	 * @return The number of subtasks to be drawn.
	 */
	public int getNumberOfSubtasks()
	{
		return numberOfSubtasks;
	}

	@Override
	public String toString()
	{
		return ("[diagramType=" + this.diagramType + ", numberOfSubtasks=" + this.numberOfSubtasks +"]");
	}
}
