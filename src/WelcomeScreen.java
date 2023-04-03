import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WelcomeScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label for the opening message
        Label welcomeLabel = new Label("CODE MODE");
        welcomeLabel.setFont(Font.font("STENCIL", 68));
        welcomeLabel.setTextFill(Color.DARKBLUE);

        // Start button
        Button startButton = new Button("START!");
        startButton.setOnAction(event -> showNextScreen(primaryStage));
        startButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 27px; -fx-text-fill: slateblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
        // directions button
        Button directionsButton = new Button("directions");
        directionsButton.setOnAction(event -> showDirectionsScreen(primaryStage));
        directionsButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 22px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
        
        // vbox to show welcomelabel and startbutton
        VBox welcomeBox = new VBox(welcomeLabel, startButton, directionsButton);
        VBox.setMargin(welcomeLabel, new Insets(10, 0, 0, 0));
        welcomeBox.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(startButton, new Insets(25, 0, 20, 0));
        VBox.setMargin(directionsButton, new Insets(20, 0, 20, 0));
        welcomeBox.setAlignment(Pos.CENTER);

        //adding a picture
        Image image = new Image("file:C:/Users/miran/Pictures/bing/bingus.png");
        // make the image in the scene
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(300);
        imageView.setLayoutY(100);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        // adding image to vbox
        welcomeBox.getChildren().add(imageView);

        // holds vbox
        BorderPane root = new BorderPane();
        root.setCenter(welcomeBox);
        BorderPane.setMargin(welcomeBox, new Insets(50));

        // create tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        private void showWelcomeScreen(Stage primaryStage) {
            WelcomeScreen welcomeScreen = new WelcomeScreen();
            welcomeScreen.start(primaryStage);
        }

     // directions screen
    private void showDirectionsScreen(Stage primaryStage) {
        Label directionsScreenLabel = new Label("Directions");
        directionsScreenLabel.setFont(Font.font("Elephant", 46));
        directionsScreenLabel.setTextFill(Color.DARKBLUE);

          // back button
    Button backButton = new Button("Back");
    backButton.setOnAction(event -> showWelcomeScreen(primaryStage));
    backButton.setStyle("-fx-font-size: 25px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

    // text for a paragraph
        Text directionsText = new Text("This app is designed to teach you the coding language JavaScript in a simple and easy to follow learning environment. "
        + ""
        + "This app has three sections." + " Section 1 is multiple choice" + " Section 2 is fill in the blank" + " Section 3 is create your own."
        + ""
        + ""
        + " Enjoy!");
        directionsText.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        directionsText.setWrappingWidth(480); // set the maximum width for the text
        directionsText.setTextAlignment(TextAlignment.JUSTIFY); // set the alignment of the text

        // vbox
        VBox directionsBox = new VBox(50, directionsScreenLabel, directionsText, backButton);
        directionsBox.setAlignment(Pos.CENTER);

        BorderPane directionsRoot = new BorderPane();
        directionsRoot.setCenter(directionsBox);
        BorderPane.setMargin(directionsBox, new Insets(50));

        Scene directionsScene = new Scene(directionsRoot, 600, 400);
        primaryStage.setScene(directionsScene);
    }

    private void showNextScreen(Stage primaryStage) {
        // Create a label for the next screen
        Label nextScreenLabel = new Label("Choose a section");
        nextScreenLabel.setFont(Font.font("STENCIL", 55));
        nextScreenLabel.setTextFill(Color.DARKBLUE);



        //back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showWelcomeScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        //button for section 1
        Button firstButton = new Button("Section 1");
        firstButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 23px; -fx-text-fill: slateblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
        firstButton.setOnAction(event -> showFirstScreen(primaryStage));

        //button for section 2
        Button secondButton = new Button("Section 2");
        secondButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 23px; -fx-text-fill: slateblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
        secondButton.setOnAction(event -> showSecondScreen(primaryStage));

        //button for section 3
        Button thirdButton = new Button("Section 3");
        thirdButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 23px; -fx-text-fill: slateblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
        thirdButton.setOnAction(event -> showThirdScreen(primaryStage));

        //spacing of buttons
        HBox buttonsBox = new HBox(40, firstButton, secondButton, thirdButton);
        buttonsBox.setAlignment(Pos.TOP_CENTER);

        //spacing of title
        VBox nextScreenBox = new VBox(80, nextScreenLabel, buttonsBox, backButton);
        nextScreenBox.setAlignment(Pos.CENTER);   

        // Create a border pane to hold the next screen VBox
        BorderPane root = new BorderPane();
        root.setCenter(nextScreenBox);
        BorderPane.setMargin(nextScreenBox, new Insets(50));

        // Set the scene and show the stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //first section (multiple choice) screen after clicking button
    private void showFirstScreen(Stage primaryStage) {
        // Create a label for the first screen
        Label firstScreenLabel = new Label("Multiple Choice");
        firstScreenLabel.setFont(Font.font("STENCIL", 50));
        firstScreenLabel.setAlignment(Pos.TOP_CENTER);
        firstScreenLabel.setTextFill(Color.DARKBLUE);
    
        // label for choose level text
        Label chooseLevelLabel = new Label("Choose A Level of Difficulty");
        chooseLevelLabel.setStyle("-fx-font-family: Elephant; -fx-font-size: 30px; -fx-font-style: normal; -fx-font-weight: bold; -fx-text-fill: slateblue;");
        chooseLevelLabel.setLayoutX(100);
        chooseLevelLabel.setLayoutY(300);
    
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showNextScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        //button for level 1
        Button level1Button = new Button("Level 1");
        level1Button.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: mediumseagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        level1Button.setOnAction(event -> showS1L1Screen(primaryStage));
        // button for level 2
        Button level2Button = new Button("Level 2");
        level2Button.setStyle("-fx-font-family: Elephant;-fx-font-size: 24px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        level2Button.setOnAction(event -> showS1L2Screen(primaryStage));
        //button for level 3
        Button level3Button = new Button("Level 3");
        level3Button.setStyle("-fx-font-family: Elephant;-fx-font-size: 24px; -fx-text-fill: crimson; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        level3Button.setOnAction(event -> showS1L3Screen(primaryStage));

        // vbox for labels and back button
        VBox firstScreenBox = new VBox(40, firstScreenLabel, chooseLevelLabel, backButton);
        firstScreenBox.setAlignment(Pos.TOP_CENTER);
        
        // hbox for level buttons
        HBox buttonBox = new HBox(20, level1Button, level2Button, level3Button);
        
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        // Add the HBox to the VBox
        firstScreenBox.getChildren().add(1, buttonBox);
    
        // border pane to hold the VBox
        BorderPane root = new BorderPane();
        root.setCenter(firstScreenBox);
        BorderPane.setMargin(firstScreenBox, new Insets(50));
    
        // create tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //second section screen (fill in the blank) after clicking button
    private void showSecondScreen(Stage primaryStage) {
        //label for the second screen
        Label secondScreenLabel = new Label("Fill In The Blank");
        secondScreenLabel.setFont(Font.font("STENCIL", 50));
        secondScreenLabel.setTextFill(Color.DARKBLUE);
    
        // label for choose level text
        Label chooseLevelLabel = new Label("Choose A Level of Difficulty");
        chooseLevelLabel.setStyle("-fx-font-family: Elephant; -fx-font-size: 30px; -fx-text-fill: slateblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;");
        chooseLevelLabel.setLayoutX(100);
        chooseLevelLabel.setLayoutY(300);
    
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showNextScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        //button for level 1
        Button level1 = new Button("Level 1");
        level1.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: mediumseagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        // button for level 2
        Button level2 = new Button("Level 2");
        level2.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        //button for level 3
        Button level3 = new Button("Level 3");
        level3.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: crimson; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        // vbox for labels and back button
        VBox secondScreenBox = new VBox(40, secondScreenLabel, chooseLevelLabel, backButton);
        secondScreenBox.setAlignment(Pos.TOP_CENTER);
        
        // hbox for level buttons
        HBox buttonBox = new HBox(20, level1, level2, level3);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        // Add the HBox to the VBox
        secondScreenBox.getChildren().add(1, buttonBox);
    
        // border pane to hold the VBox
        BorderPane root = new BorderPane();
        root.setCenter(secondScreenBox);
        BorderPane.setMargin(secondScreenBox, new Insets(50));
    
        // create tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //third level screen (create your own) after clicking button
    private void showThirdScreen(Stage primaryStage) {
        // label for the third screen
        Label thirdScreenLabel = new Label("Create Your Own");
        thirdScreenLabel.setFont(Font.font("STENCIL", 50));
        thirdScreenLabel.setTextFill(Color.DARKBLUE);
    
        // label for choose level text
        Label chooseLevelLabel = new Label("Choose A Level of Difficulty");
        chooseLevelLabel.setStyle("-fx-font-family: Elephant; -fx-font-size: 30px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;");
        chooseLevelLabel.setLayoutX(100);
        chooseLevelLabel.setLayoutY(300);
    
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showNextScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        //button for level 1
        Button level1Button = new Button();
        level1Button.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: mediumseagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        
        // button for level 2
        Button level2 = new Button("Level 2");
        level2.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        //button for level 3
        Button level3 = new Button("Level 3");
        level3.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: crimson; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        // vbox for labels and back button
        VBox thirdScreenBox = new VBox(40, thirdScreenLabel, chooseLevelLabel, backButton);
        thirdScreenBox.setAlignment(Pos.TOP_CENTER);
        
        // hbox for level buttons
        HBox buttonBox = new HBox(20, level1Button, level2, level3);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        // Add the HBox to the VBox
        thirdScreenBox.getChildren().add(1, buttonBox);
    
        // border pane to hold the VBox
        BorderPane root = new BorderPane();
        root.setCenter(thirdScreenBox);
        BorderPane.setMargin(thirdScreenBox, new Insets(50));
    
        // create tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();   
    }



    // actual code




    // multiple choice  
    private Button[] answerButtons;
    
    private void showS1L1Screen(Stage primaryStage) {
        // Create a label for the first screen
        Label S1L1ScreenLabel = new Label("Question 1");
        S1L1ScreenLabel.setFont(Font.font("STENCIL", 30));
        S1L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L1ScreenLabel.setTextFill(Color.DARKBLUE);
    
        // Create a label for displaying the result of the answer
        Label questionLabel = new Label("this is the question");
        questionLabel.setAlignment(Pos.TOP_CENTER);
        questionLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 10px;");
    
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showFirstScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
    
        // answer buttons
        answerButtons = new Button[3];
        answerButtons[0] = new Button("New York");
        answerButtons[1] = new Button("Paris");
        answerButtons[2] = new Button("Tokyo");
    
        // set button styles
        for (Button button : answerButtons) {
            button.setStyle("-fx-background-color: white; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
            button.setOnAction(this::handleAnswerButton);
        }
    
        // vbox for labels, answer buttons, and back button
        VBox S1L1ScreenBox = new VBox(40, S1L1ScreenLabel, questionLabel, backButton);
        S1L1ScreenBox.setAlignment(Pos.TOP_CENTER);
    
        HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
    
        // Add the HBox to the VBox
        S1L1ScreenBox.getChildren().add(1, buttonBox);
    
        // border pane to hold the VBox
        BorderPane root = new BorderPane();
        root.setCenter(S1L1ScreenBox);
        BorderPane.setMargin(S1L1ScreenBox, new Insets(50));
    
        // create tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void handleAnswerButton(ActionEvent event) {
        Label questionLabel = new Label();
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("Paris")) {
            clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
            questionLabel.setText("Correct!");
        } else {
            clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
            questionLabel.setText("Incorrect");
        }
    }
    




    // //level 2 section 1
    private void showS1L2Screen(Stage primaryStage) {
        // Create a label for the first screen
        Label S1L2ScreenLabel = new Label("scene");
        S1L2ScreenLabel.setFont(Font.font("STENCIL", 30));
        S1L2ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L2ScreenLabel.setTextFill(Color.DARKBLUE);
    
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showFirstScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        //button for level 1
       
        // vbox for labels and back button
        VBox S1L2ScreenBox = new VBox(40, S1L2ScreenLabel, backButton);
        S1L2ScreenBox.setAlignment(Pos.TOP_CENTER);
    
        // border pane to hold the VBox
        BorderPane root = new BorderPane();
        root.setCenter(S1L2ScreenBox);
        BorderPane.setMargin(S1L2ScreenBox, new Insets(50));
    
        // create tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    //level 3 section 1
    private void showS1L3Screen(Stage primaryStage) {
        // Create a label for the first screen
        Label S1L3ScreenLabel = new Label("scene");
        S1L3ScreenLabel.setFont(Font.font("STENCIL", 30));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        Text questionLabel = new Text("When using fractional numbers, "
        + "the datatype ___ is used");
        questionLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(400); // set the maximum width for the text
        questionLabel.setTextAlignment(TextAlignment.CENTER); // set the alignment of the text
    
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showFirstScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
    
        // check button
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkAnswer(answerField.getText(), checkButton));
    
        // hbox for answer field and check button
        HBox answerBox = new HBox(10, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);
    
        // vbox for labels, answer box, and back button
        VBox S1L3ScreenBox = new VBox(40, S1L3ScreenLabel, questionLabel, answerBox, backButton);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);
    
        // border pane to hold the VBox
        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));
    
        // create tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void checkAnswer(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("int")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red");
        }
    }
    
    private void showS2L1Screen(Stage primaryStage) {
        // Create a label for the first screen
        Label S2L1ScreenLabel = new Label("Question 1");
        S2L1ScreenLabel.setFont(Font.font("STENCIL", 30));
        S2L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S2L1ScreenLabel.setTextFill(Color.DARKBLUE);
    
        // Create a label for displaying the result of the answer
        Label questionLabel = new Label("this is the question");
        questionLabel.setAlignment(Pos.TOP_CENTER);
        questionLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 10px;");
    
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showFirstScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
    
        // answer buttons
        answerButtons = new Button[3];
        answerButtons[0] = new Button("New York");
        answerButtons[1] = new Button("Paris");
        answerButtons[2] = new Button("Tokyo");
    
        // set button styles
        for (Button button : answerButtons) {
            button.setStyle("-fx-background-color: white; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
            button.setOnAction(this::handleAnswerButton);
        }
    
        // vbox for labels, answer buttons, and back button
        VBox S2L1ScreenBox = new VBox(40, S2L1ScreenLabel, questionLabel, backButton);
        S2L1ScreenBox.setAlignment(Pos.TOP_CENTER);
    
        HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
    
        // Add the HBox to the VBox
        S2L1ScreenBox.getChildren().add(1, buttonBox);
    
        // border pane to hold the VBox
        BorderPane root = new BorderPane();
        root.setCenter(S2L1ScreenBox);
        BorderPane.setMargin(S2L1ScreenBox, new Insets(50));
    
        // create tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void handleAnswerButton2(ActionEvent event) {
        Label questionLabel = new Label();
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("Paris")) {
            clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
            questionLabel.setText("Correct!");
        } else {
            clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
            questionLabel.setText("Incorrect");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

//  movement of a picture
//         Image image = new Image("file:C:/Users/miran/Pictures/bing/bingus.png");
//         // make the image in the scene
//         ImageView imageView = new ImageView(image);
//         imageView.setLayoutX(300);
//         imageView.setLayoutY(100);
//         imageView.setFitWidth(100);
//         imageView.setFitHeight(100);
//         // adding image to vbox
//         welcomeBox.getChildren().add(imageView);

//         // Create a translate transition to move the image
//         TranslateTransition transition = new TranslateTransition(Duration.seconds(3), imageView);
//         transition.setToX(10);
//         transition.setToY(-50);
//         transition.play();   

