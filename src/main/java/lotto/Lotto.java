package lotto;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.checkLottoNumbers(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "[%s]".formatted(String.join(", ", numbers.stream().sorted().map(Object::toString).toList()));
    }

    public static List<Lotto> generateLottos(int purchaseCount) {
        Validator.checkPositiveNumber(purchaseCount);
        List<Lotto> generatedLottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            generatedLottos.add(Lotto.generateLotto());
        }

        return generatedLottos;
    }

    public static Lotto generateLotto() {
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
