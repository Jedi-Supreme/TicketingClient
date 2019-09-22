package com.jedit.ticketingclient.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.PhoneAuthProvider;
import com.jedit.ticketingclient.R;
import com.jedit.ticketingclient.activities.LoginActivity;

import java.lang.ref.WeakReference;

public class Number_Verification_fragment extends Fragment implements View.OnClickListener {

    private final long COUNTDOWN_TIME = 30000; // 30 seconds
    private final long SECS = 1000;
    private TextInputEditText et_code_1, et_code_2, et_code_3, et_code_4, et_code_5, et_code_6;
    private CountDownTimer countDownTimer;

    private TextInputEditText[] code_input_Array;

    private WeakReference<Context> weakverification;

    private TextView tv_verify_downtime, tv_verify_resend, tv_verify_status;
    private ProgressBar probar_verify_code;

    String verification_id;
    PhoneAuthProvider.ForceResendingToken resendingToken;
    Bundle registration_bundle;

    //=============================================ON CREATE========================================
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_numb_verification, container, false);

        Button bt_verify_code = view.findViewById(R.id.bt_frag_verifycode);

        weakverification = new WeakReference<>(getContext());
        registration_bundle = getArguments();

        tv_verify_downtime = view.findViewById(R.id.tv_verify_dwntime);
        tv_verify_resend = view.findViewById(R.id.tv_verify_resend);
        tv_verify_status = view.findViewById(R.id.tv_verify_Status);

        et_code_1 = view.findViewById(R.id.et_code_1);
        et_code_2 = view.findViewById(R.id.et_code_2);
        et_code_3 = view.findViewById(R.id.et_code_3);
        et_code_4 = view.findViewById(R.id.et_code_4);
        et_code_5 = view.findViewById(R.id.et_code_5);
        et_code_6 = view.findViewById(R.id.et_code_6);

        probar_verify_code = view.findViewById(R.id.probar_verify_code);

        code_input_Array = new TextInputEditText[]{et_code_1, et_code_2, et_code_3, et_code_4, et_code_5, et_code_6};

        //--------------------------------------------COUNTDOWN TIMER-------------------------------
        countDownTimer = new CountDownTimer(COUNTDOWN_TIME, SECS) {

            @Override
            public void onTick(long millisUntilFinished) {

                String remaining_time;
                int timeleft = (int) (millisUntilFinished / SECS);

                if (timeleft < 10) {
                    remaining_time = getResources().getString(R.string.resend_code_in) + "0"
                            + millisUntilFinished / SECS;
                } else {
                    remaining_time = getResources().getString(R.string.resend_code_in)
                            + millisUntilFinished / SECS;
                }

                tv_verify_downtime.setText(remaining_time);
            }

            @Override
            public void onFinish() {
                tv_verify_resend.setEnabled(true);
                tv_verify_downtime.setVisibility(View.GONE);
            }
        };
        //--------------------------------------------COUNTDOWN TIMER-------------------------------

        bt_verify_code.setOnClickListener(this);

        return view;

        }
    //=============================================ON CREATE========================================


    void editorSwitcher(){

        for (final TextInputEditText et_input : code_input_Array){
            et_input.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    switch (et_input.getId()){
                        case R.id.et_code_1:
                            et_code_2.requestFocus();
                            break;
                        case R.id.et_code_2:
                            et_code_3.requestFocus();
                            break;
                        case R.id.et_code_3:
                            et_code_4.requestFocus();
                            break;
                        case R.id.et_code_4:
                            et_code_5.requestFocus();
                            break;
                        case R.id.et_code_5:
                            et_code_6.requestFocus();
                            break;
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }


    @Override
    public void onClick(View v) {

        if (getActivity() instanceof LoginActivity){
            ((LoginActivity) getActivity()).loadUser_frag();
        }
    }
}
