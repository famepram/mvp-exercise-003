package fmy.latian.mvpexercise003.ui.main;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import fmy.latian.mvpexercise003.R;
import fmy.latian.mvpexercise003.data.models.Menu;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    MainPresenter presenter;

    private ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

//        DaggerMainComponent.builder()
//                .MainPresenterModule(new MainPresenter(getApplicationContext(),this))
//                .build()
//                .inject(this);
        DaggerMainComponent.builder()
                .MainPresenterModule(new MainPresenter( this))
                .build()
                .inject(this);


    }

    private void initUI(){
        mListView = (ListView) findViewById(R.id.listview_menu);
    }

    @Override
    public void onMenusLoad(List<Menu> menus) {

    }

    @Override
    public void onNoMenuAvailable() {

    }
}
