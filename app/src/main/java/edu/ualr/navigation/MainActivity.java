package edu.ualr.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

// TODO 05. Add more tabs to the activity so we can see the behavior of the scrollable TabLayout
// TODO 14. We implement the PizzaOrderFragment.OnPlaceOrderListener interface

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private FragmentStateAdapter pageAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabs);
        pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                       onTabNameSet(tab, position);
                       // TODO 07
                    }
                }).attach();
    }

    // TODO 07. We create a new method that adds an icon to each tab -->
    // TODO 08. Create and add a badge to a tab
    // TODO 09. Create and initialize an instance of BadgeDrawable.
    // TODO 10. Show a number in the badge

    private void onTabNameSet(TabLayout.Tab tab, int position) {
        String[] tabLabels = getResources().getStringArray(R.array.tabs);
        tab.setText(tabLabels[position]);
    }

    // TODO 14. We implement the PizzaOrderFragment.OnPlaceOrderListener interface

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        private static final int NUM_PAGES = 2;
        private static final int PIZZA_FRAGMENT_IDX = 0;
        private static final int CONTACT_FRAGMENT_IDX = 1;

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
