package com.bekitzur.cdmenu;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * created by alext on Oct/08/13.
 */
public class CDMenuListAdapter extends BaseAdapter {

    private Context context;
    private Menu menu;
    private int listItemLayoutId, listItemTextViewId;
    private StyleListener styleListener;

    public CDMenuListAdapter (Context context, Menu menu, int listItemLayoutId, int listItemTextViewId, StyleListener styleListener) {
        this.context = context;
        this.menu = menu;
        this.listItemLayoutId = listItemLayoutId;
        this.listItemTextViewId = listItemTextViewId;
        this.styleListener = styleListener;
    }

    @Override
    public int getCount() {
        return menu.size();
    }

    @Override
    public Object getItem(int position) {
        return menu.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView == null ? ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(listItemLayoutId, null) : convertView;
        view = hackLayoutWidthBug((ViewGroup)view);
        TextView textView = (TextView)view.findViewById(listItemTextViewId);
        textView.setText(menu.getItem(position).getTitle());
        textView.setTextColor(menu.getItem(position).isEnabled() ? textView.getCurrentTextColor() : Color.LTGRAY);
        if (styleListener != null) {
            view = styleListener.onStyleChangeRequested(view, position);
        }
        return view;
    }

    private View hackLayoutWidthBug(ViewGroup parent) {
        View emptyMockView = new View(context);
        emptyMockView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 0));
        parent.addView(emptyMockView);
        return parent;
    }
}
