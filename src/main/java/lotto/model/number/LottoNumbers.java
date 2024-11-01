package lotto.model.number;

import lotto.model.number_generator.RandomNumberGenerator;

import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers generateBy(int size, RandomNumberGenerator randomNumberGenerator) {
        List<Integer> numbers = randomNumberGenerator.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, size);

        return new LottoNumbers(numbers.stream()
                .map(LottoNumber::new)
                .toList());
    }

    public List<Integer> mapToInt() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }

    public boolean hasSize(long size) {
        return lottoNumbers.size() == size;
    }

    public boolean hasUniqueElements() {
        return hasSize(lottoNumbers.stream()
                .distinct()
                .count()
        );
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int countMatch(LottoNumbers other) {
        return (int) lottoNumbers.stream()
                .filter(other::contains)
                .count();
    }
}
