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
package edu.jss.ise.chartglazer.data.interim.assist.calc;

import java.awt.Dimension;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * This class hold the interim information that is required by the <code>CoordinateManager</code> class.
 * @author rishabh
 */
public class CoordinateManagerData
{
	/**
	 * The input diagram in tree form.
	 */
	protected  DefaultMutableTreeNode inputDiagram;
	/**
	 * The (width, height) of the SVG canvas.
	 */
	protected Dimension diagramDimensions;
	/**
	 * The type of diagram currently selected.
	 * This value will come from the diagramTypeComboBox.
	 */
	protected int diagramType;
	/**
	 * Allocates memory for the data members.
	 */
	public CoordinateManagerData()
	{
		// TODO I think you need not do new for these because they will be equated to another object. The reference will be copied. Bad design?
		inputDiagram = new DefaultMutableTreeNode();
		diagramDimensions = new Dimension();
	}

	/**
	 * @return The input diagram in tree form.
	 */
	public DefaultMutableTreeNode getInputDiagram()
	{
		return inputDiagram;
	}

	/**
	 * @return The (width, height) of the SVG canvas.
	 */
	public Dimension getDiagramDimensions()
	{
		return diagramDimensions;
	}

	/**
	 * @return The type of diagram currently selected.
	 */
	public int getDiagramType()
	{
		return diagramType;
	}

	/**
	 * @return This integer denotes the number of sub task boxes to be drawn.
	 */
	public int getNumberOfSubtasks()
	{
		return inputDiagram.getChildCount();
	}

	/**
	 * @param inputDiagram The input diagram in tree form.
	 */
	public void setInputDiagram(DefaultMutableTreeNode inputDiagram)
	{
		this.inputDiagram = inputDiagram;
	}

	/**
	 * @param diagramDimensions The (width, height) of the SVG canvas.
	 */
	public void setDiagramDimensions(Dimension diagramDimensions)
	{
		this.diagramDimensions = diagramDimensions;
	}

	/**
	 * @param diagramType The type of diagram currently selected.
	 */
	public void setDiagramType(int diagramType)
	{
		this.diagramType = diagramType;
	}

	/**
	 * @return A human-readable format of this <code>CoordinateManagerData</code> classs.
	 */
	@Override
	public String toString()
	{
		return ("inputDiagram = " + this.inputDiagram.toString() + ", diagramDimensions = " + this.diagramDimensions.toString() + ", diagramType = " + this.diagramType + ", numberOfSubtasks = " + this.getNumberOfSubtasks());
	}
}
