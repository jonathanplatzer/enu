/*
 * Copyright (C) 2014 through.other.eyes
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.through_other_eyes.enu.obj.base;

import java.io.File;

/**
 * @author jplatzer
 * @date 11.05.2014
 */
public class Resource {
    
    // UI
    public static final File QUESTION_DIALOG = new File("res" + File.separator + "questiondialog.png");
    public static final File QUESTION_DIALOG_CLOSE = new File("res" + File.separator + "closequestiondialogbutton.png");
    
    public static final File INSTITUION_MENU = new File("res" + File.separator + "institutionmenu.png");
    
    public static final File CENTRALBANK = new File("res" + File.separator + "zentralbank.png");
    public static final File CENTRALBANK_HOVER = new File("res" + File.separator + "zentralbank_hovered.png");
    public static final File CENTRALBANK_TOGGLE = new File("res" + File.separator + "zentralbank_toggled.png");
    
    public static final File COURTHOUSE = new File("res" + File.separator + "gerichtshof.png");
    public static final File COURTHOUSE_HOVER = new File("res" + File.separator + "gerichtshof_hovered.png");
    public static final File COURTHOUSE_TOGGLE = new File("res" + File.separator + "gerichtshof_toggled.png");
    
    public static final File PLAY = new File("res" + File.separator + "mainmenu" + File.separator + "play.png");
    
    public static final File MAINMENU_BACKGROUND = new File("res" + File.separator + "mainmenu" + File.separator + "eu_640x480.png");
    
    public static final File STAISTICSBAR = new File("res" + File.separator + "statisticsbar.png");
    
    // MAP
    public static final File MAP_WATER = new File("res" + File.separator + "map" + File.separator + "background.gif");
    public static final File MAP_DATA = new File("res" + File.separator + "map" + File.separator + "data");
    
    // FONT
    public static final File FONT = new File("res" + File.separator + "font.ttf");
}
