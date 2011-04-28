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
package edu.jss.ise.chartglazer.process.calc.assist;

import edu.jss.ise.chartglazer.data.interim.assist.calc.CoordinateManagerData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.BasicBlockListData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.BasicProcessData;
import edu.jss.ise.chartglazer.process.calc.ICalculateCoordinates;
import edu.jss.ise.chartglazer.shared.CGLogger;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * This class is responsible for the calculation of the geometric coordinates for a given Basic Process diagram.
 * @author rishabh
 */
public class BasicBlockListCalc implements ICalculateCoordinates
{
	/**
	 * The sub task width is <code>partPercentageOfHorizontalDivisionWidth</code> percent of the <code>horizontalDivisionWidth</code>.
	 */
	protected final float SUBTASK_WIDTH_PERCENTAGE = 0.8f;
	/**
	 * The sub task height is <code>partPercentageOfVerticalDivisionWidth</code> percent of the <code>verticalDivisionWidth</code>.
	 */
	protected final float SUBTASK_HEIGHT_PERCENTAGE = 0.8f;

	/**
	 * Calculates coordinates for Basic Process: geometrical entities and the text entities.
	 *
	 * @throws Exception
	 */
	public BasicBlockListData calculateCoordinates(CoordinateManagerData cmData) throws Exception
	{
		BasicBlockListData bblDataReturn = new BasicBlockListData(cmData.getDiagramType(), cmData.getNumberOfSubtasks());

		Point shapeCenterPoint = new Point();
		Point textCenterPoint = new Point();
		String textContent = new String();
		Dimension subTaskDimensions;

		DefaultMutableTreeNode inputTreeChild = new DefaultMutableTreeNode();
		inputTreeChild = cmData.getInputDiagram().getNextNode();

		int m = (int) Math.ceil(Math.sqrt((double) cmData.getNumberOfSubtasks()));

		int numberOfSubTasksCreated = 0;


		float horizontalDivisionWidth = (cmData.getDiagramDimensions().width / m);
		float verticalDivisionWidth = (cmData.getDiagramDimensions().height / m);

//		if (horizontalDivisionWidth > cmData.getDiagramDimensions().height)
//		{
//			subTaskDimensions = new Dimension(Math.round(this.SUBTASK_WIDTH_PERCENTAGE * horizontalDivisionWidth), Math.round((cmData.getDiagramDimensions().height / 2)));
//		}
//		else
//		{
		subTaskDimensions = new Dimension(Math.round(this.SUBTASK_WIDTH_PERCENTAGE * horizontalDivisionWidth), Math.round((this.SUBTASK_WIDTH_PERCENTAGE * verticalDivisionWidth)));
//		}

//		if(verticalDivisionWidth > cmData.getDiagramDimensions().width)
//		{
//
//			subTaskDimensions = new Dimension(Math.round(cmData.getDiagramDimensions().width/2), Math.round(this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth));
//		     //subTaskDimensions = new Dimension(Math.round(this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth), Math.round((cmData.getDiagramDimensions().height/2)));
//
//		}
//		else
//		{
//		subTaskDimensions = new Dimension(Math.round(this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth), Math.round((this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth)));
		//subTaskDimensions = new Dimension(Math.round(this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth), Math.round((this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth)));
//		}

		CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): horizontalDivisionWidth = " + horizontalDivisionWidth);

		// gives u the first child of the input tree
//		DefaultMutableTreeNode inputTreeChild = new DefaultMutableTreeNode();
//		inputTreeChild = cmData.getInputDiagram().getNextNode();
//
//		int m = (int) Math.ceil(Math.sqrt((double) cmData.getNumberOfSubtasks()));
//
//		int numberOfSubTasksCreated = 0;

		outer:  for (int i = 0; i < m; i++)
				{
					for (int j = 0; j < m; j++)
					{
						CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): i = " + i + "...");

						if (numberOfSubTasksCreated >= cmData.getNumberOfSubtasks())
						{
							break outer;
						}
						else
						{
														// calculate the coordinates and fetch the text
							shapeCenterPoint.setLocation((((j * horizontalDivisionWidth) ) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth) ), (((i * verticalDivisionWidth) ) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth) ));
//				textCenterPoint.setLocation(((i * horizontalDivisionWidth) + (subTaskDimensions.width / 2) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), ((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2)));
							textContent = inputTreeChild.toString();

							CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): shapeCenterPoint = " + shapeCenterPoint.toString());
							CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): textCenterPoint = " + textCenterPoint.toString());
							CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): textContent = " + textContent);

							// assign the "just-found-above-values" to the BasicProcessData object, bpData
							bblDataReturn.setShapeCenterPointsArray(numberOfSubTasksCreated, shapeCenterPoint);
							bblDataReturn.setTextCenterPointsArray(numberOfSubTasksCreated, textCenterPoint);
							bblDataReturn.setSubTaskRectangleDimensions(subTaskDimensions);
							bblDataReturn.setTextContent(numberOfSubTasksCreated, textContent);
							bblDataReturn.setBoundingRectangle(numberOfSubTasksCreated, new Rectangle(shapeCenterPoint, subTaskDimensions));

							// proceed to the next sibling
							inputTreeChild = inputTreeChild.getNextSibling();
							numberOfSubTasksCreated += 1;
						}
					}
				}

//		// calculate the coordinates and fetch the text
//		shapeCenterPoint.setLocation(((i * horizontalDivisionWidth) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), (((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2))));
//		textCenterPoint.setLocation(((i * horizontalDivisionWidth) + (subTaskDimensions.width / 2) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), ((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2)));
//		textContent = inputTreeChild.toString();
//
//		CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): shapeCenterPoint = " + shapeCenterPoint.toString());
//		CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): textCenterPoint = " + textCenterPoint.toString());
//		CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): textContent = " + textContent);
//
//		// assign the "just-found-above-values" to the BasicProcessData object, bpData
//		bblDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);
//		bblDataReturn.setTextCenterPointsArray(i, textCenterPoint);
//		bblDataReturn.setSubTaskRectangleDimensions(subTaskDimensions);
//		bblDataReturn.setTextContent(i, textContent);
//		bblDataReturn.setBoundingRectangle(i, new Rectangle(shapeCenterPoint, subTaskDimensions));
//
//		// proceed to the next sibling
//		inputTreeChild = inputTreeChild.getNextSibling();

		CGLogger.trace(bblDataReturn.toString());
		return bblDataReturn;
	}
}
