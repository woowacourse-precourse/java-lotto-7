package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int MONEY = 1000;
    private static final String SEPARATOR = ",";
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public Integer inputPrice() {
        String input = Console.readLine();
        return dividePrice(input);
    }

    private Integer dividePrice(String price) {
        return Integer.parseInt(price) / MONEY;
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        return getWinningNumbers(input);
    }

    private List<Integer> getWinningNumbers(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim).map(Integer::parseInt).toList();
    }

    public Integer inputBonusNumber() {
        String winningNumbers = Console.readLine();
        return Integer.parseInt(winningNumbers);
    }
}
