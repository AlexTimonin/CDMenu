package com.bekitzur.cdmenu;

import android.view.MenuItem;

/**
 * Sends callback when a {@link com.bekitzur.cdmenu.CDMenu}'s item is clicked
 */
public interface OnCDMenuItemClickListener {
    /**
     * Sends a callback when a list item is clicked
     * @param menuItem the item that has been clicked
     */
    void onCDMenuItemClicked(MenuItem menuItem);
}
