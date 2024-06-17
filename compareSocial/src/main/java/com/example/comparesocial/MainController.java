package com.example.comparesocial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private TableView<Engagement> tableView;

    @FXML
    private TableColumn<Engagement, Integer> idColumn;

    @FXML
    private TableColumn<Engagement, String> platformColumn;

    @FXML
    private TableColumn<Engagement, java.sql.Date> dateColumn;

    @FXML
    private TableColumn<Engagement, Integer> engagementCountColumn;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private PieChart pieChart;

    @FXML
    private CategoryAxis xAxis; // Required for BarChart

    /**
     * Initializes the controller after its root element has been completely processed.
     * This method is automatically called after the FXML file has been loaded.
     */
    public void initialize() {
        initializeTableView();
        initializeBarChart();
        initializePieChart();
    }

    /**
     * Initializes the TableView by setting up the cell value factories and populating it with data.
     */
    private void initializeTableView() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<>("platform"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        engagementCountColumn.setCellValueFactory(new PropertyValueFactory<>("engagementCount"));

        // Fetch data from database and populate the table
        List<Engagement> engagements = fetchDataFromDatabase();
        ObservableList<Engagement> data = FXCollections.observableArrayList(engagements);
        tableView.setItems(data);
    }

    /**
     * Initializes the BarChart by setting up categories and populating it with data.
     */
    private void initializeBarChart() {
        xAxis.setCategories(FXCollections.observableArrayList("Facebook", "Twitter", "Instagram"));

        // Fetch data from database and populate the bar chart
        List<Engagement> engagements = fetchDataFromDatabase();
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("Engagement Counts");

        for (Engagement engagement : engagements) {
            series.getData().add(new XYChart.Data<>(engagement.getPlatform(), engagement.getEngagementCount()));
        }

        barChart.getData().add(series);
    }

    /**
     * Initializes the PieChart by populating it with data.
     */
    private void initializePieChart() {
        // Fetch data from database and populate the pie chart
        List<Engagement> engagements = fetchDataFromDatabase();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Engagement engagement : engagements) {
            pieChartData.add(new PieChart.Data(engagement.getPlatform(), engagement.getEngagementCount()));
        }

        pieChart.setData(pieChartData);
    }

    /**
     * Fetches engagement data from the database.
     *
     * @return List of Engagement objects containing data fetched from the database
     */
    private List<Engagement> fetchDataFromDatabase() {
        List<Engagement> engagements = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtility.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM engagement_data");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String platform = resultSet.getString("platform");
                java.sql.Date date = resultSet.getDate("date");
                int engagementCount = resultSet.getInt("engagement_count");

                engagements.add(new Engagement(id, platform, date, engagementCount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtility.close(resultSet);
            DBUtility.close(statement);
            DBUtility.close(connection);
        }

        return engagements;
    }
}
