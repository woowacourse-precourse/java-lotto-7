package lotto.custom.view;

import java.util.List;
import lotto.custom.constants.NumberConstants;
import lotto.custom.model.Lotto;
import lotto.custom.model.Lottos;

public class OutputView {
    public void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void displayLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + PromptMessages.DISPLAY_LOTTO_COUNT_PROMPT);
    }

    public void displayLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayLottoResult(List<Integer> result) {
        System.out.println();
        System.out.println(PromptMessages.DISPLAY_LOTTO_RESULT_PROMPT);
        System.out.println(PromptMessages.SEPARATOR);
        int index = 0;
        for (NumberConstants.Prize prize : NumberConstants.Prize.values()) {
            String PrizeMoney = String.format("%,d", prize.getPrizeMoney());

            System.out.println(prize.getPrizeDescription() +
                    " (" + PrizeMoney + "원) - " +
                    result.get(index++) + "개");
        }
    }

    public void displayLottoYield(double yield) {
        String formattedYield = String.format("%.1f", yield);
        System.out.println("총 수익률은 " + formattedYield + "%입니다.");
    }
}