package justanorg.bitbroker.model;

import justanorg.bitbroker.market.Market;

import java.math.BigDecimal;

public class Decision {
    private Market market;
    private BigDecimal price;
    private int quantity;
    private boolean buyIn;

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBuyIn() {
        return buyIn;
    }

    public void setBuyIn(boolean buyIn) {
        this.buyIn = buyIn;
    }
}
