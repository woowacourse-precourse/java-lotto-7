package lotto.view;

import lotto.model.lottos.Lotto;

import java.util.List;

public class OutputView {

    public void printPurchaseGuide() {
        System.out.println(OutputMessage.PURCHASE_GUIDE.getMessage());
    }

    public void printWinningNumbersGuide() {
        System.out.println(OutputMessage.WINNING_NUMBERS_GUIDE.getMessage());
    }

    public void printBonusNumberGuide() {
        System.out.println(OutputMessage.BONUS_NUMBER_GUIDE.getMessage());
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(String.format(OutputMessage.LOTTO_COUNT_MESSAGE.getMessage(), lottoCount));
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(List<Integer> result) {
        System.out.println(String.format(OutputMessage.THREE_MATCH.getMessage(), result.get(4)));
        System.out.println(String.format(OutputMessage.FOUR_MATCH.getMessage(), result.get(3)));
        System.out.println(String.format(OutputMessage.FIVE_MATCH.  getMessage(), result.get(2)));
        System.out.println(String.format(OutputMessage.FIVE_BONUS_MATCH.getMessage(), result.get(1)));
        System.out.println(String.format(OutputMessage.SIX_MATCH.getMessage(), result.get(0)));
    }

    public void printLottoRate(double rate) {
        System.out.println(String.format(OutputMessage.LOTTO_RATE_MESSAGE.getMessage(), rate));
    }

    public void printRetryGuide() {
        System.out.println(String.format(OutputMessage.RETRY_MESSAGE.getMessage()));
    }

    public void printErrorMessage(String price) {
        System.out.println(price);
    }
}
