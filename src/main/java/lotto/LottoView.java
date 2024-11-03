package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoView {

    private static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputPrice() {
        System.out.println(PRICE_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }


    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Integer> lotto) {
        System.out.println(lotto.toString());

    }
}
