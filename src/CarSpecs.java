import javafx.beans.property.*;


public class CarSpecs {
    private StringProperty brand = new SimpleStringProperty(this, "brand", "");
    private DoubleProperty price = new SimpleDoubleProperty(this,"price",0);

    //Lazy
    private BooleanProperty hasLeaderSeats = null;  //The bindable property, but left uninitiated
    private boolean _hasLeaderSeats = false;    //Shadow property

    public CarSpecs(StringProperty brand, DoubleProperty price, boolean _hasLeaderSeats) {
        this.brand = brand;
        this.price = price;
        this._hasLeaderSeats = _hasLeaderSeats;
    }

    public String getBrand() {
        return brand.get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public BooleanProperty hasLeaderSeatsProperty()
    {
        //If somebody asks for the property then new it
        if( this.hasLeaderSeats == null )
        {
            this.hasLeaderSeats = new SimpleBooleanProperty(this,"hasLeaderSeats", _hasLeaderSeats);
        }
        return this.hasLeaderSeats;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public boolean getHasLeaderSeats() {
        if(hasLeaderSeats == null)
            return _hasLeaderSeats;
        else
            return hasLeaderSeats.get();
    }

    public void setHasLeaderSeats(boolean hasLeaderSeats) {
        if( this.hasLeaderSeats == null )
            this._hasLeaderSeats = hasLeaderSeats;
        else
            this.hasLeaderSeats.set(hasLeaderSeats);
    }
}
