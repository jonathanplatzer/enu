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
package com.through_other_eyes.enu.util;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.CloseQuestionDialogButton;
import com.through_other_eyes.enu.obj.QuestionDialogNoButton;
import com.through_other_eyes.enu.obj.QuestionDialogYesButton;
import com.through_other_eyes.enu.obj.base.ButtonGroup;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * @author mwahlhuetter
 * @date 23.03.2014
 */
public class MouseInputController implements MouseWheelListener, MouseListener, MouseMotionListener {

    //TO DO
    // make interface clickable, check if mouseevent source is game object + clickable, then call click, interact etc method of the object licked
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (GameCore.state == GameCore.State.MAINMENU) {

            for (UIElement uielement : GameCore.mainMenu.getUiElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();
                if (uielement.isVisible()) {
                    if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                        uielement.clicked();
                    }
                }
            }
        }
        if (GameCore.state == GameCore.State.PLAY) {
            for (UIElement uielement : GameCore.gameScreen.getInstMenu().getUiElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();
                if (uielement.isVisible()) {
                    if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                        uielement.clicked();
                        ButtonGroup buttonGroup = GameCore.gameScreen.getInstMenu().getButtonGroup();
                        buttonGroup.selectButton(uielement);
                    }
                }
            }
            for (UIElement uielement : GameCore.questionDialog.getDialogElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();
                if (uielement.isVisible()) {
                    if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                        uielement.clicked();
                    }
                }
            }
        }
        if (GameCore.state == GameCore.State.PAUSED) {

            for (UIElement uielement : GameCore.pauseMenu.getUiElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();
                if (uielement.isVisible()) {
                    if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                        uielement.clicked();
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private int mausaltx;
    private int mausalty;

    @Override
    public void mouseDragged(MouseEvent e) {
        if (GameCore.state == GameCore.State.PLAY) {
            Point uiElementPosition = GameCore.questionDialog.getPosition();
            Dimension uiElementDimension = GameCore.questionDialog.getDimension();
            Point mousePosition = e.getPoint();

            if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                if (mausaltx != 0 && mausalty != 0) {
                    GameCore.questionDialog.setPosition(new Point(uiElementPosition.x + mousePosition.x - mausaltx, uiElementPosition.y + mousePosition.y - mausalty));
                }
            }
            mausaltx = mousePosition.x;
            mausalty = mousePosition.y;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        mausaltx = e.getPoint().x;
        mausalty = e.getPoint().y;

        if (GameCore.state == GameCore.State.MAINMENU) {
            for (UIElement uielement : GameCore.mainMenu.getUiElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();

                if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                    uielement.hoverElement();
                    uielement.setMouseHoverPossible(false);
                } else {
                    if (!uielement.isMouseHoverPossible()) {
                        uielement.leaveElement();
                    }
                    uielement.setMouseHoverPossible(true);
                }
            }
        }

        if (GameCore.state == GameCore.State.PLAY) {
            for (UIElement uielement : GameCore.gameScreen.getInstMenu().getUiElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();

                if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                    uielement.hoverElement();
                    uielement.setMouseHoverPossible(false);
                } else {
                    if (!uielement.isMouseHoverPossible()) {
                        uielement.leaveElement();
                    }
                    uielement.setMouseHoverPossible(true);
                }
            }
            for (UIElement uielement : GameCore.questionDialog.getDialogElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();

                if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                    uielement.hoverElement();
                    uielement.setMouseHoverPossible(false);
                } else {
                    if (!uielement.isMouseHoverPossible()) {
                        uielement.leaveElement();
                    }
                    uielement.setMouseHoverPossible(true);
                }
            }
        }

        if (GameCore.state == GameCore.State.PAUSED) {
            for (UIElement uielement : GameCore.pauseMenu.getUiElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();

                if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                    uielement.hoverElement();
                    uielement.setMouseHoverPossible(false);
                } else {
                    if (!uielement.isMouseHoverPossible()) {
                        uielement.leaveElement();
                    }
                    uielement.setMouseHoverPossible(true);
                }
            }
        }
    }

    /**
     * Checks with the given parametes if the mouse intersects a specific button
     *
     * @param uiElementPosition
     * @param uiElementDimension
     * @param mousePosition
     * @return
     */
    private boolean intersects(Point uiElementPosition, Dimension uiElementDimension, Point mousePosition) {
//        System.out.println("x=" + uiElementPosition.x + "y=" + uiElementPosition.y);
//        System.out.println("x=" + mousePosition.x + "y=" + mousePosition.y);
//        System.out.println("x=" + (uiElementPosition.x + uiElementDimension.width) + "y=" + (uiElementPosition.y + uiElementDimension.height));
        return mousePosition.x >= uiElementPosition.x
                && mousePosition.y >= uiElementPosition.y
                && mousePosition.x <= uiElementPosition.x + uiElementDimension.width
                && mousePosition.y <= uiElementPosition.y + uiElementDimension.height;
    }
}
