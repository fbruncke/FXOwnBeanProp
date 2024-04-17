import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;


public class MainView extends Application {
    private StockData stockData = null;

    public MainView() {
        stockData = new StockData();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane,600,600);

        Label lbName = new Label("Stock name");
        lbName.setLayoutX(10);
        lbName.setLayoutY(50);

        TextField tfName = new TextField();
        tfName.setLayoutX(100);
        tfName.setLayoutY(50);


        Label lbPrice = new Label("Stock price");
        lbPrice.setLayoutX(10);
        lbPrice.setLayoutY(100);

        TextField tfPrice = new TextField();
        tfPrice.setLayoutX(100);
        tfPrice.setLayoutY(100);

        //tfPrice.textProperty().bind( Bindings.format("%d", stockData.stockPriceProperty()));

        Button btnSave = new Button("Save price");
        btnSave.setLayoutX(10);
        btnSave.setLayoutY(150);
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stockData.setStockName(tfName.getText());
                try {

                    stockData.setStockPrice(Integer.parseInt(tfPrice.getText()));
                    //stockData.stockPriceProperty().Binding();
                }
                catch (NumberFormatException nfEx)
                {
                    System.out.println(nfEx.getMessage());
                }
                tfName.setText("");
                tfPrice.setText("");//reset price textfield
            }
        });


        //notes
        //Bindings.bindBidirectional(tfPrice.textProperty(), stockData.stockPriceProperty(), new NumberStringConverter());

        //tfPrice.textProperty().bindBidirectional(stockData.stockPriceProperty(), new NumberStringConverter() );


        Button btnOpen = new Button("See price");
        btnOpen.setLayoutX(100);
        btnOpen.setLayoutY(150);
        btnOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ShowData sd = new ShowData();
                sd.showUI(stockData);
            }
        });


//        Slider someSlider = new Slider(0,10,5);
//
//        someSlider.valueProperty().addListener(new InvalidationListener() {
//            @Override
//            public void invalidated(Observable observable) {
//
//            }
//        });

        pane.getChildren().addAll(lbName,lbPrice, tfName,tfPrice,btnOpen,btnSave);

        primaryStage.setTitle("Input actual stock price");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
