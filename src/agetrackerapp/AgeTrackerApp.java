/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agetrackerapp;

import java.util.Arrays;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author tshep
 */
public class AgeTrackerApp extends Application {
    
    private Random rng = new Random();
    int rand = 0; 
    private String nameList [] = new String [50];
    private String dobList [] = new String[50];
    private int ageList [] = new int [50];
    private TextField nameText;
    private TextField dobText;
    private TextField ageText;
    private Label result;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        // Creating Our Grid.
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(20);
        grid.setVgap(20);
        
        // Adding labels and Buttons
        
        // Name Label
        Label nameLabel = new Label("Name");
        grid.add(nameLabel, 1, 0);
        
        // Textbox For name
        nameText = new TextField();
        grid.add(nameText,1,1);
        
        // DOB Label
        Label dobLabel = new Label("Date Of Birth");
        grid.add(dobLabel, 1, 2);
        
        // Textbox For DOB 
        dobText = new TextField();
        grid.add(dobText,1,3);
        
        // Age Label
        Label ageLabel = new Label("Age");
        grid.add(ageLabel, 1, 4);
        
        // Textbox For Age
        ageText = new TextField();
        grid.add(ageText,1,5);
        
        result = new Label();
        grid.add(result,1,7);
        
        
        
        // Button For Creating a Profile
        Button btn = new Button();
        btn.setText("Create");
        grid.add(btn,1,6);
        btn.setOnAction(e -> saveUser());
        
        // Button for Searching a profile
        Button btn2 = new Button();
        btn2.setText("Search");
        grid.add(btn2,2,6);
        btn2.setOnAction(e -> searchUser()); 

        // Creates Scene for application
        Scene scene = new Scene(grid, 400, 400);
        
        primaryStage.setTitle("Age Tracker App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void saveUser(){
        //Passing Values to User Class For Saving
            
            String name = nameText.getText();
            String dOB = dobText.getText();
            String age = ageText.getText();
            
            if(name.equals("")){
                result.setText("Please enter a name, birthday and age");
            }
            if(!name.equals("")){
            rand = rng.nextInt(50);
            nameList[rand] = name;
            dobList[rand]= dOB;
            ageList[rand]= Integer.parseInt(age);
            
            // Printing user position
            System.out.println("User Saved");
            result.setText("User Saved at Position "+ rand);
            
            //clearing fields
            nameText.setText("");
            dobText.setText("");
            ageText.setText("");
            }
    
    }
    
    public void searchUser(){
        String name = nameText.getText();
        boolean match = false;
        int position = Arrays.asList(nameList).indexOf(name);
            
            while(!match){
                    // Checks whether user entered a name
                    if(name.equals("")){
                        result.setText("Please Enter a name to search");
                        break;
                    }
                    // Checks to see if User is registered
                    if(position!=-1){
                        
                        result.setText("User "+nameList[position]+ " is Registered and is " + ageList[position] +" Years old");
                        System.out.println(nameList[position] + ageList[position]);
                        match = true;
                    }
                    
                    if(match == false){
                        result.setText("User "+ name +" does not exist");   
                        }
                    break;
                }
            
                
                   
                
           
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
