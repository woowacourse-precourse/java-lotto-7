package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String SEPARATOR = ",";
    private static final String INPUT_AMOUNT = "구입 금액을 입력해주세요.";
    private static final String INPUT_LOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "\n보너스 번호를 입력해 주세요.";

    public static String readAmount() {
        System.out.println(INPUT_AMOUNT);

        return Console.readLine();
    }

    public static List<String> readNumbers() {
        System.out.println(INPUT_LOTTO);
        String input = Console.readLine();

        return List.of(input.trim().split(SEPARATOR));
    }

    public static String readBonusNumber() {
        System.out.println(INPUT_BONUS);

        return Console.readLine();
    }

}
