package lotto;

import camp.nextstep.edu.missionutils.Randoms;
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
    }

    // TODO: 추가 기능 구현

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    public List<Lotto> number_generator(int n) {
        List<Lotto> lottos = new ArrayList<>();
        while (n-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public void number_print() {
        String message = "[";
        for (int n : this.numbers) {
            message += n + ", ";
        }
        message = message.substring(0, message.length() - 2) + "]";
        System.out.println(message);
    }
}
