package lotto;

import static camp.nextstep.edu.missionutils.Randoms.*;

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

    @Override
    public String toString() {
        return "[%s]".formatted(String.join(", ", numbers.stream().sorted().map(Object::toString).toList()));
    }

    public static List<Lotto> generateLottos(long purchaseCount) {
        List<Lotto> generatedLottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            generatedLottos.add(Lotto.generateLotto());
        }

        return generatedLottos;
    }

    private static Lotto generateLotto() {
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}
