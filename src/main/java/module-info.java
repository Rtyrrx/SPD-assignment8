module com.madias.visitor.visitor {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.madias.visitor.visitor to javafx.fxml;

    exports com.madias.visitor.visitor;
}