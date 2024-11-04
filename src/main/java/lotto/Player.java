package lotto;

import lotto.input.PurchaseAmountValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static lotto.enums.LottoConstants.LOTTO_PRICE;

public class Player {
    private int purchaseAmount;
    private List<Lotto> lottoBatch;

    public Player(int purchaseAmount, List<Lotto> lottoBatch) {
        this.purchaseAmount = purchaseAmount;
        this.lottoBatch = lottoBatch;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public List<Lotto> getLottoBatch() {
        return this.lottoBatch;
    }

    public double getProfitRate(int totalPrize){
        BigDecimal profitRate = BigDecimal.valueOf((double) totalPrize / purchaseAmount * 100);
        return profitRate.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
