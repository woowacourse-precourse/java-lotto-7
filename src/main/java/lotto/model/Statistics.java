package lotto.model;

import lotto.model.enums.LottoConstants;
import lotto.model.enums.LottoPrize;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Statistics {
    private final int[] lottoPrizeCount;

    public Statistics(PurchasedLottosResult purchasedLottosResult) {
        lottoPrizeCount = new int[LottoConstants.NUMBER_OF_LOTTO_PRIZE.getValue()];
        for ( LottoResult lottoResult : purchasedLottosResult.getPurchasedLottosResult() ) {
            lottoPrizeCount[lottoResult.getPrize()] ++;
        }
    }

    public int[] getLottoPrizeCount() {
        return lottoPrizeCount;
    }

    public BigDecimal getYield () {
        int tickets = 0;
        BigDecimal total = BigDecimal.ZERO;
        for ( LottoPrize lottoPrize : LottoPrize.values() ) {
            tickets += lottoPrizeCount[lottoPrize.getNstPrize()];
            int prize = lottoPrize.getPrize();

            BigDecimal prizeAmount = BigDecimal.valueOf(prize).
                    multiply(BigDecimal.valueOf(lottoPrizeCount[lottoPrize.getNstPrize()]));
            total = total.add(prizeAmount);
        }
        String purchasedAmount = String.valueOf(tickets*
                LottoConstants.LOTTO_TICKET_PRICE.getValue()/100);

        return total.divide(new BigDecimal(purchasedAmount),
                LottoConstants.HALF_UP_ROUNDING_POSITION.getValue(),
                RoundingMode.HALF_UP);
    }
}
