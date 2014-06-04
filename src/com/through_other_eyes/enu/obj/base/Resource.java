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
    
    //QUESTION DIALOG
    public static final File QUESTION_DATA = new File("res" + File.separator + "questiondialog" + File.separator + "questions");
    
    public static final File QUESTION_DIALOG_HEADER = new File("res" + File.separator + "questiondialog" + File.separator + "questiondialog_header.png");
    public static final File QUESTION_DIALOG_LINE1PX = new File("res" + File.separator + "questiondialog" + File.separator + "questiondialog_1px_line.png");
    public static final File QUESTION_DIALOG_BOTTOM = new File("res" + File.separator + "questiondialog" + File.separator + "questiondialog_bottom.png");
    
    public static final File QUESTION_DIALOG_CLOSE = new File("res" + File.separator + "questiondialog" + File.separator + "closequestiondialogbutton.png");
    public static final File QUESTION_DIALOG_CLOSE_HOVER = new File("res" + File.separator + "questiondialog" + File.separator + "closequestiondialogbutton_hovered.png");
    
    public static final File QUESTION_DIALOG_YES = new File("res" + File.separator + "questiondialog" + File.separator + "questiondialog_yes.png");
    public static final File QUESTION_DIALOG_YES_HOVER = new File("res" + File.separator + "questiondialog" + File.separator + "questiondialog_yes_hovered.png");
    public static final File QUESTION_DIALOG_NO = new File("res" + File.separator + "questiondialog" + File.separator + "questiondialog_no.png");
    public static final File QUESTION_DIALOG_NO_HOVER = new File("res" + File.separator + "questiondialog" + File.separator + "questiondialog_no_hovered.png");
    
    //INSTITUTION MENU
    public static final File INSTITUION_MENU = new File("res" + File.separator + "institutionmenu.png");
    
    public static final File CENTRALBANK = new File("res" + File.separator + "zentralbank.png");
    public static final File CENTRALBANK_HOVER = new File("res" + File.separator + "zentralbank_hovered.png");
    public static final File CENTRALBANK_TOGGLE = new File("res" + File.separator + "zentralbank_toggled.png");
    
    public static final File COURTHOUSE = new File("res" + File.separator + "gerichtshof.png");
    public static final File COURTHOUSE_HOVER = new File("res" + File.separator + "gerichtshof_hovered.png");
    public static final File COURTHOUSE_TOGGLE = new File("res" + File.separator + "gerichtshof_toggled.png");
    
    public static final File EUROPEAN_PARLIAMENT = new File("res" + File.separator + "europeanparliament.png");
    public static final File EUROPEAN_PARLIAMENT_HOVER = new File("res" + File.separator + "europeanparliament_hovered.png");
    public static final File EUROPEAN_PARLIAMENT_TOGGLE = new File("res" + File.separator + "europeanparliament_toggled.png");
    
    public static final File EUROPEAN_COMMISSION = new File("res" + File.separator + "european_commission.png");
    public static final File EUROPEAN_COMMISSION_HOVER = new File("res" + File.separator + "european_commission_hovered.png");
    public static final File EUROPEAN_COMMISSION_TOGGLE = new File("res" + File.separator + "european_commission_toggled.png");
    
    //MENU ELEMENTS
    public static final File PLAY = new File("res" + File.separator + "mainmenu" + File.separator + "playbutton.png");
    public static final File EXIT = new File("res" + File.separator + "mainmenu" + File.separator + "exitbutton.png");
    public static final File INFO = new File("res" + File.separator + "mainmenu" + File.separator + "infobutton.png");
    public static final File MAINMENU = new File("res" + File.separator + "pausemenu" + File.separator + "mainmenubutton.png");
    
    public static final File MAINMENU_BACKGROUND = new File("res" + File.separator + "mainmenu" + File.separator + "eu_640x480_version2.png");
    public static final File PAUSEMENU_BACKGROUND  = new File("res" + File.separator + "pausemenu" + File.separator + "eu_640x480_version2.png");;
    
    //OTHER UI
    public static final File STAISTICSBAR = new File("res" + File.separator + "statisticsbar.png");
    
    public static final File DOGE = new File("res" + File.separator + "pixel-doge_small.png");
    
    // MAP
    public static final File MAP_WATER = new File("res" + File.separator + "map" + File.separator + "background.gif");
    public static final File MAP_DATA = new File("res" + File.separator + "map" + File.separator + "data");
    
    // FONT
    public static final File FONT = new File("res" + File.separator + "font.ttf");
}
