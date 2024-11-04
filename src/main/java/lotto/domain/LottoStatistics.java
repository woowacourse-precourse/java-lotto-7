package lotto.domain;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.util.message.Messages.STATISTICS_INFO;
import static lotto.util.message.Messages.YIELD_RESULT;

public class LottoStatistics {
    private final static int ZERO = 0;
    private final static Prize[] accessOrder = {
            Prize.FIFTH,
            Prize.FOURTH,
            Prize.THIRD,
            Prize.SECOND,
            Prize.FIRST
    };

    private final Map<Prize, Integer> prizeMap = new EnumMap<>(Prize.class);

    private LottoStatistics(Map<Prize, Integer> prizeMap) {
        initPrizeMap();
        this.prizeMap.putAll(prizeMap);
    }

    public static LottoStatistics of(List<Lotto> lottoTicket, WinningLotto winningLotto) {
        return new LottoStatistics(getPrizeCountMap(lottoTicket, winningLotto));
    }

    private static Map<Prize, Integer> getPrizeCountMap(List<Lotto> lottoTicket, WinningLotto winningLotto) {
        Map<Prize, Integer> prizeCountMap = new EnumMap<>(Prize.class);

        for (Prize prize : Prize.values()) {
            prizeCountMap.put(prize, ZERO);
        }

        setPrizeMap(lottoTicket, winningLotto, prizeCountMap);

        return prizeCountMap;
    }

    private static void setPrizeMap(List<Lotto> lottoTicket, WinningLotto winningLotto, Map<Prize, Integer> prizeCountMap) {
        for (Lotto lotto : lottoTicket) {
            Prize prize = Prize.inspect(winningLotto, lotto);
            prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
        }
    }

    private void initPrizeMap() {
        for (Prize prize : Prize.values()) {
            prizeMap.put(prize, ZERO);
        }
    }

    public void printStatistics(int amount) {
        System.out.println(STATISTICS_INFO);
        printPrize();
        printYield(amount);
    }

    private void printPrize() {
        for (Prize prize : accessOrder) {
            printInfo(prize);
        }
    }

    private void printInfo(Prize prize) {
        if (prize == Prize.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                    prize.getMatchNumbers(),
                    priceFormat(prize.getPrice()),
                    prizeMap.get(prize));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개%n",
                prize.getMatchNumbers(),
                priceFormat(prize.getPrice()),
                prizeMap.get(prize));
    }

    private String priceFormat(Long price) {
        DecimalFormat format = new DecimalFormat("###,###");
        return format.format(price);
    }

    private void printYield(int amount) {
        double yield = getYield(amount) * 100;
        System.out.printf(YIELD_RESULT, yield);
    }

    private double getYield(int price) {
        double sum = prizeMap.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return sum / price;
    }
}
