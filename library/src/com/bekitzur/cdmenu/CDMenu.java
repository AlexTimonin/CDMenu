package com.bekitzur.cdmenu;

import android.content.Context;

/**
 * Customizable Dialog Menu for Android
 *    https://github.com/BeKitzur/CDMenu
 */
public class CDMenu {

    private Context context;

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
}
