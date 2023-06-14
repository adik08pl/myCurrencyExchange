package com.stempien.mycurrencyexchange;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {


    public Label lblDolarCourse;
    public Label lblEuroCourse;
    public Label lblJenCourse;
    public Label lblFrankCourse;

    @FXML
    protected void initialize() {
        ApiHelper apiHelper = new ApiHelper();
        lblDolarCourse.setText(String.format("%.2f",apiHelper.getCourseInfo("usd")));
        lblEuroCourse.setText(String.format("%.2f",apiHelper.getCourseInfo("eur")));
        lblJenCourse.setText(String.format("%.2f",apiHelper.getCourseInfo("jpy")));
        lblFrankCourse.setText(String.format("%.2f",apiHelper.getCourseInfo("chf")));
    }
}