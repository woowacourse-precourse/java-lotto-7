package lotto.custom.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.custom.model.Lotto;
import lotto.custom.model.LottoPrize;
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
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers); // 오름차순으로 정렬
            System.out.println(sortedNumbers);
        }
    }

    public void displayLottoResult(List<Integer> result) {
        System.out.println();
        System.out.println(PromptMessages.DISPLAY_LOTTO_RESULT_PROMPT);
        System.out.println(PromptMessages.SEPARATOR_PROMPT);
        int index = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            String prizeMoney = String.format("%,d", prize.getPrizeMoney());

            System.out.println(prize.getPrizeDescription() +
                    " (" + prizeMoney + "원) - " +
                    result.get(index++) + "개");
        }
    }

    public void displayLottoYield(double yield) {
        String formattedYield = String.format("%.1f", yield);
        System.out.println("총 수익률은 " + formattedYield + "%입니다.");
    }
}