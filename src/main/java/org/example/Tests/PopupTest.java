package org.example.Tests;

import org.example.Page.Popup;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PopupTest {

    Popup popup = new Popup();

    @Test (groups = {"allPopupTest" , "alert"}, retryAnalyzer = RertyTests.class)
    public void alert() {
        popup.alert();
    }

    @Test (groups = {"allPopupTest", "confirm"}, retryAnalyzer = RertyTests.class)
    public void confirm() {
        popup.confirm();
    }

    @Parameters ({"name"})
    @Test (groups = {"allPopupTest", "prompt"}, retryAnalyzer = RertyTests.class)
    public void prompt(String name) {
        popup.prompt(name);
    }

    @Test (groups = {"allPopupTest", "tooltip"}, retryAnalyzer = RertyTests.class)
    public void tooltip() {
        popup.tooltip();
    }


}

