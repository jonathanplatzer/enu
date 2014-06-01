/* Europa NON Universalis - A dogma 2001 game
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
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.Resource;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author mwahlhuetter &lt;m.wahl1996 at gmail.com&gt;
 */
public class QuestionDialog extends UIElement {

    private ArrayList<UIElement> dialogElements = new ArrayList<>();
    private String title;
    private String question;
    private CloseQuestionDialogButton cqdb;
    private QuestionDialogYesButton qdyb;
    private QuestionDialogNoButton qdnb;
    private Font font = GameCore.font.deriveFont(12f);
    private BufferedImage questionDialogHeader;
    private BufferedImage questionDialogLine1pxImage;
    private BufferedImage questionDialogBottomImage;
    private int textHeight;

    /**
     * Enum for setting the type of question catalog that should be displayed
     */
    public static enum DialogType {

        CENTRALBANK, COURTHOUSE, EUROPEAN_PARLIAMENT, EUROPEAN_COMMISSION
    }

    /**
     * DO NOT USE. INCONSISTENT TO OTHER METHOD
     *
     * @param position
     * @param elementImage
     * @throws IOException
     */
    public QuestionDialog(Point position, BufferedImage elementImage) throws IOException {
        super(position, elementImage);
        cqdb = new CloseQuestionDialogButton(Resource.QUESTION_DIALOG_CLOSE, Resource.QUESTION_DIALOG_CLOSE_HOVER, GameCore.Align.CENTER, 127, 64);
        dialogElements.add(cqdb);
        setVisible(false);
        questionDialogLine1pxImage = ImageIO.read(Resource.QUESTION_DIALOG_LINE1PX);
        questionDialogBottomImage = ImageIO.read(Resource.QUESTION_DIALOG_BOTTOM);
    }

    /**
     * Constructor of question dialog
     *
     * @param align
     * @param offset
     * @param y
     * @throws IOException
     */
    public QuestionDialog(GameCore.Align align, int offset, int y) throws IOException {
        super(ImageIO.read(Resource.QUESTION_DIALOG_HEADER), align, offset, y);
        cqdb = new CloseQuestionDialogButton(Resource.QUESTION_DIALOG_CLOSE, Resource.QUESTION_DIALOG_CLOSE_HOVER, GameCore.Align.CENTER, 127, 64);
        qdyb = new QuestionDialogYesButton(Resource.QUESTION_DIALOG_YES, Resource.QUESTION_DIALOG_YES_HOVER, GameCore.Align.CENTER, 73, 0);
        qdnb = new QuestionDialogNoButton(Resource.QUESTION_DIALOG_NO, Resource.QUESTION_DIALOG_NO_HOVER, GameCore.Align.CENTER, 115, 0);
        dialogElements.add(cqdb);
        dialogElements.add(qdyb);
        dialogElements.add(qdnb);
        questionDialogHeader = ImageIO.read(Resource.QUESTION_DIALOG_HEADER);
        questionDialogLine1pxImage = ImageIO.read(Resource.QUESTION_DIALOG_LINE1PX);
        questionDialogBottomImage = ImageIO.read(Resource.QUESTION_DIALOG_BOTTOM);
        setVisible(false);
    }

    @Override
    public void clicked() {

    }

    @Override
    public void hoverElement() {
    }

    @Override
    public void leaveElement() {
    }

    @Override
    public void update() {
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.setFont(font);
        g2.setColor(Color.WHITE);
        
        calculateHeight(g2);
        
        setDimension(new Dimension(getDimension().width, 15 + textHeight + 21 + 3));
        
        qdyb.setPosition(new Point(getPosition().x + getDimension().width / 2 + 53, getPosition().y + textHeight + 16));
        qdnb.setPosition(new Point(getPosition().x + getDimension().width / 2 + 95, getPosition().y + textHeight + 16));
        cqdb.setPosition(new Point(getPosition().x + getDimension().width / 2 + 118, getPosition().y + 4));
        
        //Header zeichnen
        g2.drawImage(questionDialogHeader, getPosition().x, getPosition().y, questionDialogHeader.getWidth(), questionDialogHeader.getHeight(), null);
        
        for (int i = 0; i < textHeight + 21; i++) { //21 ist die höhe der JA/NEIN buttons + 1 damit unten noch ein kleiner rand ist
            g2.drawImage(questionDialogLine1pxImage, getPosition().x, getPosition().y + 16 + i, getDimension().width, 1, null);
        }
        //Unteren rand zeichnen
        g2.drawImage(questionDialogBottomImage, getPosition().x, getPosition().y + getDimension().height - 2, null);
        //Title zeichnen
        g2.drawString(title, getPosition().x + 5, getPosition().y + 13);
        //Closequestiondialogbutton zeichnen
        cqdb.drawObject(g2);
        qdyb.drawObject(g2);
        qdnb.drawObject(g2);
                
        drawQuestion(g2);
    }

    private void calculateHeight(Graphics2D g2) {
        textHeight = 0;

        FontMetrics fm = g2.getFontMetrics();

        int lineHeight = fm.getHeight();
        int curX = getPosition().x + 5;
        int curY = getPosition().y + 26;

        String[] words = question.split(" ");

        for (String word : words) {
            int wordWidth = fm.stringWidth(word + " ");
            if (curX + wordWidth >= getPosition().x + getDimension().width) {
                curY += lineHeight;
                textHeight += lineHeight;
                curX = getPosition().x + 5;
            }
            curX += wordWidth;
        }
        textHeight += lineHeight;
        System.out.println(textHeight);
    }

    /**
     * Logic for the drawing of the question. this methods makes automatic line
     * breaks while drawing
     *
     * @param g2
     */
    private void drawQuestion(Graphics2D g2) {
        FontMetrics fm = g2.getFontMetrics();

        int lineHeight = fm.getHeight();
        int curX = getPosition().x + 5;
        int curY = getPosition().y + 26;

        String[] words = question.split(" ");

        for (String word : words) {
            int wordWidth = fm.stringWidth(word + " ");
            if (curX + wordWidth >= getPosition().x + getDimension().width) {
                curY += lineHeight;
                curX = getPosition().x + 5;
            }
            g2.drawString(word, curX, curY);
            curX += wordWidth;
        }
    }

    @Override
    public void move(float delta) {
    }

    public ArrayList<UIElement> getDialogElements() {
        return dialogElements;
    }

    /**
     *
     * @param dialogType
     */
    public void show(DialogType dialogType) {
        //Reset position of QuestionDialog
        setPosition(new Point(GameCore.WIDTH / 2 - getDimension().width / 2, 60));
        cqdb.setPosition(new Point(GameCore.WIDTH / 2 + 118, 64));

        switch (dialogType) {
            case CENTRALBANK:
                this.title = "European Central Bank";
                //question = questionmanager.retrieve new question in this section
                break;
            case COURTHOUSE:
                this.title = "Court of Justice of the European Union";
                break;
            case EUROPEAN_PARLIAMENT:
                this.title = "European Parliament";
                break;
            case EUROPEAN_COMMISSION:
                this.title = "European Commission";
                break;
        }

        question = "This implementation will separate the given String into an array"
                + " of String by using the split method with a space character as"
                + " the only word separator, so it's probably not very robust."
                + " It also assumes that the word is followed by a space character"
                + " and acts accordingly when moving the curX position.";

        setVisible(true);
    }

    /**
     * closes the dialog window
     */
    public void dispose() {
        setVisible(false);
    }

    public int getTextHeight() {
        return textHeight;
    }
}
