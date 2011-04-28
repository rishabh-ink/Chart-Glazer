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
package edu.jss.ise.chartglazer.data.output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.svg.SVGDocument;

/**
 * This class actually has the SVG canvas on which all the assistant classes will draw their diagram.
 * @author Rishabh
 */
public class SVGDocumentData
{
	/**
	 * A DOMImplementation used by Apache Batik.
	 */
	protected DOMImplementation dom;
	/**
	 * This <code>Document</code> object contains the in-memory-drawing of the diagram.
	 */
	protected SVGDocument outputSVGDoc;
	/**
	 * This will help generate the SVG image from the <code>outputSVGDoc</code> object.
	 * @see outputSVGDoc
	 */
	protected SVGGraphics2D generator;
	/**
	 * A DocumentBuilderFactory used by Apache Batik.
	 */
	protected DocumentBuilderFactory factory;
	/**
	 * A DocumentBuilder used by Apache Batik.
	 */
	protected DocumentBuilder builder;

	/**
	 * Creates empty implementations of the SVG and W3C DOM objects.
	 * @throws ParserConfigurationException In case there is some problem with builder = factory.newDocumentBuilder();
	 */
	public SVGDocumentData() throws ParserConfigurationException
	{
		dom = SVGDOMImplementation.getDOMImplementation();
		outputSVGDoc = (SVGDocument) dom.createDocument(SVGDOMImplementation.SVG_NAMESPACE_URI, "svg", null);
		generator = new SVGGraphics2D(outputSVGDoc);
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		// set the SVG drawing canvas size
		// generator.setSVGCanvasSize (new Dimension(640, 480));

		 
		// set the SVG drawing canvas size
		// generator.setSVGCanvasSize (new Dimension(640, 480));
	}

	/**
	 * @return The generator object, which helps generate the SVG image from the <code>outputSVGDoc</code> object.
	 */
	public SVGGraphics2D getGenerator()
	{
		return generator;
	}

	/**
	 * @return This <code>Document</code> object contains the in-memory-drawing of the diagram.
	 */
	public SVGDocument getOutputSVGDoc()
	{
		return outputSVGDoc;
	}
}
