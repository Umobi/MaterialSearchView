package br.com.mauker.materialsearchview.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.mauker.materialsearchview.MaterialSearchView;
import br.com.mauker.materialsearchview.R;

/**
 * Created by mauker on 19/04/2016.
 * Edited by ramonvic on 02/10/2017
 *
 * Default adapter used for the suggestion/history ListView.
 */
public class SearchAdapter extends BaseAdapter {

    private final Context context;
    private List<? extends MaterialSearchView.Searchable> mItems = new ArrayList<>();
    private List<MaterialSearchView.Searchable> mSelectedItems = new ArrayList<>();

    public SearchAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mItems != null ? mItems.size() : 0;
    }

    @Override
    public MaterialSearchView.Searchable getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        MaterialSearchView.Searchable item = getItem(position);

        ImageView iv_icon = convertView.findViewById(R.id.iv_icon);
        TextView tv_content = convertView.findViewById(R.id.tv_str);

        if (item != null) {
            tv_content.setText(item.toString());
            iv_icon.setImageResource(R.drawable.ic_action_search_white);

            if (mSelectedItems.contains(item)) {
                convertView.setBackgroundColor(context.getResources().getColor(R.color.green_light));
            } else {
                convertView.setBackgroundColor(Color.TRANSPARENT);
            }
        }

        return convertView;
    }

    public void addAll(@NonNull List<? extends MaterialSearchView.Searchable> collection) {
        this.mItems = collection;
        this.mSelectedItems = new ArrayList<>();
        this.notifyDataSetChanged();
    }

    public void clear() {
        addAll(new ArrayList<MaterialSearchView.Searchable>());
    }

    public void selectItemAtPosition(int position) {
        MaterialSearchView.Searchable item = getItem(position);
        if (mSelectedItems.contains(item)) {
            mSelectedItems.remove(item);
        } else {
            mSelectedItems.add(item);
        }
        notifyDataSetChanged();
    }

    public List<MaterialSearchView.Searchable> getSelectedItems() {
        return mSelectedItems;
    }
}
