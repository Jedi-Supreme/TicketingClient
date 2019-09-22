package com.jedit.ticketingclient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.jedit.ticketingclient.R;

public class User_Details_fragment extends Fragment{

    private TextInputEditText et_login_fn, et_login_ln, et_login_email;
    private Button bt_login_final;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_user_details,container,false);

        et_login_fn = view.findViewById(R.id.et_user_fn);
        et_login_ln = view.findViewById(R.id.et_user_ln);
        et_login_email = view.findViewById(R.id.et_user_email);

        bt_login_final = view.findViewById(R.id.bt_login_final);

        return view;
    }
}
