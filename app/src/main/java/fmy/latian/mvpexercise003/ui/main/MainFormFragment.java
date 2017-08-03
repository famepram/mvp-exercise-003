package fmy.latian.mvpexercise003.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fmy.latian.mvpexercise003.R;

/**
 * Created by Femmy on 8/4/2017.
 */

public class MainFormFragment extends Fragment {

    public Activity act;

    private MainContract.Presenter mPresenter;

    public MainFormFragment(){

    }

    public MainFormFragment newInstance(){
        return new MainFormFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        act = getActivity();
        //mPresenter =act.prese
        return root;
    }

}
