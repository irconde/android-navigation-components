package edu.ualr.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 2;

    private static final int PIZZA_FRAGMENT_IDX = 0;
    private static final int CONTACT_FRAGMENT_IDX = 1;

    private ViewPager2 viewPager;
    private FragmentStateAdapter pageAdapter;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.place_order:
                        viewPager.setCurrentItem(PIZZA_FRAGMENT_IDX);
                        incrementBadgeValue();
                        return true;
                    case R.id.edit_contact:
                        viewPager.setCurrentItem(CONTACT_FRAGMENT_IDX, true);
                        return true;
                    default:
                        return false;
                }
            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                MenuItem selectedItem = bottomNavigationView.getMenu().getItem(position);
                bottomNavigationView.setSelectedItemId(selectedItem.getItemId());
            }
        });
    }

    private void incrementBadgeValue() {
        BadgeDrawable badge = bottomNavigationView.getOrCreateBadge(R.id.place_order);
        badge.setNumber(badge.getNumber() + 1);
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
