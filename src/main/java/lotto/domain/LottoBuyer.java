package lotto.domain;

import static lotto.constant.LotteryConstant.MATCH_FIVE_NUMBERS_AND_BONUS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_FIVE_NUMBERS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_FOUR_NUMBERS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_SIX_NUMBERS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_THREE_NUMBERS_WINNING_AMOUNT;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    // 구매 개수
    private int lottoPurchaseAmount;
    // 구매자의 총 수익률
    private int lotteryYield;
    // 구매자가 구입한 로또
    private List<Lotto> lottos;
    // 구매자의 당첨 금액
    private int lottoWinningAmount;

    public LottoBuyer() {
        this.lottoPurchaseAmount = 0;
        this.lotteryYield = 0;
        this.lottos = new ArrayList<>();
        this.lottoWinningAmount = 0;
    }

    public void setLottoPurchaseAmount(final int lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public int calculateLotteryYield(final int purchaseAmount, final int totalWinningAmount) {
        this.lotteryYield = totalWinningAmount / purchaseAmount * 100;
        return lotteryYield;
    }

    public void addLotto(final Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }

    public int getLottoWinningAmount() {
        return lottoWinningAmount;
    }

    public void addMoney(final int matchingCount, final boolean isBonus) {
        if (matchingCount <= 2) {
            return;
        }

        if (matchingCount == 3) {
            lottoWinningAmount += MATCH_THREE_NUMBERS_WINNING_AMOUNT;
            return;
        }

        if (matchingCount == 4) {
            lottoWinningAmount += MATCH_FOUR_NUMBERS_WINNING_AMOUNT;
            return;
        }

        if (matchingCount == 5 && !isBonus) {
            lottoWinningAmount += MATCH_FIVE_NUMBERS_WINNING_AMOUNT;
            return;
        }

        if (matchingCount == 5) {
            lottoWinningAmount += MATCH_FIVE_NUMBERS_AND_BONUS_WINNING_AMOUNT;
            return;
        }

        if (matchingCount == 6) {
            lottoWinningAmount += MATCH_SIX_NUMBERS_WINNING_AMOUNT;
        }
    }
}
