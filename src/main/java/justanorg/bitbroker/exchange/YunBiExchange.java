package justanorg.bitbroker.exchange;

import justanorg.bitbroker.model.Decision;
import justanorg.bitbroker.model.KChart;
import justanorg.bitbroker.model.KPoint;
import justanorg.bitbroker.model.Market;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

public class YunBiExchange implements Exchange {
    private Client client;

    public YunBiExchange() {
        ClientConfig clientConfig = new ClientConfig();
        client = ClientBuilder.newClient(clientConfig);
    }

    private WebTarget newYunBiApiTarget() {
        return client.target("https://yunbi.com/api/v2/");
    }

    @Override
    public List<Market> getSupportedMarket() {
        return newYunBiApiTarget().path("markets.json").request()
                .get().readEntity(new GenericType<List<Market>>() {});
    }

    @Override
    public KChart getKChart(String marketId, int period, Long startTime, Integer limit) {
        WebTarget target = newYunBiApiTarget().path("k.json").queryParam("market", marketId);
        if(startTime != null) {
            //Api uses second not millisecond, so convert time to second
            target.queryParam("timestamp", TimeUnit.SECONDS.toMillis(startTime));
        }
        if(limit != null) {
            target.queryParam("limit", limit);
        } else {
            //Api defaults to 30
            limit = 30;
        }

        List<KPoint> kPoints = target.request()
                .get().readEntity(new GenericType<List<List<BigDecimal>>>(){})
                .stream()
                .map(point -> {
                    KPoint kPoint = new KPoint();
                    //Api returns in second, convert to millisecond
                    kPoint.setTime(TimeUnit.MILLISECONDS.toSeconds(point.get(0).longValue()));
                    kPoint.setOpen(point.get(1));
                    kPoint.setHigh(point.get(2));
                    kPoint.setLow(point.get(3));
                    kPoint.setClose(point.get(4));
                    kPoint.setVolume(point.get(5));
                    return kPoint;
                })
                .collect(toList());

        KChart kChart = new KChart();
        kChart.setPeriod(period);
        kChart.setLimit(limit);
        kChart.setStartTime(startTime);
        kChart.setPoints(kPoints);
        return kChart;
    }

    @Override
    public void executeDecision(List<Decision> decisions) {
        //TODO handle decision
    }

    public static void main(String[] args) {
        YunBiExchange yunBiExchange = new YunBiExchange();
        List<Market> supportedMarket = yunBiExchange.getSupportedMarket();
        supportedMarket.forEach(market -> {
            System.out.println(yunBiExchange.getKChart(market.getId(), 30, null, null));
        });
    }


}
