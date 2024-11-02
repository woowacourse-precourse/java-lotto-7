package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String PURCHASE_QUESTION = "구입금액을 입력해 주세요.";
    public static final String WINNER_LOTTO_QUESTION = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_LOTTO_NUMBER_QUESTION = "보너스 번호를 입력해 주세요.";

    public static String purchaseQuestion() {
        System.out.println(PURCHASE_QUESTION);
        return Console.readLine();
    }

    public static String winnerLottoNumberQuestion() {
        System.out.println();
        System.out.println(WINNER_LOTTO_QUESTION);
        return Console.readLine();
    }

    public static String bonusLottoNumberQuestion() {
        System.out.println();
        System.out.println(BONUS_LOTTO_NUMBER_QUESTION);
        return Console.readLine();
    }
}
