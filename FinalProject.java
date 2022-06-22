// This program implements an investment value calculator using Java FX. The program calculates the future value of an
// investment at a given interest rate for a specified number of years. The user will enter the initial investment
// amount (in dollars), an annual interest rate (e.g. 3.5 corresponds to 3.5%), and the number of years associated with
// the investment. When the user clicks on the calculate button, the program calculates and displays the future value
// of the investment.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinalProject extends Application {
    // The labels for the investment amount, number of years, annual interest rate, and future value are created.
    private final Label investmentAmountLabel = new Label("Investment Amount:");
    private final Label numYearsLabel = new Label("Number of Years:");
    private final Label annualInterestRateLabel = new Label("Annual Interest Rate:");
    private final Label futureValueLabel = new Label("Future Value:");

    // The text fields for the investment amount, number of years, annual interest rate, and future value are created.
    private final TextField investmentAmountTextField = new TextField();
    private final TextField numYearsTextField = new TextField();
    private final TextField annualInterestRateTextField = new TextField();
    private final TextField futureValueTextField = new TextField();

    // The button that will calculate the future value is created.
    private final Button calculateButton = new Button("Calculate");

    protected BorderPane getPane() {
        // A VBox is created to hold the labels. The VBox places all nodes (components attached to the scene, in this
        // case labels) vertically in one column.
        VBox labelsVBox = new VBox(20);

        // Sets the inside offsets for the four sides of rectangular area.
        labelsVBox.setPadding(new Insets(50, 50, 10, 50));

        // Sets the spacing between each child in the VBox.
        labelsVBox.setSpacing(30);

        // The labels are placed in the VBox using the method getChildren(), which returns the list of nodes in the
        // pane.
        labelsVBox.getChildren().addAll(investmentAmountLabel, numYearsLabel, annualInterestRateLabel, futureValueLabel);

        // A VBox is created to hold the text fields. The VBox places all nodes (components attached to the scene, in
        // this case text fields) vertically in one column.
        VBox textFieldsVBox = new VBox(20);

        // Sets the inside offsets for the four sides of rectangular area.
        textFieldsVBox.setPadding(new Insets(50, 20, 10, 20));

        // The text fields and the calculate button are placed in the VBox using the method getChildren(), which returns
        // the list of nodes in the pane.
        textFieldsVBox.getChildren().addAll(investmentAmountTextField, numYearsTextField, annualInterestRateTextField,
            futureValueTextField, calculateButton);

        // The user won't be allowed to type in the future value text field since it will display the overall future
        // value.
        futureValueTextField.setEditable(false);

        // An action handler for the calculate button is created. A lambda expression is used for simplification
        // purposes.
        calculateButton.setOnAction(e -> calculateFuturePayment());

        // A border pane is created to lay out the children from both VBoxes.
        BorderPane pane = new BorderPane();

        // The labels are added to the left of the pane.
        pane.setLeft(labelsVBox);

        // The text fields are added to the center of the pane.
        pane.setCenter(textFieldsVBox);
        return pane;
    }

    // The calculateFuturePayment() method handles the calculation of the future value.
    private void calculateFuturePayment() {
        // Gets and initializes the investment amount, number of year, and annual interest rate from the text fields.
        int investmentAmount = Integer.parseInt(investmentAmountTextField.getText());
        int numYears = Integer.parseInt(numYearsTextField.getText());
        double annualInterestRate = Double.parseDouble(annualInterestRateTextField.getText());

        // The futureValue object is instantiated and passes in the investment amount, number of years, and annual
        // interest rate.
        FutureValue futureValue = new FutureValue(investmentAmount, numYears, annualInterestRate);

        // Calls the getFutureValue() and displays the future value in its respective text field.
        futureValueTextField.setText(String.format("$%.2f", futureValue.getFutureValue()));
    }

    // Override the start method in the Application class.
    @Override
    public void start(Stage primaryStage) {
        // The scene is created and it is placed in the stage.
        Scene scene = new Scene(getPane(), 500, 300);

        // The stage is titled is set to "Future Value Calculator".
        primaryStage.setTitle("Future Value Calculator");

        // The scene is placed in the stage.
        primaryStage.setScene(scene);

        // The stage is displayed.
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}