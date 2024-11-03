package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private final String PRICE_PROMPT = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private final String SPLIT_DELIMITER = ",";

    public int getPrice() {
        System.out.println(PRICE_PROMPT);
        return stringToInt(Console.readLine());
    }

    public List<Integer> getWinningNumber() {
        br();
        System.out.println(WINNING_NUMBER_PROMPT);
        return stringToList(Console.readLine());
    }

    public int getBonusNumber() {
        br();
        System.out.println(BONUS_NUMBER_PROMPT);
        return stringToInt(Console.readLine());
    }

    private int stringToInt(String string) {
        return Integer.parseInt(string);
    }

    private List<Integer> stringToList(String winningNumber) {
        return Arrays.stream(winningNumber.split(SPLIT_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    void br() {
        System.out.println();
    }

}
