package flybits.com.flybits.DummyData;

import java.util.ArrayList;
import java.util.List;

import flybits.com.flybits.model.FBFriend;

/**
 * Created by larrychong on 16-04-09.
 */
public class DummyData {
    public static ArrayList<FBFriend> getDummyData(){
        ArrayList<FBFriend> contacts  = new ArrayList<FBFriend>();

        FBFriend friend1 = new FBFriend();
        friend1.setProfileUrl("https://randomuser.me/api/portraits/med/men/87.jpg");
        friend1.setAmountTimeSpent(2);
        friend1.setProfileName("Michael Todd");
        contacts.add(friend1);

        FBFriend friend2 = new FBFriend();
        friend2.setProfileUrl("https://randomuser.me/api/portraits/med/men/80.jpg");
        friend2.setAmountTimeSpent(2);
        friend2.setProfileName("Mathew Delly");
        contacts.add(friend2);

        FBFriend friend3 = new FBFriend();
        friend3.setProfileUrl("https://randomuser.me/api/portraits/med/women/81.jpg");
        friend3.setAmountTimeSpent(2);
        friend3.setProfileName("Ashley Madison");
        contacts.add(friend3);

        FBFriend friend4 = new FBFriend();
        friend4.setProfileUrl("https://randomuser.me/api/portraits/med/women/82.jpg");
        friend4.setAmountTimeSpent(2);
        friend4.setProfileName("Kate Bloom");
        contacts.add(friend4);

        FBFriend friend5 = new FBFriend();
        friend5.setProfileUrl("https://randomuser.me/api/portraits/med/men/83.jpg");
        friend5.setAmountTimeSpent(2);
        friend5.setProfileName("Todd Bean");
        contacts.add(friend5);

        FBFriend friend6 = new FBFriend();
        friend6.setProfileUrl("https://randomuser.me/api/portraits/med/women/84.jpg");
        friend6.setAmountTimeSpent(2);
        friend6.setProfileName("Jane Doe");
        contacts.add(friend6);

        FBFriend friend7 = new FBFriend();
        friend7.setProfileUrl("https://randomuser.me/api/portraits/med/men/85.jpg");
        friend7.setAmountTimeSpent(2);
        friend7.setProfileName("Bat man");
        contacts.add(friend7);

        FBFriend friend8 = new FBFriend();
        friend8.setProfileUrl("https://randomuser.me/api/portraits/med/men/86.jpg");
        friend8.setAmountTimeSpent(2);
        friend8.setProfileName("Tom Bradley");
        contacts.add(friend8);

        return contacts;
    }
}
