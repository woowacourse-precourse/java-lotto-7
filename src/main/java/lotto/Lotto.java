package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void printLotto() {
        String lottoPrintMessage = "[" +
                numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
                + "]";
        System.out.println(lottoPrintMessage);
    }

}
