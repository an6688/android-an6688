package com.example.winetracker;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WineDetail extends Fragment {


    public WineDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wine_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String wineId = getActivity().getIntent().getStringExtra(WineList.WINE_ID);
        Wine wine = DataProvider.wineMap.get(wineId);

        TextView wineName = view.findViewById(R.id.txtWineName);
        wineName.setText(wine.getName());

        TextView winePrice = view.findViewById(R.id.wineType);
        winePrice.setText(Helper.getPriceFormatted(wine.getPrice()));

        TextView wineDescription = view.findViewById(R.id.txtWineDescription);
        wineDescription.setText(wine.getDescription());

        ImageView imageView = view.findViewById(R.id.imgWineDetail);
        Bitmap bitmap = Helper.getBitMapFromAsset(getContext(), wine.getId());
        imageView.setImageBitmap(bitmap);

    }
}
