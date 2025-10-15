package org.example.Tests;

import org.example.Page.Event;
import org.testng.annotations.Test;

public class EventTest {

    Event event = new Event();

    @Test (groups = {"allEventTest", "catButton"}, retryAnalyzer = RertyTests.class)
    public void catButton() {
        event.catButtonClick();
    }
    @Test (groups = {"allEventTest", "dogButton"}, retryAnalyzer = RertyTests.class)
    public void dogButton() {
        event.dogButtonClick();
    }
    @Test (groups = {"allEventTest", "pigButton"}, retryAnalyzer = RertyTests.class)
    public void pigButton() {
        event.pigButtonClick();
    }
    @Test (groups = {"allEventTest", "cowButton"}, retryAnalyzer = RertyTests.class)
    public void cowButton() {
        event.cowButtonClick();
    }
}
