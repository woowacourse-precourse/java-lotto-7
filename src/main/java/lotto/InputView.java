package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String REQUEST_PURCHASE_MOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_CONFIRM = "개를 구매했습니다.";
    private static final String REQUEST_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUM = "보너스 번호를 입력해 주세요.";
    private int paidMoney;

    public int purchaseLotto() {
        System.out.println(REQUEST_PURCHASE_MOUNT);
        paidMoney = Integer.parseInt(Console.readLine());

        return paidMoney;
    }

    private void showDrawAmount(int drawAmount) {
        System.out.println(drawAmount + PURCHASE_CONFIRM);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println(REQUEST_WINNING_NUM);
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println(REQUEST_BONUS_NUM);
        return Integer.parseInt(Console.readLine());
    }


}
