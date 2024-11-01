package lotto.back.lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.global.exception.CustomIllegalArgumentException;
import lotto.back.lotto.config.LottoConfig;

public class Lotto {

    private final List<LottoNumber> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.SIZE.get()) {
            throw new CustomIllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", LottoConfig.SIZE.get()));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoConfig.SIZE.get()) {
            throw new CustomIllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public static Lotto generateRandomLotto() {
        return new Lotto(generateRandomNumbers());
    }

    private static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConfig.MIN_NUMBER.get(),
                LottoConfig.MAX_NUMBER.get(),
                LottoConfig.SIZE.get());
    }


    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::number)
                .toList();
    }

}
