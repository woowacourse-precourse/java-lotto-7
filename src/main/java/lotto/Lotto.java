package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해주세요.");
        }
        checkDuplicate(numbers);
        checkRange(numbers);
    }

    private void checkDuplicate(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
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

        return numbers;
    }
}