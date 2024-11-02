package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.constant.Prompt;

public class InputView {
    private InputView() {}

    public static String inputMoney() {
        System.out.println(Prompt.INPUT_MONEY.getMessage());
        return Console.readLine();
    }

//    public static List<Integer> inputLottoNumbers() {
//        System.out.println(Prompt.INPUT_WINNING_NUMBERS.getMessage());
//        String a = Console.readLine();
//        String[] split = a.split(",");
//        return Arrays.stream(split). ;
//    }

//    public static List<Integer> inputLottoNumbers() {
//
//    }


}
