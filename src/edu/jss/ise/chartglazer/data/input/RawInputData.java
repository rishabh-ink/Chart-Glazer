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
package edu.jss.ise.chartglazer.data.input;

import edu.jss.ise.chartglazer.shared.IDiagramTypes;
import java.awt.Dimension;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * This class hold all the input specification details regarding the input data.
 * @author rishabh
 */
public class RawInputData
{
	/**
	 * The input diagram in tree form.
	 */
	private DefaultMutableTreeNode inputDiagram;
	/**
	 * The (width, height) of the SVG canvas.
	 */
	private Dimension diagramDimensions;
	/**
	 * The type of diagram currently selected.
	 * This value will come from the diagramTypeComboBox.
	 */
	private int diagramType;

	/**
	 * Performs empty memory allocations for the data members.
	 */
	public RawInputData()
	{
		inputDiagram = new DefaultMutableTreeNode();
		diagramDimensions = new Dimension();
		diagramType = IDiagramTypes.UNINITIALIZED;
	}

	/**
	 * @return The (width, height) <code>Dimension</code> object of the SVG canvas.
	 */
	public Dimension getDiagramDimensions()
	{
		return diagramDimensions;
	}

	/**
	 * @return The type of diaaultMutableTreeNode();
		diagramDimensions = new Dimension();
		diagramType = IDiagramTypes.UNINITIALIZED;gram currently selected.
	 */
	public int getDiagramType()
	{
		return diagramType;
	}

	/**
	 * @return The Swing JTree's data provider.
	 */
	public DefaultMutableTreeNode getInputDiagram()
	{
		return inputDiagram;
	}

	/**
	 * @param diagramDimensions The (width, height) Dimension object of the SVG canvas.
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
	 *
	 * @param inputDiagram The input diagram in tree form.
	 */
	public void setInputDiagram(DefaultMutableTreeNode inputDiagram)
	{
		this.inputDiagram = inputDiagram;
	}

	@Override
	public String toString()
	{
		return ("[Input Diagram: " + inputDiagram.toString() + ", Diagram Dimensions: " + diagramDimensions.toString() + ", Diagram Type: " + diagramType + "]");
	}
}
