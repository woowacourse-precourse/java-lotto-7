package View;

import Model.Lotto;
import Constant.Constant;

import java.util.List;

public class OutputView {
    private static List<Lotto> buyLottos;
    private static List<Integer> winningNumbers;
    private static Integer bonusNumber;
    private static Integer bounsWinCount = 0;

    public static void printTrialLottoCount(Integer trialLottoCount) {
        System.out.println(String.format(Constant.MessageConstant.OUTPUT_PROMPT, trialLottoCount));
    }

    public static void printLottosNumbers(List<Lotto> buyLotto) {
        for (Lotto lotto : buyLotto) {
            System.out.println(lotto.toString());
        }
    }

    public static void printCheckStart() {
        System.out.println(Constant.MessageConstant.WINNING_STATISTICS);
    }
}
