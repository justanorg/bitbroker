package justanorg.bitbroker;

import justanorg.bitbroker.Analyse.Analyzer;
import justanorg.bitbroker.exchange.ExchangeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Broker {
    @Autowired
    private ExchangeManager exchangeManager;
    @Autowired
    private Analyzer analyzer;

    @Scheduled(fixedRate = 60000)
    public void analyseExchanges() {
        analyzer.analyze(exchangeManager);
        //TODO Main loop
    }

}
