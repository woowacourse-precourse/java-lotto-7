package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = input();
        validate(input);
        return toInt(input);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = input();
        validateNotEmpty(input);
        String[] splitNumbers = split(input);
        validateIsNumber(splitNumbers);
        return toInts(splitNumbers);
    }

    public int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = input();
        validate(input);
        return toInt(input);
    }

    public void validate(String input) {
        validateNotEmpty(input);
        validateIsNumber(input);
    }

    private String input() {
        return Console.readLine();
    }

    private void validateNotEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어 있습니다.");
        }
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private String[] split(String input) {
        return input.split(",");
    }

    private void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    private void validateIsNumber(String[] strings) {
        try {
            for (String string : strings) {
                validateIsNumber(string);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private List<Integer> toInts(String[] strings) {
        List<Integer> integers = new ArrayList<>();
        for (String string : strings) {
            integers.add(Integer.parseInt(string));
        }
        return integers;
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }
}
