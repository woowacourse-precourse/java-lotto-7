package lotto;

import static lotto.provider.LottoProvider.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.answer.Answer;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateLotto(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateLotto(List<Integer> lottoNumbers) {
        HashSet<Integer> nonDuplicateLottoNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복을 허용하지 않습니다.");
        }
    }

    private void validateLottoNumberRange(List<Integer> lottoNumbers) {
        boolean isInRange = lottoNumbers.stream()
            .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);

        if (!isInRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 범위를 확인해주세요");
        }
    }
    public void printLottoNumbers() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
