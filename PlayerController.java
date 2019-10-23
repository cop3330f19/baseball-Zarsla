/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author vjvib
 */
public class PlayerController implements Initializable {

    /**
     * 
     * Variables that are a mapping to the FXML controls
     * 
     */
    @FXML private ListView lvStates;
    @FXML private TableView tblResult;
    @FXML private TableColumn <String, Player> Player;
    @FXML private TableColumn <String, Player> BattingAverage;
    
    
    //ArrayList of States objects
    private final List<Player> players = new ArrayList<>();
    
    //Gets the directory path of the project
    private final String DIR = System.getProperty("user.dir");
          
    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        readFile();
        
        //ChangeListerner for when you click on a ListView Item
        lvStates.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               
                //Find the state chosen in the ArrayList
                int idx = findState(newValue);
                
                //Link the column's cell value to the get function of the States Class.
                //REMEMBER the name in the quotation marks should match the case of the get function
                Player.setCellValueFactory(new PropertyValueFactory<>("Name"));
                BattingAverage.setCellValueFactory(new PropertyValueFactory<>("Average"));
            
                
                //Create an ObservableList object to store the States object(s)
                ObservableList<Player> result = FXCollections.observableArrayList();
                
                //Add the States object to the list
                result.add(player.get(idx));
              
                //Bind the list  to the table
                tblResult.setItems(result);
                
            }
        });
    }
    
    /**
     * Sequential search of the states by name
     * @param value
     * @return 
     */
    
    private int findState(String value){
     
        for(int i = 0; i < player.size(); i++)
            if(player.get(i).getTeam().equals(value))
                return i;
        return 0;
    }
    
    /**
     * Read file contents and populate the Lists and ListView
     */
    private void readFile() {
        
        //ObservableList to add states to the ListView
        ObservableList<String> stateList = FXCollections.observableArrayList();
        
        //Open csv file for input
        try(BufferedReader csvReader = Files.newBufferedReader(Paths.get(DIR + "//src//usstates//data//baseball.xml"))){
            
            String row;
            //reads a line at a time until the EOF
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(","); 
                
                //player object
                Player state = new Player(data[0], data[1], data[2], data[3]);
                //add object to ArrayList
                player.add(player);
                //add state name to ObservableList
                stateList.add(data[2]);
            }
        
        }catch(IOException e){
            System.err.println("Error openning file");
            e.printStackTrace();
        }
        
        //Sorts the List of State objects by state name in ascending order
        Collections.sort(player, new PlayerComparator());
        //sorts the ObservableList
        Collections.sort(stateList);
        
        //Binds the ObservableList to the ListView
        lvStates.setItems(stateList);
    }
}