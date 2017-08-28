package justanorg.bitbroker.exchange;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeManager {
    private List<Exchange> exchanges = new ArrayList<>();

    public ExchangeManager() {
        exchanges.add(new YunBiExchange());
    }

    public List<Exchange> getExchanges() {
        return exchanges;
    }

}
