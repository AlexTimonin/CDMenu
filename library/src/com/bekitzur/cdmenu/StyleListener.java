package com.bekitzur.cdmenu;

import android.view.View;
import android.widget.ListView;

/**
 * Sends callbacks when populating the {@link CDMenu}'s {@link ListView} with items that are using custom layout
 */
public interface StyleListener {
    /**
     * Sends a callback every time a list item is being created
     * @param listItemView a {@link View} describing a custom list item
     * @param position item's position in the list
     * @return {@code listItemView} after applying changes to it
     */
    View onStyleChangeRequested(View listItemView, int position);
}
