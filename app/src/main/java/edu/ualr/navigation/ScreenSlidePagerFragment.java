package edu.ualr.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by irconde on 2019-10-21.
 */
// TODO 03. Create the fragment shown as page: ScreenSlidePageFragment
// Now we can create instances of this fragment in the parent activity whenever you need a new page to display to the user
public class ScreenSlidePagerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
    }
}
