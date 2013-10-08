package com.bekitzur.cdmenu;

import android.app.Activity;
import android.content.Context;
import android.view.InflateException;
import android.view.Menu;

/**
 * Customizable Dialog Menu for Android
 *    https://github.com/BeKitzur/CDMenu
 */
public class CDMenu {

    private Context context;
    private Menu menu;

    /**
     * Creates new CDMenu
     * @param context context which CDMenu will use to show itself
     * @return newly created CDMenu
     * @throws IllegalArgumentException on context == 'null'
     */
    public static CDMenu createDialogMenu(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Null context where passed into createDialogMenu method");
        }
        CDMenu cDMenu = new CDMenu();
        cDMenu.context = context;
        return cDMenu;
    }

    /**
     * Set android menu resource which defines menu structure
     * @param menuResourceId Android menu resource id
     * @return CDMenu
     */
    public CDMenu setData(int menuResourceId) {
        try {
            ((Activity)context).getMenuInflater().inflate(menuResourceId, menu);
        } catch (InflateException e) {
            throw new IllegalArgumentException("menuResourceId has to be a valid menu resource ID");
        }
        return this;
    }

    /**
     * Set instance of Menu class to define menu structure
     * @param menu Instance of Menu class to define menu structure
     * @return CDMenu
     */
    public CDMenu setData(Menu menu) {
        this.menu = menu;
        return this;
    }

}
