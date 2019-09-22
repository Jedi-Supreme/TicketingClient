package com.jedit.ticketingclient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;
import com.jedit.ticketingclient.R;
import com.jedit.ticketingclient.activities.LoginActivity;
import com.jedit.ticketingclient.common;

public class Mobile_number_fragment extends Fragment implements View.OnClickListener {

    private TextInputEditText et_login_number;
    private CountryCodePicker codePicker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_numb_input,container,false);

         et_login_number = view.findViewById(R.id.et_login_number);
         Button bt_numbfrag_confirm = view.findViewById(R.id.bt_numbfrag_input);
         codePicker = view.findViewById(R.id.hbb_picker);

         bt_numbfrag_confirm.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        test_number();
    }

    private void test_number(){

        String country_code = codePicker.getSelectedCountryCode();

            if (et_login_number.getText() != null &&
                    (!et_login_number.getText().toString().equals("") || !et_login_number.getText().toString().isEmpty())){

                try {
                    String number = et_login_number.getText().toString();
                    int numb = Integer.parseInt(number);

                    if (String.valueOf(numb).length() < 9){
                        common.Mysnackbar(getView(),"Enter valid Phone Number", Snackbar.LENGTH_SHORT).show();
                    }else {

                        //Toast.makeText(getContext(), country_code + numb, Toast.LENGTH_SHORT).show();

                        if (getActivity() instanceof LoginActivity){
                            Number_Verification_fragment numb_verification_frag = new Number_Verification_fragment();
                            ((LoginActivity) getActivity()).pass_data_toFragment(numb_verification_frag,
                                    country_code + numb);
                        }
                    }

                }catch (Exception ignored){
                    common.Mysnackbar(getView(),"Enter valid Phone Number", Snackbar.LENGTH_SHORT).show();
                }

            }else {
                common.Mysnackbar(getView(),"Enter valid Phone Number", Snackbar.LENGTH_SHORT).show();
            }
    }



}
