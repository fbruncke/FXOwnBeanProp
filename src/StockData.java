import com.sun.javafx.image.BytePixelSetter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class StockData {
    private String stockName = "";
    private int stockPriceShadow = 0; //shawdow
    private IntegerProperty stockPrice = null;
    //private ReadOnlyIntegerWrapper stockPrice = new ReadOnlyIntegerWrapper(this,"stockPrice",0);

    public StockData(){}

    public StockData(String stockName, int stockPrice) {
        this.stockName = stockName;
        this.stockPriceShadow = stockPrice;
         //this.stockPrice = new SimpleIntegerProperty(this,"stockPrice",0);
        //this.stockPrice.set(stockPrice);
    }

    //public IntegerProperty stockPriceProperty(){
    public final ReadOnlyIntegerProperty stockPriceProperty(){
        if( this.stockPrice == null )
            this.stockPrice = new SimpleIntegerProperty(this,"stockPrice",0);

        return this.stockPrice;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getStockPrice() {
        //return stockPrice;

        return stockPrice.get();
    }


    public void setStockPrice(int stockPrice) {

        if( this.stockPrice == null )
            this.stockPriceShadow = stockPrice;
        else
            this.stockPrice.set(stockPrice);

    }



}
