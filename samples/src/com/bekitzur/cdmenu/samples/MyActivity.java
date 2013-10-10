package com.bekitzur.cdmenu.samples;

import android.app.ListActivity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.*;
import com.bekitzur.cdmenu.CDMenu;
import com.bekitzur.cdmenu.StyleListener;

public class MyActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private final int DEFAULT_ANDROID_CONTEXT_MENU = 0;
    private final int SIMPLE_CDMENU_XML = 1;
    private final int SIMPLE_CDMENU_OBJECT = 2;
    private final int SIMPLE_CDMENU_WITH_SUBMENUS = 3;
    private final int CDMENU_CUSTOM_LISTVIEW_XML = 4;
    private final int CDMENU_CUSTOM_LISTVIEW_OBJECT = 5;
    private final int CDMENU_CUSTOM_LIST_ITEM = 6;
    private final int CDMENU_CUSTOM_LIST_ITEM_AND_STYLE_LISTENER = 7;

    private Menu myMenu;

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
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_menu, menu);
        myMenu = menu;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (position == DEFAULT_ANDROID_CONTEXT_MENU) {
            view.showContextMenu();
            return;
        }
        createSampleCDMenu(position).show();
    }

    private CDMenu createSampleCDMenu(int position) {
        switch(position) {
            case SIMPLE_CDMENU_XML: return createSimpleMenu(R.menu.custom_menu);
            case SIMPLE_CDMENU_OBJECT: return createSimpleMenu(myMenu);
            case SIMPLE_CDMENU_WITH_SUBMENUS: return createSimpleMenu(R.menu.custom_menu_with_submenus);
            case CDMENU_CUSTOM_LISTVIEW_XML: return createMenuWithCustomListView(R.layout.custom_listview);
            case CDMENU_CUSTOM_LISTVIEW_OBJECT: return createMenuWithCustomListView(createCustomListView());
            case CDMENU_CUSTOM_LIST_ITEM: return createMenuWithCustomListItem(R.layout.custom_list_item, R.id.customListItemTextView);
            case CDMENU_CUSTOM_LIST_ITEM_AND_STYLE_LISTENER: return createMenuWithCustomListItem(R.layout.custom_list_item, R.id.customListItemTextView, styleListener);
            default: return createSimpleMenu(R.menu.custom_menu);
        }
    }

    private CDMenu createSimpleMenu(int menuId) {
        return CDMenu.createDialogMenu(this).setData(menuId);
    }

    private CDMenu createSimpleMenu(Menu menu) {
        if (menu == null) {
            Toast.makeText(this, "Menu object is not initialized, showing CDMenu with the default data", Toast.LENGTH_LONG).show();
            return createSimpleMenu(R.menu.custom_menu);
        }
        return CDMenu.createDialogMenu(this).setData(menu);
    }

    private CDMenu createMenuWithCustomListView(int listViewId) {
        return CDMenu.createDialogMenu(this)
                .setData(R.menu.custom_menu)
                .setCustomListView(listViewId);
    }

    private CDMenu createMenuWithCustomListView(ListView listView) {
        return CDMenu.createDialogMenu(this)
                .setData(R.menu.custom_menu)
                .setCustomListView(listView);
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
            ((TextView)listItemView.findViewById(R.id.customListItemSubTextView)).setText("Description " + position);
            return listItemView;
        }
    };

    private ListView createCustomListView() {
        ListView listView = new ListView(this);
        listView.setDivider(new ColorDrawable(0xff2020A0));
        listView.setDividerHeight(1);
        listView.setBackgroundColor(Color.LTGRAY);
        return listView;
    }
}

