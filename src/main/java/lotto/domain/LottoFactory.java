package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.error.ErrorCode;

public class LottoFactory {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {
        List<Integer> numbersInRange = Randoms
                .pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        validate(numbersInRange);
        Collections.sort(numbersInRange);
        return new Lotto(numbersInRange);
    }

    private static void validate(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplicated(numbers);
    }

    private static void validateDuplicated(List<Integer> numbers) {
        boolean isDuplicated = numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE;
        if (isDuplicated) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean isOverRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);
        if (isOverRange) {
            throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE.getMessage());
        }
    }
}
