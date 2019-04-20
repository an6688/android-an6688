package com.example.winetracker;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winetracker.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        if (mItem.id.equals("1")){
            rootView = inflater.inflate(R.layout.activity_keeper_form, container, false);
            //1 is the wine diary
            final EditText name = rootView.findViewById(R.id.editName);
            final EditText type = rootView.findViewById(R.id.editWineType);
            final EditText purchasedAt = rootView.findViewById(R.id.editPurchasedAt);
            final EditText price = rootView.findViewById(R.id.editPrice);
            final RatingBar rb;
            final Button button = rootView.findViewById(R.id.btnSubmit);

            rb = rootView.findViewById(R.id.ratingBar);
            rb.setNumStars(5);
            rb.setRating((float)3.5);


            TextWatcher loginTextWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String nameInput = name.getText().toString().trim();
                    String wineType = type.getText().toString().trim();
                    String purchaseLocation = purchasedAt.getText().toString().trim();
                    button.setEnabled(!nameInput.isEmpty() && !wineType.isEmpty() && !purchaseLocation.isEmpty());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            };
            name.addTextChangedListener(loginTextWatcher);
            type.addTextChangedListener(loginTextWatcher);
            purchasedAt.addTextChangedListener(loginTextWatcher);


            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int totalNumOfStars = rb.getNumStars();
                    float ratedValue = rb.getRating();

                    Toast.makeText(ItemDetailFragment.this.getActivity(), "Your rating:" + ratedValue + "/" + totalNumOfStars, Toast.LENGTH_SHORT).show();
                    wineKeeper keeperForm = new wineKeeper(name.getText().toString(),type.getText().toString(),
                            purchasedAt.getText().toString(),Double.parseDouble(price.getText().toString()));

                    Intent intent = new Intent (getContext(), ConfirmationPage.class);
                    intent.putExtra("keeperForm", keeperForm);

                    startActivity(intent);
                }


            });
        }
        else if (mItem.id.equals("2")){
            // 2 is list wine youve tried
        }

        else if (mItem.id.equals("3"))
        {
            // 3 is location of wines to get the wines you tried
        }
        return rootView;
    }

}
