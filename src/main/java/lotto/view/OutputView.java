package lotto.view;

import java.util.List;
import lotto.message.RunMessage;

public class OutputView {

    public static void printLottoNumbers(List<Integer> numbers){
        System.out.println(numbers.toString());
    }

    public static void printLottoCount(int amount){
        System.out.printf(RunMessage.PRINT_LOTTO_COUNT.getMessage(), amount);
    }
}
