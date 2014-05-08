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
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * @author mwahlhuetter
 * @date 04.04.2014
 */
public class Map extends GameComponent {

    private ArrayList<GameComponent> mapLayer = new ArrayList<>();
    private ArrayList<UIElement> uiElements = new ArrayList<>();
    private BufferedImage mapImage;
    
    public Map(BufferedImage mapImage) throws IOException {
        //InstitutionMenu instMenu = new InstitutionMenu(ImageIO.read(new File("res" + File.separator + "institutionmenu.png")), GameCore.Align.CENTER, 0, 0);
        //uiElements.add(instMenu);
        //this.mapImage = mapImage;
    }
    
    @Override
    public void update() {
//        x = x!=1 ? 1 : -1;
//        y = x!=1 ? 1 : -1;
    }

    int x,y;
    
    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(mapImage, x, y, null);
        for (UIElement uilement : uiElements) {
            if(uilement.isVisible())
            {
                uilement.drawObject(g2);
            }
        }
    }

    @Override
    public void move(float delta) {
    }

    /**
     * 
     * @return 
     */
    public InstitutionMenu getInstMenu() {
        for (UIElement uilement : uiElements) {
            if(uilement instanceof InstitutionMenu)
            {
                return (InstitutionMenu) uilement;
            }
        }
        return null;
    }

    public ArrayList<UIElement> getUiElements() {
        return uiElements;
    }
}
