package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.WordCountModel;
import sample.Main;
import sample.logic.*;

import java.util.ArrayList;

public class StatisticsFrameController {

    @FXML
    private TableColumn<WordCountModel, Integer> countsColumn;

    @FXML
    private TableView<WordCountModel> tableView;

    @FXML
    private ObservableList<WordCountModel> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<WordCountModel, String> wordsColumn;


    public void fillTable(String URL){

        DictionaryMaker dictionaryMaker = new DictionaryMaker();
        PageLoader loader = new PageLoader();
        String document =  loader.LoadPage(URL);
        ArrayList<WordCountModel> dictionaryList = dictionaryMaker.CountUniqueWords(document);
        list = FXCollections.observableArrayList(dictionaryList);

        wordsColumn.setCellValueFactory(new PropertyValueFactory<WordCountModel,String>("word"));
        countsColumn.setCellValueFactory(new PropertyValueFactory<WordCountModel,Integer>("count"));
        countsColumn.setSortType(TableColumn.SortType.DESCENDING);
        tableView.setItems(list);
        tableView.getSortOrder().add(countsColumn);
    };

    @FXML
    public void initialize() {

    }
}
