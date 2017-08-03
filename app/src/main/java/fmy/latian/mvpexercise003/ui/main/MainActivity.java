package fmy.latian.mvpexercise003.ui.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import fmy.latian.mvpexercise003.R;
import fmy.latian.mvpexercise003.data.models.Menu;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    MainPresenter presenter;

    private ListView mListView;

    private MainAdapter listAdapter;

    private MainAdapterListener mAdapterListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        DaggerMainComponent.builder()
                .mainPresenterModule(new MainPresenterModule( getApplicationContext(),this))
                .build()
                .inject(this);

        presenter.loadMenus();
    }

    private void initUI(){
        mListView = (ListView) findViewById(R.id.listview_menu);
        mAdapterListener = new MainAdapterListener() {
            @Override
            public void onItemClick(Menu menu) {
                presenter.loadMenuItem(menu);
            }
        };

    }

    @Override
    public void onMenusLoad(List<Menu> menus) {

        listAdapter = new MainAdapter(getApplicationContext(), menus, new MainAdapterListener() {
            @Override
            public void onItemClick(Menu menu) {
                presenter.loadMenuItem(menu);
            }
        });
        mListView.setAdapter(listAdapter);

    }

    @Override
    public void onNoMenuAvailable() {
        Toast.makeText(getApplicationContext(),"No menu available",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListItemClicked(Menu menu) {
        Toast.makeText(getApplicationContext(),"Menu : "+menu.getName(),Toast.LENGTH_SHORT).show();
    }

}
