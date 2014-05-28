/*
 * Copyright (C) 2014 mwahlhuetter <m.wahl1996 at gmail.com>
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
import com.through_other_eyes.enu.obj.base.Button;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author mwahlhuetter <m.wahl1996 at gmail.com>
 */
public class QuestionDialogNoButton extends Button {

    public QuestionDialogNoButton(Point position, File elementImage, File hoverImage) throws IOException {
        super(position, elementImage, hoverImage);
    }

    public QuestionDialogNoButton(File elementImage, File hoverImage, GameCore.Align align, int offset, int y) throws IOException {
        super(elementImage, hoverImage, align, offset, y);
    }

    @Override
    public void clicked() {
    }
}
