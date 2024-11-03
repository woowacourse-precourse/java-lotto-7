package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

import lotto.common.Validator;
import lotto.constant.OutputMessage;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;

    public static final int LOTTO_NUMBER_MIN_VALUE = 1;
    public static final int LOTTO_NUMBER_MAX_VALUE = 45;
    public static final int LOTTO_NUMBER_LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.checkLottoNumbers(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return OutputMessage.LOTTO_NUMBER_FORMAT.formatted(String.join(OutputMessage.LOTTO_NUMBER_DELIMITER,
            numbers.stream().sorted().map(Object::toString).toList()));
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
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE,
            LOTTO_NUMBER_LENGTH);
        return new Lotto(lottoNumbers);
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
