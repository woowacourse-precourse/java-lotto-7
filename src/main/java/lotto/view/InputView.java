package lotto.view;

import static lotto.utils.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNER_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.";


    public static void errorPrint(String errorMessage) {
        System.out.print(ERROR);
        System.out.println(errorMessage);
    }

    public int inputPrice() {
        while (true) {
            try {
                System.out.println(INPUT_PRICE_MESSAGE);
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                errorPrint(INVALID_PRICE);
            }
        }
    }

    public List<String> inputNumbers() {
        System.out.println(INPUT_WINNER_LOTTO_MESSAGE);
        return List.of(Console.readLine().split(","));
    }

    public int inputBonus() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_MESSAGE);
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                errorPrint(INVALID_BOUNS_NUMBER);
            }
        }
    }
}
