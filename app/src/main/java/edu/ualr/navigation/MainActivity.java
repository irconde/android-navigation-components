package edu.ualr.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager = findViewById(R.id.pager);
        SimpleAdapter pageAdapter = new SimpleAdapter(generateDummyDataset());
        viewPager.setAdapter(pageAdapter);
        // TODO 02. We can listen for events from the view pager using the OnPageChangeCallback interface
        // NOTE: It's not mandatory to override all the methods of the interface
            // TODO 03. Callback interface for responding to changing state of the selected page.
            /**
             * This method will be invoked when the current page is scrolled, either as part of a
             * programmatically initiated smooth scroll or a user initiated touch scroll.
             */
            // TODO 04. Method invoked when a new page becomes selected
            // TODO 05. Method invoked when the scroll state changes.
            /**
             *  1-> SCROLL_STATE_DRAGGING. Indicates that the pager is currently being dragged by the user.
             *  0-> SCROLL_STATE_IDLE. Indicates that the pager is in an idle, settled state.
             *      The current page is fully in view and no animation is in progress.
             *  2-> SCROLL_STATE_SETTLING. Indicates that the pager is in the process of settling to a final position
             */
    }

    private List<Contact> generateDummyDataset() {
        List<Contact> contacts = new ArrayList<>();
        Contact firstContact = new Contact();
        firstContact.setFirstName("Ivan");
        firstContact.setLastName("Rodriguez-Conde");
        firstContact.setAddress("C/ Xoan Manuel Pintos 6, 6D Ourense");
        firstContact.setPhoneNumber("+34 647858682");
        firstContact.setWebsite("http://www.sketcharm.com");
        firstContact.setEmailAddress("irconde@ualr.edu");
        contacts.add(firstContact);
        Contact secondContact = new Contact();
        secondContact.setFirstName("Elvira");
        secondContact.setLastName("Losada-Sanchez");
        secondContact.setAddress("C/ Xoan Manuel Pintos 6, 6D Ourense");
        secondContact.setPhoneNumber("+34 865786345");
        secondContact.setWebsite("http://www.elviralosada.com");
        secondContact.setEmailAddress("elvira.losada@gmail.com");
        contacts.add(secondContact);
        return contacts;
    }

}
