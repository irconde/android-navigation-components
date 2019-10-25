package edu.ualr.navigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

/**
 * Created by irconde on 2019-10-22.
 */
public class PizzaOrderFragment extends Fragment {

    // TODO 11. Define an interface to communicate the fragment with the activity

    public interface OnPlaceOrderListener {
        void onPlaceOrderButtonClicked();
    }

    private OnPlaceOrderListener listener;

    // TODO 12. Set the listener once the fragment has been attached to the activity
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnPlaceOrderListener) {
            listener = (OnPlaceOrderListener)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.pizza_order, container, false);
        MaterialButton placeOrderBtn = view.findViewById(R.id.place_order_button);
        // TODO 13. We need to handle button click events to update the badge
        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPlaceOrderButtonClicked();
            }
        });
        return view;
    }
}