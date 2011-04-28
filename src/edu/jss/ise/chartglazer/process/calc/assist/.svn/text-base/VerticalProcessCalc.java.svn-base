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
import edu.jss.ise.chartglazer.data.interim.assist.draw.VerticalProcessData;
import edu.jss.ise.chartglazer.process.calc.ICalculateCoordinates;
import edu.jss.ise.chartglazer.shared.CGLogger;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * This class is responsible for the calculation of the geometric coordinates for a given Vertical Process diagram.
 * @author naren
 */

public class VerticalProcessCalc implements ICalculateCoordinates
{

	/**
	 * The sub task height is <code>partPercentageOfVerticalDivisionWidth</code> percent of the <code>verticalDivisionWidth</code>.
	 */
	protected final float SUBTASK_HEIGHT_PERCENTAGE = 0.8f;

	/**
	 * Calculates coordinates for Vertical Process: geometrical entities and the text entities.
	 *
	 * @throws Exception
	 */
	public VerticalProcessData calculateCoordinates(CoordinateManagerData cmData) throws Exception
	{
		VerticalProcessData vpDataReturn = new VerticalProcessData(cmData.getDiagramType(), cmData.getNumberOfSubtasks());

		Point shapeCenterPoint = new Point();
		Point textCenterPoint = new Point();
		String textContent = new String();
		Dimension subTaskDimensions;
		Point arrowBaseCenterPoint = new Point();
		int arrowSideLength;

		float verticalDivisionWidth = (cmData.getDiagramDimensions().height / cmData.getNumberOfSubtasks());
		if(verticalDivisionWidth > cmData.getDiagramDimensions().width)
		{

			subTaskDimensions = new Dimension(Math.round(cmData.getDiagramDimensions().width/2), Math.round(this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth));
		     //subTaskDimensions = new Dimension(Math.round(this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth), Math.round((cmData.getDiagramDimensions().height/2)));

		}
		else
		{
		      subTaskDimensions = new Dimension(Math.round(this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth), Math.round((this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth)));
		    //subTaskDimensions = new Dimension(Math.round(this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth), Math.round((this.SUBTASK_HEIGHT_PERCENTAGE * verticalDivisionWidth)));
		}

		CGLogger.trace(BasicProcessCalc.class.getName() + "calculateCoodinates(): horizontalDivisionWidth = " + verticalDivisionWidth);



		// gives u the first child of the input tree
		DefaultMutableTreeNode inputTreeChild = new DefaultMutableTreeNode();
		inputTreeChild = cmData.getInputDiagram().getNextNode();

		arrowSideLength = (int) ((1 - this.SUBTASK_HEIGHT_PERCENTAGE) * verticalDivisionWidth) / 2;
		vpDataReturn.setArrowTriangleBaseLength(arrowSideLength);

		for (int i = 0; i < cmData.getNumberOfSubtasks(); i++)
		{
			CGLogger.trace(VerticalProcessCalc.class.getName() + "calculateCoodinates(): i = " + i + "...");

			// calculate the coordinates and fetch the text
			shapeCenterPoint.setLocation(((cmData.getDiagramDimensions().width / 2)-(subTaskDimensions.width/2)),((i * verticalDivisionWidth) +  (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth))) ;
			textCenterPoint.setLocation(((cmData.getDiagramDimensions().width / 2)-(subTaskDimensions.width/2)+(subTaskDimensions.width/2)),((i * verticalDivisionWidth) +  (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)+(subTaskDimensions.height/2)));
//			shapeCenterPoint.setLocation(((i * verticalDivisionWidth) +  (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)), (((cmData.getDiagramDimensions().height / 2)-(subTaskDimensions.height/2)) ));
//			textCenterPoint.setLocation(((i * verticalDivisionWidth) + (subTaskDimensions.width / 2) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)), ((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2)));
			textContent = inputTreeChild.toString();

			if(i <= cmData.getNumberOfSubtasks() - 2)
			{
				// TODO see if you can delete the redundant + and - at the end of this expression
				// ORIGINAL
				// arrowBaseCenterPoint.setLocation(((i * horizontalDivisionWidth) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth) + subTaskDimensions.width + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), (((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2)) + (subTaskDimensions.height / 2)));
				// bpDataReturn.setArrowBaseCenterPointsArray(i, arrowBaseCenterPoint);


//				vpDataReturn.setArrowBaseCenterPointsArray(i, new Point((int) ((i * horizontalDivisionWidth) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth) + subTaskDimensions.width + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)),(((cmData.getDiagramDimensions().height / 2) - (subTaskDimensions.height / 2)) + (subTaskDimensions.height / 2))));

				vpDataReturn.setArrowBaseCenterPointsArray(i,new Point(((cmData.getDiagramDimensions().width / 2)),(int) ((i * verticalDivisionWidth) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth) + subTaskDimensions.height + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth))));
			}


			CGLogger.trace(VerticalProcessCalc.class.getName() + "calculateCoodinates(): shapeCenterPoint = " + shapeCenterPoint.toString());
			CGLogger.trace(VerticalProcessCalc.class.getName() + "calculateCoodinates(): textCenterPoint = " + textCenterPoint.toString());
			CGLogger.trace(VerticalProcessCalc.class.getName() + "calculateCoodinates(): textContent = " + textContent);

			// assign the "just-found-above-values" to the VerticalProcessData object, bpData
			vpDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);
			vpDataReturn.setTextCenterPointsArray(i, textCenterPoint);
			vpDataReturn.setSubTaskRectangleDimensions(subTaskDimensions);
			vpDataReturn.setTextContent(i, textContent);
			vpDataReturn.setBoundingRectangle(i, new Rectangle(shapeCenterPoint, subTaskDimensions));

			// proceed to the next sibling
			inputTreeChild = inputTreeChild.getNextSibling();
		}

		return vpDataReturn;
	}

}
