package com.example.presenters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.example.tvfirst.R;
import com.hitherejoe.leanbackcards.LiveCardView;

/**
 * Created by User on 02.03.2016.
 */
public class CardPresenter extends Presenter {
    private static int CARD_WIDTH = 313;
    private static int CARD_HEIGHT = 300;
    private Context context;
    private Drawable defaultCardImage;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        context = parent.getContext();
        defaultCardImage = context.getResources().getDrawable(R.drawable.movie);

        //LiveCardView liveCardView = new LiveCardView(context);

        ImageCardView imageCardView = new ImageCardView(context) {
            @Override
            public void setSelected(boolean selected) {

                updateCardBackground(this, selected);

                super.setSelected(selected);
            }
        };

//        imageCardView.setLayoutParams(new ViewGroup.LayoutParams(CARD_WIDTH, CARD_HEIGHT));
//        imageCardView.setLayoutParams(new ViewGroup.LayoutParams(CARD_WIDTH, CARD_HEIGHT));
        imageCardView.setFocusable(true);
        imageCardView.setFocusableInTouchMode(true);
        //imageCardView.setMainImage(defaultCardImage);
        updateCardBackground(imageCardView, false);

        return new ViewHolder(imageCardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        String str = item.toString();
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        cardView.setTitleText("Заголовок");
        cardView.setContentText(str);
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
       // cardView.setBadgeImage(defaultCardImage);
        cardView.setMainImage(defaultCardImage);
        AttributeSet attributeSet;

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        ImageCardView cardView = (ImageCardView) viewHolder.view;

        // Remove references to images so that the garbage collector can free up memory.
        cardView.setBadgeImage(null);
        cardView.setMainImage(null);
    }

    private void updateCardBackground(ImageCardView cardView, boolean selected) {
        int color = context.getResources().getColor(R.color.blue_button);
        int selectedColor = context.getResources().getColor(R.color.orange_button);
        int defaultColor = context.getResources().getColor(R.color.green_button);
        color = selected ? selectedColor : defaultColor;
        cardView.setInfoAreaBackgroundColor(color);
        cardView.setBackgroundColor(color);
    }


}
