package lk.ruh.facebookapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter{

    public MyFragmentAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            //case 0:new FragmentOne();--->Not use this. Use singleton object//After create singleton it can use
            case 0:return FragmentOne.newInstace();
            case 1:return FragmentTwo.newInstace();
            case 2:return FragmentThree.newInstace();
            case 3:return FragmentFour.newInstace();
            default:return FragmentOne.newInstace();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return "Page "+(position+1);
    }
}
