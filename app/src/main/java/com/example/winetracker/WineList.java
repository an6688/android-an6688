package com.example.winetracker;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import static com.example.winetracker.DataProvider.wines;


/**
 * A simple {@link Fragment} subclass.
 */
public class WineList extends Fragment {


    private List<Wine> wines = DataProvider.wines;
    public static final String WINE_ID = "WINE_ID";
    public WineList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wine_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataAdapter adapter = new DataAdapter(getContext(), R.layout.bottle_wine, wines);
        ListView listView = view.findViewById(R.id.wineListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Wine wine = wines.get(position);
                getActivity().getIntent().putExtra(WINE_ID, wine.getId());

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.item_detail_container, new WineDetail());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
