package com.example.winetracker;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAdapter extends ArrayAdapter<Wine> {
    private static List<Wine> wines;
    public static Map<String, Wine> winesMap = new HashMap<>();


    public DataAdapter(Context context, int resource, List<Wine> wines)
    {
        super (context, resource, wines);
        this.wines = wines;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bottle_wine, parent, false);
        }

        Wine wine = wines.get(position);

        TextView wineName = convertView.findViewById(R.id.txtWineName);
        wineName.setText(wine.getName());

        TextView winePrice = convertView.findViewById(R.id.txtBottlePrice);
        winePrice.setText(Helper.getPriceFormatted(wine.getPrice()));

        ImageView image = convertView.findViewById(R.id.imgWineDetail);

        Bitmap bitmap = Helper.getBitMapFromAsset(getContext(), wine.getId());
        image.setImageBitmap(bitmap);

        return convertView;
    }
}
