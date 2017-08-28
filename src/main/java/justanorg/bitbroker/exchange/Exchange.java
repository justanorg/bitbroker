package justanorg.bitbroker.exchange;

import justanorg.bitbroker.model.Decision;
import justanorg.bitbroker.model.KChart;
import justanorg.bitbroker.model.Market;
import justanorg.bitbroker.model.Order;

import java.util.List;

public interface Exchange {
    List<Market> getSupportedMarket();
    KChart getKChart(String marketId, int period, Long startTime, Integer limit);
    void executeDecision(List<Decision> decisions);


}
