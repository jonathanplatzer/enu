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

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mwahlhuetter <m.wahl1996 at gmail.com>
 */
public class GameTimeThread extends Thread{

    private Calendar gameTime = Calendar.getInstance();
    
    @Override
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            gameTime.add(Calendar.DATE, 1);
        }
    }
    
    public Calendar getGameTime()
    {
        return gameTime;
    }
}
