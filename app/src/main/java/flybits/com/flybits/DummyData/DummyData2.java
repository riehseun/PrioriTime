package flybits.com.flybits.DummyData;

import java.util.ArrayList;
import java.util.List;

import flybits.com.flybits.model.Event;
import flybits.com.flybits.model.FBFriend;

/**
 * Created by larrychong on 16-04-09.
 */
public class DummyData2 {
    public static ArrayList<Event> getDummyData(){
        ArrayList<Event> events  = new ArrayList<>();

        Event event1 = new Event();
        event1.setName("shit");
        events.add(event1);

        Event event2 = new Event();
        event1.setName("mofo");
        events.add(event2);

        Event event3 = new Event();
        event1.setName("fml");
        events.add(event3);

        return events;
    }
}
