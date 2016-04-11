package com.example.tvfirst;

import android.content.res.Resources;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnActionClickedListener;
import android.widget.Toast;

import com.example.presenters.CardPresenter;
import com.example.presenters.DetailsDescriptionPresenter;
import com.example.presenters.IconHeaderItem;

/**
 * Created by User on 01.03.2016.
 */
public class DetailFragmentMy extends DetailsFragment {
    private static final String TAG = "MediaItemDetailsFragment";
    private ArrayObjectAdapter mRowsAdapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildDetails();

    }

    private void buildDetails()
    {
        ClassPresenterSelector selector = new ClassPresenterSelector();
        DetailsDescriptionPresenter detailsDescriptionPresenter = new DetailsDescriptionPresenter();

        FullWidthDetailsOverviewRowPresenter rowPresenter = new FullWidthDetailsOverviewRowPresenter(new DetailsDescriptionPresenter());

        rowPresenter.setOnActionClickedListener(new OnActionClickedListener() {
            @Override
            public void onActionClicked(Action action) {
                if(action.getId() == 1)
                {
                    Utils.makeMyToast(getActivity(), action.getLabel1().toString());
                }
            }
        });
        //rowPresenter.setBackgroundColor(R.color.indigo);

        selector.addClassPresenter(DetailsOverviewRow.class, rowPresenter);
        //selector.addClassPresenter(ListRow.class, new ListRowPresenter());
        mRowsAdapter = new ArrayObjectAdapter(selector);

        Resources res = getActivity().getResources();
        DetailsOverviewRow detailsOverview = new DetailsOverviewRow("Some detailds about my stream here");

        // Add images and action buttons to the details view
        detailsOverview.setImageDrawable(res.getDrawable(R.drawable.ic_banner));
        detailsOverview.addAction(new Action(1, "Watch stream", "Have fun"));
        detailsOverview.addAction(new Action(2, "See more info"));
        detailsOverview.addAction(new Action(3, "Super action"));

        mRowsAdapter.add(detailsOverview);

        // Add a Related items row
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new GridItemPresenter());
        listRowAdapter.add("Media Item 1");
        listRowAdapter.add("Media Item 2");
        listRowAdapter.add("Media Item 3");
        HeaderItem header = new HeaderItem(0, "Related Items");
        //mRowsAdapter.add(new ListRow(header, listRowAdapter));

        ArrayObjectAdapter listRowAdapter1 = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter1.add("Media Item 1");
        listRowAdapter1.add("Media Item 2");
        listRowAdapter1.add("Media Item 3");
        IconHeaderItem header1 = new IconHeaderItem(0, "Related Items", R.drawable.film);
       // mRowsAdapter.add(new ListRow(header1, listRowAdapter1));

        setAdapter(mRowsAdapter);
    }
}
