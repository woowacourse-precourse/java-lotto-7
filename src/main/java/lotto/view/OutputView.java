package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.NumbersParam;

import java.util.List;

public class OutputView {
    public static final String askMoneyMessage = "구입금액을 입력해 주세요.";
    public static final String noticeTrialMessage = "개를 구매했습니다.";

    public static void printAskMoneyMessage() {
        System.out.println(askMoneyMessage);
    }

    public static void printNoticeTrialMessage(int trial) {
        System.out.println("\n" + trial + noticeTrialMessage);
    }

    public static void printBoughtLottos(List<Lotto> lottos) {
        List<NumbersParam> numbersParams = lottos.stream()
                .map(lotto -> NumbersParam.from(lotto.getNumbers()))
                .toList();
        for (NumbersParam param : numbersParams) {
            System.out.println("[" + String.join(", ", param.numbers()) + "]");
        }
    }
}