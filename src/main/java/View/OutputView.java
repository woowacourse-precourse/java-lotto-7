package View;

import Model.Lotto;
import Constant.Constant;

import java.util.List;

public class OutputView {

    public static void printTrialLottoCount(Integer trialLottoCount) {
        System.out.println(String.format(Constant.MessageConstant.OUTPUT_PROMPT, trialLottoCount));
    }

    public static void printLottosNumbers(List<Lotto> buyLotto) {
        for (Lotto lotto : buyLotto) {
            System.out.println(lotto.toString());
        }
    }
}
