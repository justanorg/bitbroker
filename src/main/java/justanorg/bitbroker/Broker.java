package justanorg.bitbroker;

import justanorg.bitbroker.market.MarketManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Broker {
    @Autowired
    private MarketManager marketManager;

    @Scheduled(fixedRate = 30000)
    public void analyseMarketAndMakeDecision() {
        //TODO Main loop
    }

}
