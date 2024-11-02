package lotto.domain;

import lotto.domain.constant.Ranking;

import java.util.EnumMap;

import static lotto.domain.constant.LottoRule.TICKET_PRICE;

public class EarningRateCalculator {

    public static final int PERCENTAGE_MULTIPLIER = 100;

    public double calculateEarningRate(PurchasedLottos purchasedLottos, EnumMap<Ranking, Integer> statistics) {
            Money totalPrize = statistics.entrySet().stream()
                    .map(entry -> Money.from(entry.getKey().getPrize() * entry.getValue()))
                    .reduce(Money.ZERO, Money::plus);

            Money purchasedAmount = Money.from(purchasedLottos.getQuantity() * TICKET_PRICE.getNumber());
            Money earningRate = totalPrize.divideWithRoundHalfUp(purchasedAmount);

            return earningRate.doubleValue() * PERCENTAGE_MULTIPLIER;
        }
    }
