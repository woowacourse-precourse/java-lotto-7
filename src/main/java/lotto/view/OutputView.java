package lotto.view;

import lotto.enums.Rank;
import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String OUTPUT_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String OUTPUT_WINNING_STAT = "당첨 통계";
    private static final String OUTPUT_PROFIT = "총 수익률은 %.1f%%입니다.";

    public void printInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public void printInputWinnerNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public void printInputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printOutputLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + OUTPUT_LOTTO_COUNT);
    }

    public void printOutputLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printOutputLottoStatistics(Map<Rank, Integer> resultMap) {
        System.out.println();
        System.out.println(OUTPUT_WINNING_STAT);
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.println(rank.generateResultMessage(resultMap.get(rank)));
            }
        }
    }

    public void printOutputProfit(double profit) {
        System.out.println();
        System.out.printf((OUTPUT_PROFIT) + "%n", profit);
    }
}
