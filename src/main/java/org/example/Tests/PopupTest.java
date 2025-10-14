package org.example.Tests;

import org.example.Page.Popup;
import org.testng.annotations.Test;

public class PopupTest {

    Popup popup = new Popup();

    @Test (groups = {"allPopupTest"})
    public void alert() {
        popup.alert();
    }

}
