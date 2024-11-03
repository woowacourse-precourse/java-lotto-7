package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputViewImpl implements InputView {

    public static final String DELIMITER = ",";

    @Override
    public String userInput() {
        System.out.print("구매 금액을 입력하세요: ");
        return Console.readLine();
    }

    @Override
    public List<Integer> lottoWinningNumbers() {
        return convertStringsToIntegers(splitNumbers(winningNumbersInput()));
    }

    @Override
    public String bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요. ");
        return Console.readLine();
    }

    private String winningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private String[] splitNumbers(String input) {
        return input.split(DELIMITER);
    }

    private List<Integer> convertStringsToIntegers(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
