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
package edu.jss.ise.chartglazer.shared;

import java.awt.Color;
import java.awt.Font;

/**
 * This class contains common shared variables between all classes.
 * @author Rishabh
 */
public interface CommonVariables
{
    public static String FONT_FACE = new String(Font.SANS_SERIF);
    public static int FONT_STYLE = Font.PLAIN;
    public static int DEFAULT_PADDING = 15;
    public static Color BORDER_COLOR = Color.GRAY;
    public static Color FILL_COLOR = new Color(180, 200, 0);
    public static Color TEXT_COLOR = Color.DARK_GRAY;
}
