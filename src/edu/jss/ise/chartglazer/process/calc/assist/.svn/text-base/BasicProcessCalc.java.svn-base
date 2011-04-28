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
public class BasicProcessCalc implements ICalculateCoordinates
{
	/**
	 * The sub task width is <code>partPercentageOfHorizontalDivisionWidth</code> percent of the <code>horizontalDivisionWidth</code>.
	 */
	protected final float SUBTASK_WIDTH_PERCENTAGE = 0.8f;

	/**
	 * Calculates coordinates for Basic Process: geometrical entities and the text entities.
	 * @throws Exception 
	 */
	public BasicProcessData calculateCoordinates(CoordinateManagerData cmData) throws Exception
	{
		BasicProcessData bpDataReturn = new BasicProcessData(cmData.getDiagramType(), cmData.getNumberOfSubtasks());

		Point shapeCenterPoint = new Point();
		Point arrowBaseCenterPoint = new Point();
		int arrowSideLength;
		Point textCenterPoint = new Point();
		String textContent = new String();
		Dimension subTaskDimensions;

		float horizontalDivisionWidth = (cmData.getDiagramDimensions().width / cmData.getNumberOfSubtasks());
		if (horizontalDivisionWidth > cmData.getDiagramDimensions().height)
		{
			subTaskDimensions = new Dimension(Math.round(this.SUBTASK_WIDTH_PERCENTAGE * horizontalDivisionWidth), Math.round((cmData.getDiagramDimensions().height / 2)));
		}
		else
		{
			subTaskDimensions = new Dimension(Math.round(this.SUBTASK_WIDTH_PERCENTAGE * horizontalDivisionWidth), Math.round((this.SUBTASK_WIDTH_PERCENTAGE * horizontalDivisionWidth)));
		}

		CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): horizontalDivisionWidth = " + horizontalDivisionWidth);

		// gives u the first child of the input tree
		DefaultMutableTreeNode inputTreeChild = new DefaultMutableTreeNode();
		inputTreeChild = cmData.getInputDiagram().getNextNode();
		
		arrowSideLength = (int) ((1 - this.SUBTASK_WIDTH_PERCENTAGE) * horizontalDivisionWidth) / 2;
		bpDataReturn.setArrowTriangleBaseLength(arrowSideLength);

		for (int i = 0; i < cmData.getNumberOfSubtasks(); i++)
		{
			CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): i = " + i + "...");

			// calculate the coordinates and fetch the text
			shapeCenterPoint.setLocation(((i * horizontalDivisionWidth) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), (((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2))));

			if(i <= cmData.getNumberOfSubtasks() - 2)
			{
				// TODO see if you can delete the redundant + and - at the end of this expression
				// ORIGINAL
				// arrowBaseCenterPoint.setLocation(((i * horizontalDivisionWidth) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth) + subTaskDimensions.width + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), (((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2)) + (subTaskDimensions.height / 2)));
				// bpDataReturn.setArrowBaseCenterPointsArray(i, arrowBaseCenterPoint);


				bpDataReturn.setArrowBaseCenterPointsArray(i, new Point((int) ((i * horizontalDivisionWidth) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth) + subTaskDimensions.width + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)),(((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2)) + (subTaskDimensions.height / 2))));
			}

			textCenterPoint.setLocation(((i * horizontalDivisionWidth) + (subTaskDimensions.width / 2) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), ((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2)));
			textContent = inputTreeChild.toString();

			CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): shapeCenterPoint = " + shapeCenterPoint.toString());
			CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): textCenterPoint = " + textCenterPoint.toString());
			CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): textContent = " + textContent);

			// assign the "just-found-above-values" to the BasicProcessData object, bpData
			bpDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);
			bpDataReturn.setTextCenterPointsArray(i, textCenterPoint);
			bpDataReturn.setSubTaskRectangleDimensions(subTaskDimensions);
			bpDataReturn.setTextContent(i, textContent);
			bpDataReturn.setBoundingRectangle(i, new Rectangle(shapeCenterPoint, subTaskDimensions));

			// proceed to the next sibling
			inputTreeChild = inputTreeChild.getNextSibling();
		}

		return bpDataReturn;
	}
}
