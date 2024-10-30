package lotto.view;

import static lotto.utils.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String BUY_COUNT = "개를 구매했습니다.";

    public static void errorPrint(String errorMessage) {
        System.out.print(ERROR);
        System.out.println(errorMessage);
    }

    public static int inputPrice() {
        try {
            System.out.println(INPUT_PRICE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            errorPrint("inputPrice");
            return inputPrice();
        }
    }
}
