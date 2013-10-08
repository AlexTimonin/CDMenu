package com.bekitzur.cdmenu;

import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Customizable Dialog Menu for Android
 *    https://github.com/BeKitzur/CDMenu
 */
public class CDMenu {

    private Context context;
    private ListView listView;
    private StyleListener styleListener;
    private int listItemLayoutId, listItemTextViewId;
    private AdapterView.OnItemClickListener onItemClickListener;

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
     * Set a custom {@link android.widget.ListView} instead of the default one.
     * @param layoutId resource Id of a layout xml file to be used as a ListView for the menu. If you pass <b>null</b>, or if <b>layoutId</b> doesn't match a {@link android.widget.ListView} object, {@link IllegalArgumentException} will be thrown.
     * @return {@link CDMenu} with a custom listView
     */
    public CDMenu setCustomListView(int layoutId) {
        try {
            listView = (ListView)((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(layoutId, null);
        } catch (InflateException e) {
            throw new IllegalArgumentException("layoutId has to be a valid resource ID");
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("layoutId has to represent a ListView object");
        }
        return this;
    }

    /**
     * Set a custom {@link ListView} instead of the default one.
     * @param listView a {@link ListView} object to be used as a ListView for the menu. Passing <b>null</b> causes {@link IllegalArgumentException} to be thrown.
     * @return {@link CDMenu} with a custom listView
     */
    public CDMenu setCustomListView(ListView listView) {
        if (listView == null)  {
            throw new IllegalArgumentException("listView is null");
        }
        this.listView = listView;
        return this;
    }

    /**
     * Set a custom list item instead of the default one.
     * @param layoutId resource Id of a layout xml file to be used as a list item instead of the default one. If you pass <b>null</b>, or if layoutId doesn't match a ViewGroup object, {@link IllegalArgumentException} will be thrown.
     * @param textViewId id of the {@link android.widget.TextView} that will contain the menu item name. If you pass <b>null</b>, or textViewId doesn't match a {@link android.widget.TextView} that is contained in layoutId, {@link IllegalArgumentException} will be thrown.
     * @param styleListener a listener that handles the custom list item's inner views' manual updating. Pass <b>null</b> if you don't need anything other than items' text to be updated.
     * @return {@link CDMenu} with a custom List Item
     */
    public CDMenu setCustomListItem(int layoutId, int textViewId, StyleListener styleListener) {
        ViewGroup testViewGroup;
        try {
            testViewGroup = (ViewGroup)((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(layoutId, null);
        } catch (InflateException e) {
            throw new IllegalArgumentException("layoutId has to be a valid resource ID");
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("layoutId has to represent a ViewGroup object");
        }
        if (!(testViewGroup.findViewById(textViewId) instanceof TextView)) {
            throw new IllegalArgumentException("textViewId has to represent a TextView object");
        }

        this.listItemLayoutId = layoutId;
        this.listItemTextViewId = textViewId;
        this.styleListener = styleListener;
        return this;
    }

    /**
     * Set a listener to respond to menu clicks.
     * @param onItemClickListener an object that implements {@link android.widget.AdapterView.OnItemClickListener} interface. If you pass <b>null</b>, {@link IllegalArgumentException} will be thrown.
     * @return {@link CDMenu} with an attached {@link android.widget.AdapterView.OnItemClickListener}
     */
    public CDMenu setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            throw new IllegalArgumentException("onItemClickListener is null");
        }
        this.onItemClickListener = onItemClickListener;
        return this;
    }
}
