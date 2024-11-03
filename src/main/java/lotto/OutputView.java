package lotto;

import java.util.List;

public class OutputView {
    public static void promptForAmount() {
        System.out.println(OutputMessage.PROMPT_FOR_AMOUNT);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(OutputMessage.LOTTO_PURCHASE_COUNT_FORMAT, lottos.size());

        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void promptForLottoNumbers() {
        System.out.println(OutputMessage.PROMPT_FOR_LOTTO_NUMBERS);
    }

    public static void promptForBonusNumber() {
        System.out.println(OutputMessage.PROMPT_FOR_BONUS_NUMBER);
    }

    public static void printResult(LottoResultCounter resultCounter, int cost) {
        System.out.println(OutputMessage.LOTTO_RESULT_HEADER);
        System.out.println(resultCounter);
        float returnRate = (float)Math.round((float)resultCounter.getProfit() / cost * 1000) / 10;
        System.out.printf(OutputMessage.RETURN_RATE_FORMAT, returnRate);
    }
}
