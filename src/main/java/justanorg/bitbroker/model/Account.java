package justanorg.bitbroker.model;

import java.math.BigDecimal;
import java.util.List;

public class Account {
    private BigDecimal money;
    private List<Order> waitingOrders;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public List<Order> getWaitingOrders() {
        return waitingOrders;
    }

    public void setWaitingOrders(List<Order> waitingOrders) {
        this.waitingOrders = waitingOrders;
    }
}
