package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate2(numbers);
        validate3(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]로또 번호는 6개여야 합니다.");
        }
    }
    private void validate2(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                throw new IllegalArgumentException("[ERROR]중복되지 않은 당첨 숫자 6개를 입력해주세요.");
            }
        }
    }
    private void validate3(List<Integer> numbers) {
    	for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i)>45) {
                throw new IllegalArgumentException("[ERROR]45미만의 당첨 숫자 6개를 입력해주세요.");
            }
        }
    }
}
