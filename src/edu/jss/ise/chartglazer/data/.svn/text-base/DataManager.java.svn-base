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
package edu.jss.ise.chartglazer.data;

import edu.jss.ise.chartglazer.data.input.AppearanceInputData;
import edu.jss.ise.chartglazer.data.input.RawInputData;
import edu.jss.ise.chartglazer.data.interim.assist.calc.CoordinateManagerData;
import edu.jss.ise.chartglazer.shared.CGLogger;
import edu.jss.ise.chartglazer.shared.IDiagramTypes;
import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * This class is responsible for receiving input from ChartGlazerGUI.
 * It is also responsible for separating out and sorting the input
 * so that the sorted input can be given to CoordinateManager, DiagramManager etc.
 * @author rishabh
 */
public class DataManager
{
	/**
	 * This object contains all the input specifications about the diagram
	 * currently being drawn.
	 */
	private RawInputData inputSpecs;

	/**
	 * This object contains the color and style parameters for the diagram.
	 */
	private AppearanceInputData appearanceSpecs;
	/**
	 * Creates an empty raw input data manager.
	 */
	public DataManager()
	{
		inputSpecs = new RawInputData();
		appearanceSpecs = new AppearanceInputData();
	}

	/**
	 * Kind of like a copy-constructor.
	 * @param inputSpecs The RawInputData object, which came in from the GUI.
	 */
	public DataManager(RawInputData inputSpecs)
	{
		this.inputSpecs = inputSpecs;
	}

	/**
	 * @return The input specs object.
	 */
	public RawInputData getInputSpecs()
	{
		return inputSpecs;
	}

	/**
	 * @return This object contains the color and style parameters for the diagram.
	 */
	public AppearanceInputData getAppearanceSpecs()
	{
		return appearanceSpecs;
	}

	/**
	 * @param appearanceSpecs This object contains the color and style parameters for the diagram.
	 */
	public void setAppearanceSpecs(AppearanceInputData appearanceSpecs)
	{
		this.appearanceSpecs = appearanceSpecs;
	}

	/**
	 * Sets the inputSpecs object.
	 * @param inputSpecs
	 */
	public void setInputSpecs(RawInputData inputSpecs)
	{
		this.inputSpecs = inputSpecs;
	}

	/**
	 * Sorts out the input data according to the requirements of the <code>CoordinateManager</code> class.
	 * @return An object containing the input data as required by the <code>CoordinateManager</code> class.
	 */
	public CoordinateManagerData getCoordinateManagerData()
	{
		CoordinateManagerData cmData = new CoordinateManagerData();

		cmData.setInputDiagram(this.inputSpecs.getInputDiagram());
		cmData.setDiagramDimensions(this.inputSpecs.getDiagramDimensions());
		cmData.setDiagramType(this.inputSpecs.getDiagramType());

		return cmData;
	}

	/**
	 * Performs various input validations and checks feasibility of drawing the diagram (i.e. whether the diagram can be drawn or not)
	 */
	public void performInputValidation()
	{
		// input JTree
		DefaultMutableTreeNode inputTree = this.inputSpecs.getInputDiagram();

		int numberOfSubtasks = this.inputSpecs.getInputDiagram().getChildCount();

		switch(this.inputSpecs.getDiagramType())
		{
			case IDiagramTypes.BASIC_PROCESS:
			case IDiagramTypes.VERTICAL_PROCESS:
			case IDiagramTypes.NONDIRECTIONAL_CYCLE:
			case IDiagramTypes.BASIC_BLOCK_LIST:
			{
				boolean isValid = true;

				for(int i = 0; i < numberOfSubtasks; i++)
				{
					if(inputTree.getChildAt(i).isLeaf())
					{
						isValid = true;

					}
					else
					{
						isValid = false;
						break;
					}
				}
				if(isValid == false)
				{

				}
				break;
			}
		}
	}

	@Override
	public String toString()
	{
		return ("[Input specs: " + inputSpecs.toString() + ", Appearance Specs: " + appearanceSpecs.toString() + "]");
	}
}
