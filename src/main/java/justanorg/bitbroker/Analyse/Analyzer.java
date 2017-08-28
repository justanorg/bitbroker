package justanorg.bitbroker.Analyse;

import justanorg.bitbroker.exchange.ExchangeManager;
import justanorg.bitbroker.model.Order;

import java.util.List;

public interface Analyzer {

    List<Order> analyze(ExchangeManager exchangeManager);

}
