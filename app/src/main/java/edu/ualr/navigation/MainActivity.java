package edu.ualr.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

// TODO 05. Add more tabs to the activity so we can see the behavior of the scrollable TabLayout

public class MainActivity extends AppCompatActivity implements PizzaOrderFragment.OnPlaceOrderListener {

    private static final int NUM_PAGES = 4;

    private static final int PIZZA_FRAGMENT_IDX = 0;
    private static final int CONTACT_FRAGMENT_IDX = 1;
    private static final int PIZZA_FRAGMENT_COPY_IDX = 2;
    private static final int CONTACT_FRAGMENT_COPY_IDX = 3;

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
                       onTabIconSet(tab, position);
                    }
                }).attach();
    }

    // TODO 07. We create a new method that adds an icon to each tab -->
    private void onTabIconSet (TabLayout.Tab tab, int position) {
        TypedArray icons = getResources().obtainTypedArray(R.array.icons);
        int iconId = icons.getResourceId(position, -1);
        if (iconId != -1) {
            tab.setIcon(iconId);
        }
    }

    // TODO 08. Create and add a badge to a tab
    private void incrementBadgeCounter(TabLayout.Tab tab) {
        // TODO 09. Create and initialize an instance of BadgeDrawable.
        // Subsequent calls to this method will reuse the existing BadgeDrawable
        BadgeDrawable badge = tab.getOrCreateBadge();
        badge.setVisible(true);
        // TODO 10. Show a number in the badge
        badge.setNumber(badge.getNumber() + 1);
    }

    private void onTabNameSet(TabLayout.Tab tab, int position) {
        String[] tabLabels = getResources().getStringArray(R.array.tabs);
        tab.setText(tabLabels[position]);
    }

    // TODO 14. We implement the interface methods
    @Override
    public void onPlaceOrderButtonClicked() {
        incrementBadgeCounter(tabLayout.getTabAt(0));
    }

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
                case PIZZA_FRAGMENT_COPY_IDX:
                    return new PizzaOrderFragment();
                case CONTACT_FRAGMENT_COPY_IDX:
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
