package lotto;

import lotto.io.OutputHandler;

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
    }

    // TODO: 추가 기능 구현
    public void printLotto() {
        OutputHandler.printLottos(numbers);
    }

    // 각 번호가 당첨 번호랑 몇 개 맞는지 확인
}
