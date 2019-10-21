package edu.ualr.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 2;

    private static final int PIZZA_FRAGMENT_IDX = 0;
    private static final int CONTACT_FRAGMENT_IDX = 1;

    private ViewPager2 viewPager;
    private FragmentStateAdapter pageAdapter;
    // TODO 05. We store a reference to our new BottomNavigationView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
        // TODO 06. Make sure we have already created a view pager
        // TODO 07. Create and add a OnNavigationItemSelectedListener to the BottomNavigationView
                 // TODO 08. We'll have to set the current page of the view pager based on the
                //  id of the currently selected menu item in the BottomNavigationView
                // TODO 10. We can associate a badge with a menu item

        // TODO 09. We'll have to register a new OnPageChangeCallback to set the corresponding tab
        //  whenever the user makes a swipe gesture and changes the current selected page.
        // TODO 09.01. We get the MenuItem in the given position
        // TODO 09.02. We set the selected item id of the bottom navigation menu
    }

    // TODO 10. We can associate a badge with a menu item and modify the number within

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case PIZZA_FRAGMENT_IDX:
                    return new PizzaOrderFragment();
                case CONTACT_FRAGMENT_IDX:
                    return new FormFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}
