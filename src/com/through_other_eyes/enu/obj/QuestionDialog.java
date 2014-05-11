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
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.Resource;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author mwahlhuetter <m.wahl1996 at gmail.com>
 */
public class QuestionDialog extends UIElement {

    private ArrayList<UIElement> dialogElements = new ArrayList<>();
    private String Text;
    private CloseQuestionDialogButton cqdb;

    public QuestionDialog(Point position, BufferedImage elementImage) throws IOException {
        super(position, elementImage);
        cqdb = new CloseQuestionDialogButton(Resource.QUESTION_DIALOG_CLOSE, GameCore.Align.CENTER, 127, 64);
        dialogElements.add(cqdb);
        setVisible(false);
    }

    public QuestionDialog(BufferedImage elementImage, GameCore.Align align, int offset, int y) throws IOException {
        super(elementImage, align, offset, y);
        cqdb = new CloseQuestionDialogButton(Resource.QUESTION_DIALOG_CLOSE, GameCore.Align.CENTER, 127, 64);
        dialogElements.add(cqdb);
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
        g2.drawImage(getElementImage(), getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
        cqdb.drawObject(g2);
    }

    @Override
    public void move(float delta) {
    }

    public ArrayList<UIElement> getDialogElements() {
        return dialogElements;
    }
}
