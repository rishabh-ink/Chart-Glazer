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
package edu.jss.ise.chartglazer.control;

import edu.jss.ise.chartglazer.data.DataManager;
import edu.jss.ise.chartglazer.data.input.AppearanceInputData;
import edu.jss.ise.chartglazer.data.input.RawInputData;
import edu.jss.ise.chartglazer.data.interim.assist.calc.CoordinateManagerData;
import edu.jss.ise.chartglazer.data.interim.assist.draw.DrawingManagerData;
import edu.jss.ise.chartglazer.data.output.SVGDocumentData;
import edu.jss.ise.chartglazer.process.calc.CoordinateManager;
import edu.jss.ise.chartglazer.process.draw.DrawingManager;
import edu.jss.ise.chartglazer.shared.CGLogger;
import java.util.logging.Level;
import javax.xml.parsers.ParserConfigurationException;

/**
 * The main controller class.
 * @author rishabh
 */
public class Glazer
{

	/**
	 * Handles the processing of the input data.
	 */
	private DataManager cgDataManager;
	/**
	 * Deals with the overall management of coordinate calculation.
	 */
	private CoordinateManager cgCoordinateManager;
	/**
	 * Deals with the overall drawing process of the diagram.
	 */
	private DrawingManager cgDrawingManager;
	/**
	 * This object hold the entire drawn-in-memory drawing of the diagram.
	 */
	private SVGDocumentData outputDiagram;

	/**
	 * This constructor allocates memory for all the worker classes.
	 *
	 * @throws ParserConfigurationException
	 */
	public Glazer() throws ParserConfigurationException
	{
		CGLogger.trace("In public Glazer()... (constructor)");

		cgDataManager = new DataManager();
		cgCoordinateManager = new CoordinateManager();


		cgDrawingManager = new DrawingManager();
		outputDiagram = new SVGDocumentData();
	}

	/**
	 * Glazer is actually a representative of the backend at the front end. So he fetches the raw input from the front end and returns back with the data.
	 * @param inputSpecs Contains all the input data required.
	 * @param appearanceSpecs Contains font face, style, size, color etc. preferences.
	 */
	public void returnBackWithRawInput(RawInputData inputSpecs, AppearanceInputData appearanceSpecs)
	{
		CGLogger.trace("In public void returnBackWithRawInput(RawInputData inputSpecs)...");
		this.cgDataManager.setInputSpecs(inputSpecs);
		this.cgDataManager.setAppearanceSpecs(appearanceSpecs);
	}

	/**
	 * The core, heart of Chart Glazer. Coordinates all the worker classes together.
	 * Here is where the complete backend processing occurs.
	 * @param outputDiagram
	 * @throws Exception
	 */
	public void startGlazing(SVGDocumentData outputDiagram) throws Exception
	{
		CGLogger.trace("In public SVGDocumentData startGlazing()...");
		try
		{
			// perform preliminary validations like check whether the diagram can be drawn or not etc.
			//cgDataManager.performInputValidation();

			// fetch input in the required form for CoordinateManager
			CoordinateManagerData cmData = cgDataManager.getCoordinateManagerData();

			// setup local coordinate manager data copy
			cgCoordinateManager.setCmData(cmData);

			// calculate the coordinates
			DrawingManagerData dmData = cgCoordinateManager.calculateCoordinates();

			// draw the diagram based on the given coordinates
			cgDrawingManager.drawDiagram(dmData, outputDiagram, cgDataManager.getAppearanceSpecs());
		}
		catch (Exception ex)
		{
			CGLogger.trace(Level.SEVERE, ex.toString());
			throw ex;
		}
		finally
		{
		}
	}
}
