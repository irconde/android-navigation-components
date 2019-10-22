package edu.ualr.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

// TODO 02. Create the layout file that we'll later use for the content of the fragment: fragment_screen_slide_page.xml
// TODO 03. Create the fragment shown as page: ScreenSlidePageFragment
public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 5;

    // TODO 04. Define a ViewPager2 member.
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager2 viewPager;
    //TODO 5. Define a FragmentStateAdapter member
    private FragmentStateAdapter pageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO 08. Instantiate a ViewPager2 and a PageAdapter
        viewPager = findViewById(R.id.pager);
        pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
    }
    // TODO 06. Create a class that extends the FragmentStateAdapter abstract class
    // TODO 07. In the FragmentStateAdapter child class implement
    //  the createFragment() method to supply instances of the ScreenSlidePageFragment as new pages
    //  the getItemCount() method that returns the number of pages the adapter will create.

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return ScreenSlidePagerFragment.newInstance(position);
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}
