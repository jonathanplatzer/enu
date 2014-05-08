/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.obj.base;

import java.util.ArrayList;

/**
 *
 * @author mike7707
 */
public class ButtonGroup {

    private ArrayList<UIElement> buttons;
    
    public ButtonGroup() {
        buttons = new ArrayList<>();
    }
    
    /**
     * This method adds a button to the group.
     * @param button
     * @return returns true if button was added. returns false if not
     */
    public boolean addButton(UIElement button)
    {
        if(buttons!=null)
        {
            buttons.add(button);
            return true;
        }
        return false;
    }
    
    /**
     * deselects every button in group except the given button
     * @param button 
     */
    public void selectButton(UIElement button)
    {
        for(UIElement element : buttons)
        {
            if(button != element)
            {
                ((ToggleButton)element).setToggled(false);
            }
        }
    }
}
