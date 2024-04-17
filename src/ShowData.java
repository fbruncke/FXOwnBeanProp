import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ShowData {

    public void showUI(StockData stockData)
    {
        Stage stage = new Stage();

        Pane pane = new Pane();
        Scene scene = new Scene(pane,500,500);

        Label lbName = new Label("Stock name");
        lbName.setLayoutX(10);
        lbName.setLayoutY(50);

        TextField tfName = new TextField();
        tfName.setLayoutX(100);
        tfName.setLayoutY(50);
        tfName.setText(stockData.getStockName());

        Label lbPrice = new Label("Stock price");
        lbPrice.setLayoutX(10);
        lbPrice.setLayoutY(100);

        TextField tfPrice = new TextField();
        tfPrice.setLayoutX(100);
        tfPrice.setLayoutY(100);
        //tfPrice.setText(""+stockData.getStockPrice()); //read stock price data from model
        tfPrice.textProperty().bind( Bindings.format("%d", stockData.stockPriceProperty()));  //set up databinding textfield / stock price

        Button btnShow = new Button("show data");
        btnShow.setLayoutX(10);
        btnShow.setLayoutY(150);
        btnShow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tfName.setText(stockData.getStockName());
                tfPrice.setText(""+stockData.getStockPrice());  //read stock price frommodel
            }
        });

        Button btnReadOnly = new Button("btn set ReadOnly property data");
        btnReadOnly.setLayoutX(10);
        btnReadOnly.setLayoutY(250);
        btnReadOnly.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //stockData.stockPriceProperty().set(200); //<-- not possible with read only property
            }
        });


        pane.getChildren().addAll(lbName,lbPrice, tfName,tfPrice,btnShow,btnReadOnly);

        stage.setTitle("Show actual stock price");
        stage.setScene(scene);
        stage.show();
    }
}


//tfPrice.textProperty().bind( Bindings.format("%d", stockData.stockPriceProperty()));

