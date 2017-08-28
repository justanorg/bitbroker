package justanorg.bitbroker.model;

import justanorg.bitbroker.exchange.Exchange;

import java.math.BigDecimal;

public class Order implements Decision {
    private Exchange exchange;
    private BigDecimal price;
    private BigDecimal quantity;
    private boolean buyIn;

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public boolean isBuyIn() {
        return buyIn;
    }

    public void setBuyIn(boolean buyIn) {
        this.buyIn = buyIn;
    }
}
