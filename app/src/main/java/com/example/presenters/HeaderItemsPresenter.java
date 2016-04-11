package com.example.presenters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.RowHeaderPresenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tvfirst.R;

/**
 * Created by User on 29.02.2016.
 */
public class HeaderItemsPresenter extends RowHeaderPresenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.header_item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        IconHeaderItem headerItem = (IconHeaderItem)((ListRow)item).getHeaderItem();
        View rootView = viewHolder.view;

//        ImageView imageView = (ImageView) rootView.findViewById(R.id.header_icon);
//        imageView.setBackground(rootView.getResources().getDrawable(R.drawable.ic_header_image));

//        ImageView iconView = (ImageView) rootView.findViewById(R.id.header_icon);
//        Drawable icon = rootView.getResources().getDrawable(R.drawable.ic_header_image, null);
//        iconView.setImageDrawable(icon);

        ImageView iconView = (ImageView) rootView.findViewById(R.id.header_icon);
        int iconResId = headerItem.getIconResId();
        if( iconResId != IconHeaderItem.ICON_NONE) {
            Drawable icon = rootView.getResources().getDrawable(iconResId, null);
            iconView.setImageDrawable(icon);
        }

        TextView textView = (TextView) rootView.findViewById(R.id.header_label);
        textView.setText("55555");
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        String text = ((TextView)viewHolder.view).getText().toString();
        ((TextView) (viewHolder.view)).setText(text);
    }

}
