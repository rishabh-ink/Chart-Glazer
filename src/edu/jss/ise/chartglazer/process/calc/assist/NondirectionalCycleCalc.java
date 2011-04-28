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

import edu.jss.ise.chartglazer.data.interim.assist.draw.NondirectionalCycleData;

import edu.jss.ise.chartglazer.data.interim.assist.calc.CoordinateManagerData;
import edu.jss.ise.chartglazer.process.calc.ICalculateCoordinates;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author naren
 */
//TODO Was not able to implement ICalculateCoordinates
public class NondirectionalCycleCalc implements ICalculateCoordinates
{

	/**
	 * Radius of the bigger circle is fixed to 100
	 */
	public int RADIUS ;
	final int CIRCLEANGLE = 360;
	final int TRIANGLEANGLESUM = 180;
	final double RADIUSPERCENTAGE = 0.3;

	public NondirectionalCycleData calculateCoordinates(CoordinateManagerData cmData)
	{
		NondirectionalCycleData ncDataReturn = new NondirectionalCycleData(cmData.getDiagramType(), cmData.getNumberOfSubtasks());

		Point shapeCenterPoint = new Point();
		Point textCenterPoint = new Point();
		String textContent = new String();


		if(cmData.getDiagramDimensions().height < cmData.getDiagramDimensions().width )
		{
			RADIUS =  (int) (RADIUSPERCENTAGE * cmData.getDiagramDimensions().height);
		}
		else
		{
			RADIUS =  (int) (RADIUSPERCENTAGE * cmData.getDiagramDimensions().width);
		}

		ncDataReturn.setRadiusOfCircle(RADIUS);
		DefaultMutableTreeNode inputTreeChild = new DefaultMutableTreeNode();
		inputTreeChild = cmData.getInputDiagram().getNextNode();
		Dimension d = new Dimension((RADIUS / 2), (RADIUS / 4));
		ncDataReturn.setSubTaskRectangleDimensions(d);
		/**
		 * This gives the center of the big circle upon which subtasks will be drawn
		 */
		Point circleCenter = new Point(Math.round(cmData.getDiagramDimensions().width / 2), Math.round(cmData.getDiagramDimensions().height / 2));


		/**
		 * value gives the current position of the subtask which is calculated during iteration.
		 */
		Point trackPoint = new Point();
		Point helpPoint = new Point();

		trackPoint.setLocation(circleCenter.x, (circleCenter.y - RADIUS));

		shapeCenterPoint.setLocation(trackPoint);
		textCenterPoint.setLocation(trackPoint);
		textContent = inputTreeChild.toString();

		/**
		 * Circle center is the middle of the screen.
		 */
		ncDataReturn.setCircleCenter(circleCenter);

		/**
		 * First subtask center is found out manually
		 */
		ncDataReturn.setShapeCenterPointsArray(0, shapeCenterPoint);
		/**
		 * First subtask text center is found out manually
		 */
		ncDataReturn.setTextCenterPointsArray(0, textCenterPoint);
		/**
		 * First subtask text content is found out manually
		 */
		ncDataReturn.setTextContent(0, textContent);




		ncDataReturn.setBoundingRectangle(0, new Rectangle(ncDataReturn.getShapeCenterPointsArray(0), d));
		/**
		 * numberOfSubTasks holds the number of sub tasks
		 */
		int numberOfSubTasks = cmData.getInputDiagram().getChildCount();
		/**
		 * the nearCenterAngle between two subtasks
		 *
		 */
		if(numberOfSubTasks >=2)
		{
		double frequency = (CIRCLEANGLE / numberOfSubTasks);

		double nearChordAngle = ((TRIANGLEANGLESUM - frequency) / 2);

		/**
		 * Length of the chord between any two subtasks.
		 */
		double lengthOfChord = Math.abs((RADIUS * Math.sin(Math.toRadians(frequency))) / Math.sin(Math.toRadians(nearChordAngle)));

		double angleTraversed = frequency;

		double p, k, z;

		p = 90 - nearChordAngle;

//		y = fabs(sin(p / 57.3) * chord);
//		x = fabs(cos(p / 57.3) * chord);
//		X = X + x;
//		Y = Y + y;

		helpPoint.x = (int) Math.abs((Math.cos(Math.toRadians(p))) * lengthOfChord);

		helpPoint.y = (int) Math.abs((Math.sin(Math.toRadians(p))) * lengthOfChord);

		trackPoint.x += helpPoint.x;
		trackPoint.y += helpPoint.y;

		inputTreeChild = inputTreeChild.getNextSibling();

		shapeCenterPoint.setLocation(trackPoint);
		textCenterPoint.setLocation(trackPoint);
		textContent = inputTreeChild.toString();


		/**
		 * Second subtask center is found out manually
		 */
		ncDataReturn.setShapeCenterPointsArray(1, shapeCenterPoint);
		/**
		 * Second subtask text center is found out manually
		 */
		ncDataReturn.setTextCenterPointsArray(1, textCenterPoint);
		/**
		 * Second subtask text content is found out manually
		 */
		ncDataReturn.setTextContent(1, textContent);


		ncDataReturn.setBoundingRectangle(1, new Rectangle(ncDataReturn.getShapeCenterPointsArray(1), d));




		/**
		 * for loop starts from the calculation of second set of coordinate points because first set is already calculated.
		 *
		 */
		for (int i = 2; i < numberOfSubTasks; i++)
		{
			angleTraversed += frequency;
			inputTreeChild = inputTreeChild.getNextSibling();
			if ((angleTraversed < 90))
			{
				k = 90 - angleTraversed;
				k = nearChordAngle - k;

				helpPoint.x = (int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);

				helpPoint.y = (int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);

				trackPoint.x += helpPoint.x;
				trackPoint.y += helpPoint.y;

				shapeCenterPoint.setLocation(trackPoint);
				textCenterPoint.setLocation(trackPoint);
				textContent = inputTreeChild.toString();

				ncDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);

				ncDataReturn.setTextCenterPointsArray(i, textCenterPoint);

				ncDataReturn.setTextContent(i, textContent);



				ncDataReturn.setBoundingRectangle(i, new Rectangle(ncDataReturn.getShapeCenterPointsArray(i), d));

			} else if (angleTraversed == 90)
			{
				trackPoint.x = circleCenter.x + RADIUS;
				trackPoint.y = circleCenter.y;

				shapeCenterPoint.setLocation(trackPoint);
				textCenterPoint.setLocation(trackPoint);
				textContent = inputTreeChild.toString();

				ncDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);

				ncDataReturn.setTextCenterPointsArray(i, textCenterPoint);

				ncDataReturn.setTextContent(i, textContent);

				ncDataReturn.setBoundingRectangle(i, new Rectangle(ncDataReturn.getShapeCenterPointsArray(i), d));

			} else if ((angleTraversed > 90) && (angleTraversed < 180))
			{
				k = 180 - angleTraversed;
				k = nearChordAngle - k;
				z = angleTraversed - frequency;

				if ((z >= 90) && (z < 180))
				{

					helpPoint.x = -(int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);

					helpPoint.y = (int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);
//					x = -(fabs(chord * sin(k / 57.3)));
//					y = fabs(chord * cos(k / 57.3));
				} else
				{
					if ((90 - z) > (angleTraversed - 90))
					{
						helpPoint.x = (int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);

						helpPoint.y = (int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);

////						x = (fabs(chord * sin(k / 57.3)));
////						y = fabs(chord * cos(k / 57.3));
					} else
					{

						helpPoint.x = -(int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);

						helpPoint.y = (int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);
//						x = -(fabs(chord * sin(k / 57.3)));
//						y = fabs(chord * cos(k / 57.3));
					}
				}


				trackPoint.x += helpPoint.x;
				trackPoint.y += helpPoint.y;

				shapeCenterPoint.setLocation(trackPoint);
				textCenterPoint.setLocation(trackPoint);
				textContent = inputTreeChild.toString();

				ncDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);

				ncDataReturn.setTextCenterPointsArray(i, textCenterPoint);

				ncDataReturn.setTextContent(i, textContent);


				ncDataReturn.setBoundingRectangle(i, new Rectangle(ncDataReturn.getShapeCenterPointsArray(i), d));

//				X = X + x;
//				Y = Y + y;
//				printf("%f ,  %f\n", X, Y);
			} else if (angleTraversed == 180)
			{
				trackPoint.x = circleCenter.x;
				trackPoint.y = circleCenter.y + RADIUS;

				shapeCenterPoint.setLocation(trackPoint);
				textCenterPoint.setLocation(trackPoint);
				textContent = inputTreeChild.toString();

				ncDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);

				ncDataReturn.setTextCenterPointsArray(i, textCenterPoint);

				ncDataReturn.setTextContent(i, textContent);



				ncDataReturn.setBoundingRectangle(i, new Rectangle(ncDataReturn.getShapeCenterPointsArray(i), d));
			} else if ((angleTraversed >= 180) && (angleTraversed < 270))
			{
				k = 270 - angleTraversed;
				k = nearChordAngle - k;
				z = angleTraversed - frequency;


				if ((z > 180) && (z < 270))
				{
					helpPoint.x = -(int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);

					helpPoint.y = -(int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);
//					x = -(fabs(chord * cos(k / 57.3)));
//					y = -(fabs(chord * sin(k / 57.3)));
				} else
				{

					if ((180 - z) > (angleTraversed - 180))
					{

						helpPoint.x = -(int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);

						helpPoint.y = (int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);
//						x = -(fabs(chord * cos(k / 57.3)));
//						y = (fabs(chord * sin(k / 57.3)));
					} else
					{
						helpPoint.x = -(int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);

						helpPoint.y = -(int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);

//						x = -(fabs(chord * cos(k / 57.3)));
//						y = -(fabs(chord * sin(k / 57.3)));
					}
				}

				trackPoint.x += helpPoint.x;
				trackPoint.y += helpPoint.y;

				shapeCenterPoint.setLocation(trackPoint);
				textCenterPoint.setLocation(trackPoint);
				textContent = inputTreeChild.toString();

				ncDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);

				ncDataReturn.setTextCenterPointsArray(i, textCenterPoint);

				ncDataReturn.setTextContent(i, textContent);



				ncDataReturn.setBoundingRectangle(i, new Rectangle(ncDataReturn.getShapeCenterPointsArray(i), d));



//				X = X + x;
//				Y = Y + y;
//				printf("%f ,  %f\n", X, Y);
			} else if (angleTraversed == 270)
			{
				trackPoint.x = circleCenter.x - RADIUS;
				trackPoint.y = circleCenter.y;

				shapeCenterPoint.setLocation(trackPoint);
				textCenterPoint.setLocation(trackPoint);
				textContent = inputTreeChild.toString();

				ncDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);

				ncDataReturn.setTextCenterPointsArray(i, textCenterPoint);

				ncDataReturn.setTextContent(i, textContent);


				ncDataReturn.setBoundingRectangle(i, new Rectangle(ncDataReturn.getShapeCenterPointsArray(i), d));

			} else
			{
				k = 360 - angleTraversed;
				k = nearChordAngle - k;
				z = angleTraversed - frequency;



				if ((z > 270) && (z < 360))
				{
					helpPoint.x = (int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);

					helpPoint.y = -(int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);
//					x = (fabs(chord * sin(k / 57.3)));
//					y = -(fabs(chord * cos(k / 57.3)));
				} else
				{
					if ((270 - z) > (angleTraversed - 270))
					{
						helpPoint.x = -(int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);

						helpPoint.y = -(int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);

//						x = -(fabs(chord * sin(k / 57.3)));
//						y = -(fabs(chord * cos(k / 57.3)));
					} else
					{

						helpPoint.x = (int) Math.abs((Math.sin(Math.toRadians(k))) * lengthOfChord);

						helpPoint.y = -(int) Math.abs((Math.cos(Math.toRadians(k))) * lengthOfChord);
//						x = (fabs(chord * sin(k / 57.3)));
//						y = -(fabs(chord * cos(k / 57.3)));
					}
				}

				trackPoint.x += helpPoint.x;
				trackPoint.y += helpPoint.y;

				shapeCenterPoint.setLocation(trackPoint);
				textCenterPoint.setLocation(trackPoint);
				textContent = inputTreeChild.toString();

				ncDataReturn.setShapeCenterPointsArray(i, shapeCenterPoint);

				ncDataReturn.setTextCenterPointsArray(i, textCenterPoint);

				ncDataReturn.setTextContent(i, textContent);



				ncDataReturn.setBoundingRectangle(i, new Rectangle(ncDataReturn.getShapeCenterPointsArray(i), d));

//				X = X + x;
//				Y = Y + y;
//				printf("%f ,  %f\n", X, Y);
			}

		}
		}

		return ncDataReturn;
	}
}











