package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = getNumbersFromUser();
        sortNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers); //내부데이터의 무결성을 유지하기 위함
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는" + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
        for (Integer number : numbers) {
            if (number < MIN_NUM || number > MAX_NUM) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_NUM + "부터 " + MAX_NUM + " 사이의 숫자여야 합니다.");
            }
        }
    }

    private List<Integer> getNumbersFromUser() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputNumbers = Console.readLine();
                return parseNumbers(inputNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseNumbers(String inputNumbers) {
        String[] numberStrings = inputNumbers.split(",");
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        try {
            for (String numberString : numberStrings) {
                int number = Integer.parseInt(numberString.trim());
                numbers.add(number);
            }
            validate(numbers);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 타입입니다.");
        }

        return numbers;
    }

    private void sortNumbers() {
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
