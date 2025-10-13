package org.example.Tests;

import org.example.Page.Event;
import org.testng.annotations.Test;

public class EventTest {

    Event event = new Event();

    @Test (groups = {"allEventTest"})
    public void catButton() {
        event.catButtonClick();
    }
    @Test (groups = {"allEventTest"})
    public void dogButton() {
        event.dogButtonClick();
    }
    @Test (groups = {"allEventTest"})
    public void pigButton() {
        event.pigButtonClick();
    }
    @Test (groups = {"allEventTest"})
    public void cowButton() {
        event.cowButtonClick();
    }
}
