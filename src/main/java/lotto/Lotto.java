package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        // TODO: 추가 기능 구현
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }

        for (int number : numbers)
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호 6개를 입력하세요 (예: 1,2,3,4,5,6):");
        String input = Console.readLine();
        String[] splitInput = input.split(","); // 쉼표로 구분하여 배열로 변환
        List<Integer> winningNumbers = new ArrayList<>();

        for (int i = 0; i < splitInput.length; i++) {
            String num = splitInput[i];
            winningNumbers.add(Integer.parseInt(num)); // 문자열을 정수로 변환하여 추가
        }
        return winningNumbers;
    }
}