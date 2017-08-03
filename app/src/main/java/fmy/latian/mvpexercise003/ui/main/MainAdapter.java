package fmy.latian.mvpexercise003.ui.main;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fmy.latian.mvpexercise003.R;
import fmy.latian.mvpexercise003.data.models.Menu;

/**
 * Created by Femmy on 8/3/2017.
 */

public class MainAdapter extends ArrayAdapter{

    List<Menu> menus;
    private MainAdapterListener mAdapterListener;

    public MainAdapter(@NonNull Context context, List<Menu> menus, MainAdapterListener mAdapterListener) {
        super(context, 0);
        this.menus = menus;
        this.mAdapterListener = mAdapterListener;
    }

    @Override
    public int getCount(){
        return menus.size();
    }

    @Override
    public Menu getItem(int i){
        return menus.get(i);
    }

    @Override
    public long getItemId(int i){
        return Long.parseLong(menus.get(i).getId());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        if(rowView == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            rowView = inflater.inflate(R.layout.main_lv_item, viewGroup, false);
        }

        final Menu m = getItem(i);

        TextView tvName = (TextView) rowView.findViewById(R.id.tv_menu_name);
        TextView tvCat  = (TextView) rowView.findViewById(R.id.tv_menu_category);
        TextView tvPrice = (TextView) rowView.findViewById(R.id.tv_menu_price);
        tvName.setText(m.getName());
        tvCat.setText(m.getCategory());
        tvPrice.setText(String.valueOf(m.getPrice()));
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapterListener.onItemClick(m);
            }
        });
        return rowView;
    }

}
