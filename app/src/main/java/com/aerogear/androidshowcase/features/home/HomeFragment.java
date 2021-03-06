package com.aerogear.androidshowcase.features.home;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aerogear.androidshowcase.R;
import com.aerogear.androidshowcase.features.home.presenters.HomeViewPresenter;
import com.aerogear.androidshowcase.features.home.views.HomeView;
import com.aerogear.androidshowcase.features.home.views.HomeViewImpl;
import com.aerogear.androidshowcase.mvp.views.BaseFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomeViewPresenter, HomeView> {

    public static final String TAG = "home";

    @Inject
    HomeViewPresenter homeViewPresenter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        AndroidInjection.inject(this);
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.homeViewPresenter = null;
    }

    @Override
    protected HomeViewPresenter initPresenter() {
        return homeViewPresenter;
    }

    @Override
    protected HomeView initView() {
        return new HomeViewImpl(this) {};
    }

}
