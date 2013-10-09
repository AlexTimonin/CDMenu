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
        switch(position) {
            case 0:
                showSimpleMenu();
                break;
            case 1:
                showMenuWithCustomListView(R.layout.custom_listview);
                break;
            case 2:
                showMenuWithCustomListItem(R.layout.custom_list_item, R.id.customListItemTextView);
                break;
            case 3:
                showMenuWithCustomListItem(R.layout.custom_list_item, R.id.customListItemTextView, styleListener);
                break;
        }
    }

    private void showSimpleMenu() {
        CDMenu.createDialogMenu(this)
                .setData(R.menu.custom_menu)
                .show();
    }

    private void showMenuWithCustomListView(int listViewId) {
        CDMenu.createDialogMenu(this)
                .setData(R.menu.custom_menu)
                .setCustomListView(listViewId)
                .show();
    }

    private void showMenuWithCustomListItem(int layoutId, int textViewId) {
        CDMenu.createDialogMenu(this)
                .setData(R.menu.custom_menu)
                .setCustomListItem(layoutId, textViewId, null)
                .show();
    }

    private void showMenuWithCustomListItem(int layoutId, int textViewId, StyleListener styleListener) {
        CDMenu.createDialogMenu(this)
                .setData(R.menu.custom_menu)
                .setCustomListView(R.layout.custom_listview)
                .setCustomListItem(layoutId, textViewId, styleListener)
                .show();
    }

    private StyleListener styleListener = new StyleListener() {
        @Override
        public View onStyleChangeRequested(View listItemView, int position) {
            if (position%2 == 0) {
                ((ImageView)listItemView.findViewById(R.id.customListItemImageView)).setImageResource(R.drawable.star);
            } else {
                ((ImageView)listItemView.findViewById(R.id.customListItemImageView)).setImageResource(R.drawable.star2);
            }
            return listItemView;
        }
    };
}

