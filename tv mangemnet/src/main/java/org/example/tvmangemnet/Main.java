package org.example.tvmangemnet;

import javafx.beans.property.SimpleStringProperty;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main extends Application {

    // UI Components
    private TextField firstNameField, lastNameField, mobileField, cityField, startCycleField, endCycleField, numberOfTVField;
    private TextArea channelAreaS, channelAreaM, channelAreaD;
    private CheckBox sportsCheckBox, moviesCheckBox, docCheckBox;
    private Label instalFeeLabel, packageFeeLabel, totalFeeLabel;
    private TableView<Subscription> subscriptionTable;

    private List<TVChannel> sportsChannels, movieChannels, docChannels;
    private List<Subscription> subscriptions = new ArrayList<>();
    private double installationFee = 50;  // Example installation fee
    private double totalPackageFee = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize Channels
        initializeChannels();

        // Subscriber Panel
        GridPane subscriberPanel = createSubscriberPanel();

        // Cycle Panel
        GridPane cyclePanel = createCyclePanel();

        // Channel Packages Panel
        VBox channelPackagePanel = createChannelPackagePanel();

        // Available Channels Panel
        VBox availableChannelsPanel = createAvailableChannelsPanel();

        // Fees and Payment Panel
        VBox feePanel = createFeePanel();

        // Action Panel
        HBox actionPanel = createActionPanel();

        // Subscription Table Panel
        VBox subscriptionTablePanel = createSubscriptionTablePanel();

        // Main Layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setLeft(new VBox(subscriberPanel, cyclePanel));
        mainLayout.setCenter(new VBox(channelPackagePanel, availableChannelsPanel));
        mainLayout.setRight(new VBox(feePanel, actionPanel));
        mainLayout.setBottom(subscriptionTablePanel);

        // Scene
        Scene scene = new Scene(mainLayout, 1200, 800);
        primaryStage.setTitle("TV Subscription Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeChannels() {
        sportsChannels = List.of(
                new SportsChannel("ESPN", "USA", "English", 10),
                new SportsChannel("Star Sports", "India", "Hindi", 8),
                new SportsChannel("Sky Sports", "UK", "English", 12)
        );

        movieChannels = List.of(
                new MovieChannel("HBO", "USA", "English", 15),
                new MovieChannel("Star Movies", "India", "English", 10),
                new MovieChannel("Cinemax", "USA", "English", 12)
        );

        docChannels = List.of(
                new DocumentaryChannel("Discovery", "USA", "English", 10),
                new DocumentaryChannel("Nat Geo", "USA", "English", 10),
                new DocumentaryChannel("History", "USA", "English", 10)
        );
    }

    private GridPane createSubscriberPanel() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));

        Label nameLabel = new Label("First Name:");
        firstNameField = new TextField();
        Label lastNameLabel = new Label("Last Name:");
        lastNameField = new TextField();
        Label mobileLabel = new Label("Mobile:");
        mobileField = new TextField();
        Label cityLabel = new Label("City:");
        cityField = new TextField();

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(firstNameField, 1, 0);
        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameField, 1, 1);
        gridPane.add(mobileLabel, 0, 2);
        gridPane.add(mobileField, 1, 2);
        gridPane.add(cityLabel, 0, 3);
        gridPane.add(cityField, 1, 3);

        return gridPane;
    }

    private GridPane createCyclePanel() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));

        Label startCycleLabel = new Label("Start Cycle Date (DD/MM/YYYY):");
        startCycleField = new TextField();
        Label endCycleLabel = new Label("End Cycle Date (DD/MM/YYYY):");
        endCycleField = new TextField();
        Label numberOfTVLabel = new Label("Number of TVs:");
        numberOfTVField = new TextField();

        gridPane.add(startCycleLabel, 0, 0);
        gridPane.add(startCycleField, 1, 0);
        gridPane.add(endCycleLabel, 0, 1);
        gridPane.add(endCycleField, 1, 1);
        gridPane.add(numberOfTVLabel, 0, 2);
        gridPane.add(numberOfTVField, 1, 2);

        return gridPane;
    }

    private VBox createChannelPackagePanel() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));

        Label packageLabel = new Label("Select Packages:");
        sportsCheckBox = new CheckBox("Sports");
        moviesCheckBox = new CheckBox("Movies");
        docCheckBox = new CheckBox("Documentary");

        vBox.getChildren().addAll(packageLabel, sportsCheckBox, moviesCheckBox, docCheckBox);

        return vBox;
    }

    private VBox createAvailableChannelsPanel() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));

        Label availableChannelsLabel = new Label("Available Channels:");

        // Sports Channels
        Label sportsChannelsLabel = new Label("Sports Channels:");
        channelAreaS = new TextArea();
        channelAreaS.setEditable(false);
        channelAreaS.setPrefHeight(100);
        sportsChannels.forEach(channel -> channelAreaS.appendText(channel.getChannelName() + "\n"));

        // Movie Channels
        Label movieChannelsLabel = new Label("Movie Channels:");
        channelAreaM = new TextArea();
        channelAreaM.setEditable(false);
        channelAreaM.setPrefHeight(100);
        movieChannels.forEach(channel -> channelAreaM.appendText(channel.getChannelName() + "\n"));

        // Documentary Channels
        Label docChannelsLabel = new Label("Documentary Channels:");
        channelAreaD = new TextArea();
        channelAreaD.setEditable(false);
        channelAreaD.setPrefHeight(100);
        docChannels.forEach(channel -> channelAreaD.appendText(channel.getChannelName() + "\n"));

        vBox.getChildren().addAll(availableChannelsLabel, sportsChannelsLabel, channelAreaS, movieChannelsLabel, channelAreaM, docChannelsLabel, channelAreaD);

        return vBox;
    }

    private VBox createFeePanel() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));

        Label feeLabel = new Label("Fees:");

        instalFeeLabel = new Label("Installation Fee: $" + installationFee);
        packageFeeLabel = new Label("Total Package Fee: $" + totalPackageFee);
        totalFeeLabel = new Label("Total Fee: $" + (installationFee + totalPackageFee));

        vBox.getChildren().addAll(feeLabel, instalFeeLabel, packageFeeLabel, totalFeeLabel);

        return vBox;
    }

    private HBox createActionPanel() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));

        Button calculateFeeButton = new Button("Calculate Fee");
        calculateFeeButton.setOnAction(e -> calculateTotalFee());

        Button saveSubscriptionButton = new Button("Save Subscription");
        saveSubscriptionButton.setOnAction(e -> saveSubscription());

        Button viewSubscriptionsButton = new Button("View Subscriptions");
        viewSubscriptionsButton.setOnAction(e -> viewSubscriptions());

        hBox.getChildren().addAll(calculateFeeButton, saveSubscriptionButton, viewSubscriptionsButton);

        return hBox;
    }

    private VBox createSubscriptionTablePanel() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));

        Label subscriptionLabel = new Label("Subscriptions:");

        subscriptionTable = new TableView<>();
        // Initialize table columns
        TableColumn<Subscription, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSubscriber().getFirstName() + " " + cellData.getValue().getSubscriber().getLastName()));

        TableColumn<Subscription, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate()));

        TableColumn<Subscription, String> cycleColumn = new TableColumn<>("Subscription Cycle");
        cycleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCycle().getStartDate() + " - " + cellData.getValue().getCycle().getEndDate()));

        TableColumn<Subscription, String> tvCountColumn = new TableColumn<>("No. of TVs");
        tvCountColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumberOfTVs())));

        TableColumn<Subscription, String> feeColumn = new TableColumn<>("Total Fee");
        feeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTotalFee())));

        subscriptionTable.getColumns().addAll(nameColumn, dateColumn, cycleColumn, tvCountColumn, feeColumn);

        vBox.getChildren().addAll(subscriptionLabel, subscriptionTable);

        return vBox;
    }

    private void calculateTotalFee() {
        totalPackageFee = 0;
        if (sportsCheckBox.isSelected()) {
            for (TVChannel channel : sportsChannels) {
                totalPackageFee += channel.getPrice();
            }
        }
        if (moviesCheckBox.isSelected()) {
            for (TVChannel channel : movieChannels) {
                totalPackageFee += channel.getPrice();
            }
        }
        if (docCheckBox.isSelected()) {
            for (TVChannel channel : docChannels) {
                totalPackageFee += channel.getPrice();
            }
        }

        instalFeeLabel.setText("Installation Fee: $" + installationFee);
        packageFeeLabel.setText("Total Package Fee: $" + totalPackageFee);
        totalFeeLabel.setText("Total Fee: $" + (installationFee + totalPackageFee));
    }

    private void saveSubscription() {
        try {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String mobile = mobileField.getText();
            String city = cityField.getText();
            Subscriber subscriber = new Subscriber(firstName, lastName, mobile, city);

            String startDate = startCycleField.getText();
            String endDate = endCycleField.getText();
            SubscriptionCycle cycle = new SubscriptionCycle(startDate, endDate);

            int numberOfTVs = Integer.parseInt(numberOfTVField.getText());
            double totalFee = installationFee + totalPackageFee;

            String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

            Subscription subscription = new Subscription(subscriber, cycle, numberOfTVs, date, totalFee);
            subscriptions.add(subscription);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("subscriptions.ser"))) {
                oos.writeObject(subscriptions);
            }

            subscriptionTable.getItems().add(subscription);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewSubscriptions() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("subscriptions.ser"))) {
            subscriptions = (List<Subscription>) ois.readObject();
            subscriptionTable.getItems().clear();
            subscriptionTable.getItems().addAll(subscriptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
