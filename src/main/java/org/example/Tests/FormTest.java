package org.example.Tests;

import org.example.Page.Form;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FormTest {

    Form form = new Form();

    @Parameters ({"name"})
    @Test (groups = {"allFormTest", "name"}, priority=1, retryAnalyzer = RertyTests.class)
    public void username(String name) {
        form.username(name);
    }

    @Parameters ({"password"})
    @Test (groups = {"allFormTest", "password"}, priority=2, retryAnalyzer = RertyTests.class)
    public void password(String password) {
        form.password(password);
    }

    @Parameters ({"checkBoxOption"})
    @Test (groups = {"allFormTest", "checkBox"}, priority=3, retryAnalyzer = RertyTests.class)
    public void checkBox(String checkBoxOption) {
        form.checkbox(checkBoxOption);
    }

    @Parameters ({"radioBoxOption"})
    @Test (groups = {"allFormTest", "radioBox"}, priority=4, retryAnalyzer = RertyTests.class)
    public void radio(String radioBoxOption) {
        form.radio(radioBoxOption);
    }

    @Parameters ({"select"})
    @Test (groups = {"allFormTest", "select"}, priority=5, retryAnalyzer = RertyTests.class)
    public void select(String select) {
        form.select(select);
    }

    @Parameters ({"email"})
    @Test (groups = {"allFormTest", "email"}, priority=6, retryAnalyzer = RertyTests.class)
    public void email(String email) {
        form.email(email);
    }

    @Parameters ({"message"})
    @Test (groups = {"allFormTest", "message"}, priority=7, retryAnalyzer = RertyTests.class)
    public void message(String message) {
        form.message(message);
    }

    @Parameters ({"submit"})
    @Test (groups = {"allFormTest", "submit"}, priority=8, retryAnalyzer = RertyTests.class)
    public void submit(boolean submit) {
        form.submit(submit);
    }

    @Test (groups = {"allFormTest", "alert"}, priority=9, retryAnalyzer = RertyTests.class)
    public void alert() {
        form.alert();
    }
}

