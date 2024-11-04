package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputSixNumbers {
    private static final String EMPTY_INPUT_ERROR = "[ERROR] 번호를 입력해주세요.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 번호는 숫자로만 입력해주세요.";
    private static final String MISSING_NUMBER_ERROR = "[ERROR] 쉼표 사이에 번호가 없습니다.";
    private static final String LAST_COMMA_ERROR = "[ERROR] 마지막에 쉼표가 포함되어 있습니다.";

    public Lotto inputLottoNumbers() {
        List<Integer> numbers;

        while (true) {
            System.out.println("로또 번호 6개를 입력하세요. : ");
            String input = Console.readLine();

            try {
                numbers = parseInput(input);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }

        String[] splitNumbers = input.split(",");

        for (String splitNumber : splitNumbers) {
            String trimmedNumber = splitNumber.trim();
            if (trimmedNumber.isEmpty()) {
                throw new IllegalArgumentException(MISSING_NUMBER_ERROR);
            }
            try {
                int number = Integer.parseInt(trimmedNumber);
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR);
            }
        }

        if (input.endsWith(",")) {
            throw new IllegalArgumentException(LAST_COMMA_ERROR);
        }

        Collections.sort(numbers);
        return numbers;
    }
}