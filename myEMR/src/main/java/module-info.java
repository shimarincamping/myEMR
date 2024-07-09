module com.myemr.myemr {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.myemr.myemr to javafx.fxml;
    exports com.myemr.myemr;
}