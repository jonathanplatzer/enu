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
package com.through_other_eyes.enu.obj.base;

import java.util.ArrayList;

/**
 *
 * @author mwahlhuetter
 */
public class ButtonGroup {

    private ArrayList<UIElement> buttons;

    public ButtonGroup() {
        buttons = new ArrayList<>();
    }

    /**
     * This method adds a button to the group.
     *
     * @param button
     * @return returns true if button was added. returns false if not
     */
    public boolean addButton(UIElement button) {
        if (buttons != null) {
            buttons.add(button);
            return true;
        }
        return false;
    }

    /**
     * deselects every button in group except the given button
     *
     * @param button if null is given as paramter, every button gets deselected
     */
    public void selectButton(UIElement button) {
        if (button == null) {
            for (UIElement element : buttons) {
                ((ToggleButton) element).setToggled(false);
            }
            return;
        }
        for (UIElement element : buttons) {
            if (button != element) {
                ((ToggleButton) element).setToggled(false);
            }
        }
    }
}
