package com.example.tatsbytatspos.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tatsbytatspos.R;
import com.example.tatsbytatspos.activity.MainActivity;
import com.example.tatsbytatspos.activity.OrderHistory;
import com.example.tatsbytatspos.data.OrderDatabase;

public class PaymentFragment extends DialogFragment {

    private RecyclerView recyclerView;
    private OrderSummaryAdapter adapter;
    private List<Order> orderList;
    private OrderDatabase orderDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        ImageButton exit = view.findViewById(R.id.exit); // Make sure your XML has a Button with id="exit"
        exit.setOnClickListener(v -> dismiss());


        Button paidGcash = view.findViewById(R.id.paid_gcash);

        paidGcash.setOnClickListener(v -> {
            TransactionFragment transactionFragment = new TransactionFragment();
            transactionFragment.show(getParentFragmentManager(), "myPaymentTag");
        });

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
    }
}
