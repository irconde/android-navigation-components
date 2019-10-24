package edu.ualr.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager = findViewById(R.id.pager);
        // TODO 05. We create an instance of the new Adapter class. We plug in the data set used to populate the pager of the view pager
        SimpleAdapter pageAdapter = new SimpleAdapter(generateDummyDataset());
        // TODO 06. We associate the adapter with the view pager
        viewPager.setAdapter(pageAdapter);
    }

    // TODO 03. Generate the data set to be used to populate the view pager
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
