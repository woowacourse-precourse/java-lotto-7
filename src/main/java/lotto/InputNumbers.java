package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputNumbers {
    public Lotto InputLottoNumbers() {
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
            throw new IllegalArgumentException("[ERROR] 로또 번호를 입력해주세요.");
        }

        String[] splitNumbers = input.split(",");

        for (String splitNumber : splitNumbers) {
            String trimmedNumber = splitNumber.trim();
            if (trimmedNumber.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 쉼표 사이에 번호가 없습니다.");
            }
            try {
                int number = Integer.parseInt(trimmedNumber);
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 번호는 숫자로만 입력해주세요.");
            }
        }

        if (input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 마지막에 쉼표가 포함되어 있습니다.");
        }

        Collections.sort(numbers);
        return numbers;
    }
}
