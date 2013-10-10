package com.bekitzur.cdmenu.samples;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.bekitzur.cdmenu.CDMenu;
import com.bekitzur.cdmenu.StyleListener;

public class MyActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private final int SIMPLE_MENU = 0;
    private final int MENU_CUSTOM_LISTVIEW = 1;
    private final int MENU_CUSTOM_LIST_ITEM = 2;
    private final int MENU_CUSTOM_LIST_ITEM_AND_STYLE_LISTENER = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.main_list_item, getResources().getStringArray(R.array.main_activity_list_items)));
        getListView().setOnItemClickListener(this);
        getListView().setBackgroundColor(Color.WHITE);
        getListView().setCacheColorHint(0);
        registerForContextMenu(getListView());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        createSampleCDMenu(position).show();
    }

    private CDMenu createSampleCDMenu(int position) {
        switch(position) {
            case SIMPLE_MENU: return createSimpleMenu();
            case MENU_CUSTOM_LISTVIEW: return createMenuWithCustomListView(R.layout.custom_listview);
            case MENU_CUSTOM_LIST_ITEM: return createMenuWithCustomListItem(R.layout.custom_list_item, R.id.customListItemTextView);
            case MENU_CUSTOM_LIST_ITEM_AND_STYLE_LISTENER: return createMenuWithCustomListItem(R.layout.custom_list_item, R.id.customListItemTextView, styleListener);
            default: return createSimpleMenu();
        }
    }

    private CDMenu createSimpleMenu() {
        return CDMenu.createDialogMenu(this).setData(R.menu.custom_menu);
    }

    private CDMenu createMenuWithCustomListView(int listViewId) {
        return CDMenu.createDialogMenu(this)
                .setData(R.menu.custom_menu)
                .setCustomListView(listViewId);
    }

    private CDMenu createMenuWithCustomListItem(int layoutId, int textViewId) {
        return CDMenu.createDialogMenu(this)
                .setData(R.menu.custom_menu)
                .setCustomListItem(layoutId, textViewId, null);
    }

    private CDMenu createMenuWithCustomListItem(int layoutId, int textViewId, StyleListener styleListener) {
        return CDMenu.createDialogMenu(this)
                .setData(R.menu.custom_menu)
                .setCustomListView(R.layout.custom_listview)
                .setCustomListItem(layoutId, textViewId, styleListener);
    }

    private StyleListener styleListener = new StyleListener() {
        @Override
        public View onStyleChangeRequested(View listItemView, int position) {
            ((ImageView)listItemView.findViewById(R.id.customListItemImageView)).setImageResource(position % 2 == 0 ? R.drawable.star : R.drawable.star2);
            return listItemView;
        }
    };
}

