package edu.ualr.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
                // TODO 08. We'll update the selected item in the drawer when new page is selected
            }
        });

        // TODO 07. We need to handle menu item clicks
        // TODO 07.01 We get a reference to the NavigationView and also to the DrawerLayout
        // TODO 07.02. We bind to the NavigationView a OnNavigationItemSelectedListener
        // TODO 07.03. We'll update the current shown page based on the item selected
        // TODO 09. We want to provide the hamburger icon in the toolbar to open the navigation drawer
        // TODO 09.01 We have to create a new instance of the ActionBarDrawerToggle
        // TODO 09.02. We set the ActionBarDrawerToggle as listener of the drawer layout
        // TODO 09.03. We have to synchronize the drawer with the toolbar
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
