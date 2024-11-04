package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = getNumbersFromUser();
        Collections.sort(this.numbers);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers); //내부데이터의 무결성을 유지하기 위함
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private List<Integer> getNumbersFromUser() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputNumbers = Console.readLine();
                return ParseNumbers(inputNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> ParseNumbers(String inputNumbers) {
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
            throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다.");
        }

        return numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

}
