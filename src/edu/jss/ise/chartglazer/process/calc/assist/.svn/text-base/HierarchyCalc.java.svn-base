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

import edu.jss.ise.chartglazer.data.interim.assist.draw.HierarchyData;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;


import edu.jss.ise.chartglazer.data.interim.assist.calc.CoordinateManagerData;
import edu.jss.ise.chartglazer.process.calc.ICalculateCoordinates;
import javax.swing.tree.TreeNode;

/**
 *
 * @author naren
 */
public class HierarchyCalc implements ICalculateCoordinates
{
	/**
	 * The sub task width is <code>partPercentageOfHorizontalDivisionWidth</code> percent of the <code>horizontalDivisionWidth</code>.
	 */
	protected final float SUBTASK_WIDTH_PERCENTAGE = 0.8f;
	/**
	 * The sub task height is <code>partPercentageOfVerticalDivisionWidth</code> percent of the <code>horizontalDivisionWidth</code>.
	 */
	protected final float SUBTASK_HEIGHT_PERCENTAGE = 0.8f;
	/**
	 * Helps declare large arrays.
	 * @deprecated This is not a recommended approach. Try finding a better alternative method, like dynamically finding the exact number based on input.
	 */
	@Deprecated
	public static final int BIG_NUMBER = 100;
	/**
	 * Variable K is used to hold the height of the input JTree and it is initializwd to 0
	 */
	protected int k = 0;
	/**
	 * Each index value of this array holds the number of children at that particular level.
	 */
	protected int[] x = new int[BIG_NUMBER];
	/**
	 * A 2D matrix and holds the information about the nodes in the input JTree.
	 */
	protected String[][] treeMatrix = new String[BIG_NUMBER][BIG_NUMBER];
	/**
	 * Holds information about the parent nodes
	 */
	protected String[][] parentMatrix = new String[BIG_NUMBER][BIG_NUMBER];
	/**
	 * Contains the number of nodes in each level.
	 * First index of child array holds number of children in first level, second index of child array holds number of children in second level and so on.
	 * Excluding the root.
	 */
	protected int[] child = new int[BIG_NUMBER];

	/**
	 * Genrates the <code>treeMatrix</code> from the given input tree.
	 * @param root Everytime this recursive function is called, <code>root</code> takes the role of the root of the subtree in question.
	 * @param k Everytime this recursive function is called, <code>k</code> takes the value of the current level. Acts as a level indicator.
	 */
	private void treeMatrixGenerator(TreeNode root, int k)
	{
		treeMatrix[k][x[k]++] = root.toString();
		if (k != 0)
		{
			parentMatrix[k][x[k] - 1] = root.getParent().toString();
		}
		if (root.getChildCount() == 0)
		{
			return;
		}
		else
		{

//		   for(int i= 0;i < root.getChildCount();i++)
//
//		    {
//			    System.out.println("the node " + root.getChildAt(i) +" is at level "+ (k+1) +  " and its parent is "+root.toString());
//		    }
			child[k] += root.getChildCount();

			for (int i = 0; i < root.getChildCount(); i++)
			{
				treeMatrixGenerator((root.getChildAt(i)), k + 1);
			}
		}
	}

	public HierarchyData calculateCoordinates(CoordinateManagerData cmData) throws Exception
	{


		Point shapeCenterPoint = new Point();
		Point textCenterPoint = new Point();
		String textContent = new String();
		Dimension subTaskDimensions = new Dimension();


		TreeNode root = cmData.getInputDiagram().getRoot();

		treeMatrixGenerator(root, k);
		int s = 0;
		int highestNumberOfNodesAmongAllTheLevels = 0;
		int totalNumberOfChildren = 0;
		while (child[s] != 0)
		{
			if (child[s] > highestNumberOfNodesAmongAllTheLevels)
			{
				highestNumberOfNodesAmongAllTheLevels = child[s];
			}
			totalNumberOfChildren += child[s];
			s++;
		}
		totalNumberOfChildren += 1;
		k = s;
		HierarchyData hDataReturn = new HierarchyData(cmData.getDiagramType(), totalNumberOfChildren);
		float horizontalDivisionWidth = (cmData.getDiagramDimensions().width) / highestNumberOfNodesAmongAllTheLevels;
		float verticalDivisionWidth = (cmData.getDiagramDimensions().height) / (k + 1);
		subTaskDimensions.width = Math.round(horizontalDivisionWidth * SUBTASK_WIDTH_PERCENTAGE);
		subTaskDimensions.height = Math.round(verticalDivisionWidth * SUBTASK_HEIGHT_PERCENTAGE);

//		System.out.println(node[0][0] + "\n");
//		for (int i = 1; i <= s; i++)
//		{
//			for (int j = 0; j < child[i - 1]; j++)
//			{
//				System.out.println(node[i][j]);
//			}
//			System.out.println("");
//		}

		shapeCenterPoint.setLocation(((cmData.getDiagramDimensions().width / 2) - (subTaskDimensions.width / 2)), ((verticalDivisionWidth / 2) - (subTaskDimensions.height / 2)));
		textCenterPoint.setLocation((cmData.getDiagramDimensions().width / 2), (verticalDivisionWidth / 2));
		textContent = treeMatrix[0][0];

		hDataReturn.setShapeCenterPointsArray(0, shapeCenterPoint);
		hDataReturn.setTextCenterPointsArray(0, textCenterPoint);
		hDataReturn.setSubTaskRectangleDimensions(subTaskDimensions);
		hDataReturn.setTextContent(0, textContent);
		hDataReturn.setBoundingRectangle(0, new Rectangle(shapeCenterPoint, subTaskDimensions));
		int b = 1;
		int t;
		for (int i = 1; i <= k; i++)
		{

			t = 0;

			horizontalDivisionWidth = cmData.getDiagramDimensions().width / child[i - 1];
			for (int j = 0; j < child[i - 1]; j++)
			{


				if (child[i - 1] == 1)
				{
					shapeCenterPoint.setLocation(((cmData.getDiagramDimensions().width / 2) - (subTaskDimensions.width / 2)), ((i * verticalDivisionWidth) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)));
					textCenterPoint.setLocation(((j * horizontalDivisionWidth) + (subTaskDimensions.width / 2) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), ((i * verticalDivisionWidth) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)) + (subTaskDimensions.height / 2));
					textContent = treeMatrix[i][j];

				}
				else if (child[i - 1] == 2)
				{
					if (t == 0)
					{
						shapeCenterPoint.setLocation(((cmData.getDiagramDimensions().width / 4) -(subTaskDimensions.width/2)), ((i * verticalDivisionWidth) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)));
						textCenterPoint.setLocation(((j * horizontalDivisionWidth) + (subTaskDimensions.width / 2) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), ((i * verticalDivisionWidth) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)) + (subTaskDimensions.height / 2));
						textContent = treeMatrix[i][j];
						t = t + 1;

					}
					else
					{
						shapeCenterPoint.setLocation((((3 * cmData.getDiagramDimensions().width)/4) -(subTaskDimensions.width/2)), ((i * verticalDivisionWidth) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)));
						textCenterPoint.setLocation(((j * horizontalDivisionWidth) + (subTaskDimensions.width / 2) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), ((i * verticalDivisionWidth) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)) + (subTaskDimensions.height / 2));
						textContent = treeMatrix[i][j];

					}

				}
				else
				{
					shapeCenterPoint.setLocation(((j * horizontalDivisionWidth) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), ((i * verticalDivisionWidth) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)));
					textCenterPoint.setLocation(((j * horizontalDivisionWidth) + (subTaskDimensions.width / 2) + (((1 - this.SUBTASK_WIDTH_PERCENTAGE) / 2) * horizontalDivisionWidth)), ((i * verticalDivisionWidth) + (((1 - this.SUBTASK_HEIGHT_PERCENTAGE) / 2) * verticalDivisionWidth)) + (subTaskDimensions.height / 2));
					textContent = treeMatrix[i][j];


				}//				shapeCenterPoint.setLocation(((j*horizontalDivisionWidth)+((1-SUBTASK_WIDTH_PERCENTAGE)*horizontalDivisionWidth)),((i*verticalDivisionWidth)/2)


				hDataReturn.setShapeCenterPointsArray(b, shapeCenterPoint);
				hDataReturn.setTextCenterPointsArray(b, textCenterPoint);
				hDataReturn.setSubTaskRectangleDimensions(subTaskDimensions);
				hDataReturn.setTextContent(b, textContent);
				hDataReturn.setBoundingRectangle(b, new Rectangle(shapeCenterPoint, subTaskDimensions));
				b = b + 1;
			}
		}


		int counter = 1;
		int y;
                int qq;
		Point aa = new Point();
		String xx = new String();
		int nn;


		for(int i = 1; i <= k; i++)
		{

			y = 1;
			for (int j = 0; j < child[i - 1]; j++)
			{

				if (i == 1)
				{
					hDataReturn.setConnectingLines((counter - 1), hDataReturn.getShapeCenterPointsArray(0), hDataReturn.getShapeCenterPointsArray(counter));
					counter = counter + 1;
				} else
				{
					System.out.println(parentMatrix[i][j] + "  " + treeMatrix[i-1][y - 1]);
					xx = treeMatrix[i-1][y-1];
                                        qq = j;
					while (parentMatrix[i][qq].equals(xx) )
					{

						nn = (counter - (qq + 1) - child[i - 2] + y);
						System.out.println(nn);

						aa.setLocation(hDataReturn.getShapeCenterPointsArray(nn));
						hDataReturn.setConnectingLines((counter - 1), aa , hDataReturn.getShapeCenterPointsArray(counter));
						qq = qq + 1;
                                                counter = counter + 1;
                                                if(qq >= child[i-1] )
                                                    break;

					}
                                        if(qq >= child[i-1] )
                                                    break;
//                                        if((j ==  0) && (!parentMatrix[i][j].equals(xx)) )
//                                        {
//                                            y = y + 1;
//                                        }

//                                        else if(!parentMatrix[i][j].equals(xx))
//					{

						j = qq - 1;
//						counter = counter - 1;
						y = y + 1;
//					}
				}


			}

		}





		return hDataReturn;

	}
}
