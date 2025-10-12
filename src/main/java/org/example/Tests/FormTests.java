package org.example.Tests;

import org.example.Page.Form;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FormTests {

    Form form = new Form();

    @Parameters ({"name", "password"})
    @Test (groups = {"allFormTest"})
    public void login(String name, String password) {
        form.login(name, password);
    }

    @Parameters ({"checkBoxOption"})
    @Test (groups = {"allFormTest"})
    public void checkBox(String checkBoxOption) {
        form.checkbox(checkBoxOption);
    }

    @Parameters ({"radioBoxOption"})
    @Test (groups = {"allFormTest"})
    public void radio(String radioBoxOption) {
        form.radio(radioBoxOption);
    }

    @Parameters ({"select"})
    @Test (groups = {"allFormTest"})
    public void select(String select) {
        form.select(select);
    }
}
