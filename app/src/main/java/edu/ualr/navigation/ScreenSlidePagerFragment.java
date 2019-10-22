package edu.ualr.navigation;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by irconde on 2019-10-21.
 */
// TODO 03. Create the fragment shown as page: ScreenSlidePageFragment
// Now we can create instances of this fragment in the parent activity whenever you need a new page to display to the user
public class ScreenSlidePagerFragment extends Fragment {

    private static final String DRAWABLE_RES = "drawableRes";
    private int mDrawableRes;

    public static ScreenSlidePagerFragment newInstance(int drawableResIndex) {
        Bundle args = new Bundle();
        args.putInt(DRAWABLE_RES, drawableResIndex);
        ScreenSlidePagerFragment fragment = new ScreenSlidePagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mDrawableRes = args.getInt(DRAWABLE_RES);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        setImageViewSrc((ImageView) view.findViewById(R.id.screen_image), mDrawableRes);
        return view;
    }

    private void setImageViewSrc(ImageView imageView, int index) {
        TypedArray imageTypedArray = getResources().obtainTypedArray(R.array.images);
        int imageResId = imageTypedArray.getResourceId(index, -1);
        if (imageResId != -1) {
            imageView.setImageResource(imageResId);
        }
    }
}
