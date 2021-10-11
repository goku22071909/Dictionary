package Control;

import DictionaryMain.DictionaryManagement;
import DictionaryMain.Word;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static DictionaryMain.Dictionary.listWord;

public class Controller implements Initializable {

    @FXML
    ListView<String> listView;
    @FXML
    TextArea textArea;
    @FXML
    TextArea searchTextArea;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
          DictionaryManagement.insertFromFile();
          for(Word p : listWord) {
              listView.getItems().add(p.getWord_target());
          }
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String word = listView.getSelectionModel().getSelectedItem();
                String explain = DictionaryManagement.dictionaryLookup(word);
                textArea.setText(explain);
                //textArea.setText("Hello");
            }
        });

    }
    public void onButton(ActionEvent e) throws IOException {
        String text = searchTextArea.getText();
        ArrayList<String> s = new ArrayList<>();
        s = DictionaryManagement.dictionarySeacher(text);
        listView.getItems().clear();
        for(String word : s) {
            listView.getItems().add(word);
        }

    }
}
