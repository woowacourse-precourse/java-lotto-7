package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkEachNumbers(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 1~45 사이이 숫자인지 유효성 검사
    private static void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 6개 번호가 모두 다른지 유효성 검사
    private static void checkEachNumbers(List<Integer> numbers) {
        HashSet<Integer> eachNumbers = new HashSet<Integer>(numbers);
        if (eachNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 각각 다른 숫자여야 합니다.");
        }
    }

    // 당첨 로또 번호 입력 및 유효 판단
    public static Lotto inputWinnerLotto(String message) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            try {
                System.out.println(message);
                String numberInput = Console.readLine();
                numbers = parseNumbers(numberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Lotto(numbers);
    }

    // 입력된 번호 문자열을 정수열로 변환
    private static List<Integer> parseNumbers(String input) {
        String[] lottoWinnerNumberStringArray = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : lottoWinnerNumberStringArray) {
            int number = Integer.parseInt(numberString.trim());
            validateNumber(number);
            numbers.add(number);
        }

        validate(numbers);
        checkEachNumbers(numbers);

        return numbers;
    }

    // 메인에서 당첨번호를 불러와 사용하기위해 getNumbers 추가
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}