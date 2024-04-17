import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CarPrice {


    private IntegerProperty price = new SimpleIntegerProperty();


    public int getPrice()
    {
        return this.price.get();
    }

    public void setPrice(int price)
    {
        this.price.set( price);
    }

    public ReadOnlyIntegerProperty priceProperty()
    {
        return price;
    }

}
