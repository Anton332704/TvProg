package com.example.presenters;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.example.tvfirst.R;
import com.example.tvfirst.Utils;

/**
 * Created by User on 01.03.2016.
 */
public class DetailsDescriptionPresenter extends AbstractMyDescriptionPresenter {
    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object itemData) {

        viewHolder.getTitle().setText(itemData.toString());
        viewHolder.getBody().setMaxLines(15);
        viewHolder.getBody().setLines(15);
        //viewHolder.getBody().setHeight(350);

        viewHolder.getSubtitle().setText("2014   Drama   TV-14");

        viewHolder.getBody().setText("1232132132133ctetur "
                + "adipisicing elit, sed do eiusmod tempor incididunt ut labore "
                + " et dolore magna aliqua. Ut en232132132133ctetur "
                        + "adipisicing elit, sed do eiusmod tempor in " +
                "                + \"adipisicing elit, sed do eiusmod tempor in232132132133ctetur \"\n" +
                "                + \"adipisicing elit, sed do eiusmod tempor in232132132133ctetur \"\n" +
                "                + \"adipisicing elit, sed do eiusmod tempor in232132132133ctetur \"\n" +
                "                + \"adipisicing elit, sed do eiusmod tempor in ut aliquip ex ea "
                + "adipisicing elit, sed do eiusmod tempor incididunt ut labore "
                + " et dolore magna aliqua. Ut enim ad minim veniam, quis "
                + "nostrud exercitation ullamco laboris nisi ut aliquip ex ea "
                + "adipisicing elit, sed do eiusmod tempor incididunt ut labore "
                + " et dolore magna aliqua. Ut enim ad minim veniam, quis "
                + "nostrud exercitation ullamco laboris nisi ut aliquip ex ea "
                + "commodo consequat.");

        //viewHolder.view.setBackgroundColor(R.color.indigo);
//        viewHolder.getBody().setBackgroundColor(R.color.orange_button);
//        viewHolder.getTitle().setBackgroundColor(R.color.orange_button);

    }



}
