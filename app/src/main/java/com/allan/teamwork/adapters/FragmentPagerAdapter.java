package com.allan.teamwork.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.allan.teamwork.ui.ContactUsFragment;
import com.allan.teamwork.ui.ImagesFragment;
import com.allan.teamwork.ui.ViewImagesFragment;

public class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    public FragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ContactUsFragment tab1 = new ContactUsFragment();
                return tab1;
            case 1:
                ImagesFragment tab2 = new ImagesFragment();
                return tab2;
            case 2:
                ViewImagesFragment tab3 = new ViewImagesFragment();
                return tab3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Contact Us";
            case 1: return "Images";
            case 2: return "View Images";
        }
        return null;
    }
}
