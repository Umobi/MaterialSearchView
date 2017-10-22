package br.com.mauker.materialsearchview.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.mauker.materialsearchview.MaterialSearchView;
import br.com.mauker.materialsearchview.R;
import br.com.mauker.materialsearchview.db.HistoryContract;

/**
 * Created by mauker on 19/04/2016.
 * Edited by ramonvic on 02/10/2017
 *
 * Default adapter used for the suggestion/history ListView.
 */
public class SearchAdapter extends ArrayAdapter<MaterialSearchView.Searchable> {

    public SearchAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        MaterialSearchView.Searchable item = getItem(position);

        ImageView iv_icon = convertView.findViewById(R.id.iv_icon);
        TextView tv_content = convertView.findViewById(R.id.tv_str);

        if (item != null) {
            tv_content.setText(item.toString());
            if (item.isHistory()) {
                iv_icon.setImageResource(R.drawable.ic_history_white);
            } else {
                iv_icon.setImageResource(R.drawable.ic_action_search_white);
            }
        }

        return convertView;
    }
}
