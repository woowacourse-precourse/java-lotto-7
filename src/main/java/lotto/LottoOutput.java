package lotto;

import lotto.enums.OutputMessage;
import lotto.enums.Rank;

import java.util.List;

public class LottoOutput {
    public void displayPurchaseAmountPrompt() {
        System.out.println(OutputMessage.PURCHASE_AMOUNT_PROMPT.getText());
    }

    public void displayPurchasedLottoCount(long purchasedLottoCount) {
        System.out.println(purchasedLottoCount + OutputMessage.PURCHASED_LOTTO_COUNT.getText());
    }

    public void displayLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayWinningNumbersPrompt() {
        System.out.println(OutputMessage.WINNING_NUMBERS_PROMPT_MESSAGE.getText());
    }

    public void displayBonusNumberPrompt() {
        System.out.println(OutputMessage.BONUS_NUMBER_PROMPT_MESSAGE.getText());
    }

    public void displayPlaceResult(List<Integer> placeCount) {
        System.out.println(OutputMessage.WINNING_STATISTICS_HEADER.getText());
        System.out.println(OutputMessage.WINNING_STATISTICS_SEPARATOR.getText());
        for (Rank rank : Rank.values()) {
            int count = placeCount.get(rank.getIndex());
            System.out.println(rank.getMessage(count));
        }
    }

    public void displayEarningsRate(double earningsRate) {
        System.out.printf(OutputMessage.EARNINGS_RATE_MESSAGE.getText(), earningsRate);
    }
}