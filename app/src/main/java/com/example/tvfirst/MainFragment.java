package com.example.tvfirst;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.widget.TextView;

import com.example.presenters.CardPresenter;
import com.example.presenters.HeaderItemsPresenter;
import com.example.presenters.IconHeaderItem;
import com.example.presenters.IconHeaderItemPresenter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 26.02.2016.
 */
public class MainFragment extends BrowseFragment implements LoaderManager.LoaderCallbacks<HashMap<String, List<Movie>>> {

    ArrayObjectAdapter mRowsAdapter;
    Context context;
    private BackgroundManager backgroundManager;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        backgroundManager = BackgroundManager.getInstance(getActivity());
        backgroundManager.attach(getActivity().getWindow());
        setupElements();
        loadRows();

        setOnItemViewClickedListener(new OnItemViewClickedListener() {
            @Override
            public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
                //((TextView)itemViewHolder.view).setText("555" + "");
                Intent intent = new Intent(getActivity(), DetailActivityMy.class);

                //intent.getExtras().putLong();
                //intent.putExtra("id", 5);
                startActivity(intent);
            }
        });
        setOnItemViewSelectedListener(new OnItemViewSelectedListener() {
            @Override
            public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
                backgroundManager.setDrawable(getResources().getDrawable(R.drawable.backgound_fragment));
            }
        });
    }

    private void setupElements()
    {
        setTitle("Hello Android TV!");
        setHeadersState(HEADERS_ENABLED);

//        setHeaderPresenterSelector(new PresenterSelector() {
//            @Override
//            public Presenter getPresenter(Object item) {
//                return new HeaderItemsPresenter();
//            }
//        });

        setHeaderPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object o) {
                return new IconHeaderItemPresenter();
            }
        });
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.true_indigo));
        setSearchAffordanceColor(getResources().getColor(R.color.orange_button));
    }

    private void loadRows() {


        CardPresenter cardPresenter = new CardPresenter();
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
//        mRowsAdapter2 = new ArrayObjectAdapter(new ListRowPresenter());
//        mRowsAdapter3 = new ArrayObjectAdapter(new ListRowPresenter());
//        IconHeaderItem gridItemPresenterHeader = new IconHeaderItem(0, "GridItemPresenter", R.drawable.ic_header_image);
//        IconHeaderItem gridItemPresenterHeader1 = new IconHeaderItem(1, "GridItemPresenter1", R.drawable.ic_header_image);
        IconHeaderItem gridItemPresenterHeader2 = new IconHeaderItem(2, "GridItemPresenter2", R.drawable.ic_header_image);

//        HeaderItem gridItemPresenterHeader = new HeaderItem(0, "Section 1");
//        HeaderItem gridItemPresenterHeader1 = new HeaderItem(1, "Section 2");
//        HeaderItem gridItemPresenterHeader2 = new HeaderItem(2, "Section 3");
        IconHeaderItem gridItemIconPresenter = new IconHeaderItem(0, "GridItemPresenter", R.drawable.ic_header_image);
        IconHeaderItem gridItemIconPresenter1 = new IconHeaderItem(1, "GridItemPresenter1", R.drawable.ic_header_image);
        IconHeaderItem gridItemIconPresenter2 = new IconHeaderItem(2, "GridItemPresenter2", R.drawable.ic_header_image);
        GridItemPresenter mGridPresenter = new GridItemPresenter();

        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(cardPresenter);
        gridRowAdapter.add("ITEM 1");
        gridRowAdapter.add("ITEM 2");
        gridRowAdapter.add("ITEM 3");
        ArrayObjectAdapter gridRowAdapter1 = new ArrayObjectAdapter(cardPresenter);
        gridRowAdapter1.add("ITEM 23");
        gridRowAdapter1.add("ITEM 32");
        gridRowAdapter1.add("ITEM 123");
        ArrayObjectAdapter gridRowAdapter5 = new ArrayObjectAdapter(cardPresenter);
        gridRowAdapter5.add("ITEM 23");
        gridRowAdapter5.add("ITEM 32");
        gridRowAdapter5.add("ITEM 123");
        gridRowAdapter5.add("ITEM 12321313");
        mRowsAdapter.add(new ListRow(gridItemIconPresenter, gridRowAdapter));
        mRowsAdapter.add(new ListRow(gridItemIconPresenter1, gridRowAdapter1));
        mRowsAdapter.add(new ListRow(gridItemIconPresenter2, gridRowAdapter5));

        //mRowsAdapter.add(new ListRow(gridItemIconPresenter1, gridRowAdapter1));
        //mRowsAdapter.add(new ListRow(gridItemPresenterHeader2, gridRowAdapter5));
        /* set */
        setAdapter(mRowsAdapter);

    }

    private void prepareBackgroundManager()
    {
        BackgroundManager backgroundManager = BackgroundManager.getInstance(getActivity());
        backgroundManager.attach(getActivity().getWindow());
        getResources().getDrawable(R.drawable.ic_banner);
    }

    @Override
    public Loader<HashMap<String, List<Movie>>> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<HashMap<String, List<Movie>>> loader, HashMap<String, List<Movie>> data) {

    }

    @Override
    public void onLoaderReset(Loader<HashMap<String, List<Movie>>> loader) {

    }
}
