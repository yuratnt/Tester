package org.example.Tests;

import org.example.Page.Form;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FormTest {

    Form form = new Form();

    @Parameters ({"name", "password"})
    @Test (groups = {"allFormTest"}, priority=1)
    public void login(String name, String password) {
        form.login(name, password);
    }

    @Parameters ({"checkBoxOption"})
    @Test (groups = {"allFormTest"}, priority=2)
    public void checkBox(String checkBoxOption) {
        form.checkbox(checkBoxOption);
    }

    @Parameters ({"radioBoxOption"})
    @Test (groups = {"allFormTest"}, priority=3)
    public void radio(String radioBoxOption) {
        form.radio(radioBoxOption);
    }

    @Parameters ({"select"})
    @Test (groups = {"allFormTest"}, priority=4)
    public void select(String select) {
        form.select(select);
    }

    @Parameters ({"email"})
    @Test (groups = {"allFormTest"}, priority=5)
    public void email(String email) {
        form.email(email);
    }

    @Parameters ({"message"})
    @Test (groups = {"allFormTest"}, priority=6)
    public void message(String message) {
        form.message(message);
    }

    @Test (groups = {"allFormTest"}, priority=7)
    public void submit() {
        form.submit();
    }

    @Test (groups = {"allFormTest"}, priority=8)
    public void alert() {
        form.alert();
    }
}

