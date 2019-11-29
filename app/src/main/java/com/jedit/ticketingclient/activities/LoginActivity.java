package com.jedit.ticketingclient.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.jedit.ticketingclient.R;
import com.jedit.ticketingclient.fragments.Mobile_number_fragment;
import com.jedit.ticketingclient.fragments.User_Details_fragment;
import com.jedit.ticketingclient.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    ViewPager login_pager;
    LoginPager_test login_pager_adapter;

    //============================================ON CREATE=========================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);

       login_pager = findViewById(R.id.login_frag_pager);

         login_pager_adapter = new LoginPager_test(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        login_pager_adapter.addFragment(new Mobile_number_fragment(),"Mobile Number");
        login_pager.setAdapter(login_pager_adapter);

        //load_phoneFragment();
    }
    //============================================ON CREATE=========================================

    //-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-OVERRIDE METHODS-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    @Override
    protected void onResume() {
        super.onResume();

    }

    //-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-OVERRIDE METHODS-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    //-----------------------------------------------DEFINED METHODS--------------------------------
    public void pass_data_toFragment(Fragment fragment, String phoneNumber){
        Bundle bundle = new Bundle();
        bundle.putString(Passenger.COLUMN_PHONE_NUMBER,phoneNumber);
        fragment.setArguments(bundle);

        FragmentManager frag_manager = getSupportFragmentManager();
        FragmentTransaction frag_transact = frag_manager.beginTransaction();
        frag_transact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        frag_transact.replace(R.id.login_frag_pager,fragment);
        frag_transact.addToBackStack(null);
        frag_transact.commit();
    }

    public void load_phoneFragment(){
        Mobile_number_fragment mobileNumberFragment = new Mobile_number_fragment();
        FragmentManager frag_manager = getSupportFragmentManager();
        FragmentTransaction frag_transact = frag_manager.beginTransaction();
        frag_transact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        frag_transact.replace(R.id.login_frag_pager,mobileNumberFragment);
        frag_transact.commit();
    }

    public void loadUser_frag(){
        User_Details_fragment userDetailsFragment = new User_Details_fragment();
        FragmentManager frag_manager = getSupportFragmentManager();
        frag_manager.popBackStack();
        FragmentTransaction frag_transact = frag_manager.beginTransaction();
        frag_transact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        frag_transact.replace(R.id.login_frag_pager,userDetailsFragment);
        frag_transact.commit();
    }
    //-----------------------------------------------DEFINED METHODS--------------------------------


    public class LoginPager_test extends FragmentPagerAdapter{

        private final List<Fragment> mList = new ArrayList<>();
        private final List<String> mTitleList = new ArrayList<>();

        LoginPager_test(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mList.add(fragment);
            mTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }

    }


}
