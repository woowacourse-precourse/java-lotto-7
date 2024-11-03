package lotto.model.number;

import lotto.model.exception.LottoNumberInvalidException;
import lotto.model.number_generator.RandomNumberGenerator;

import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(List<LottoNumber> numbers) {
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers generateBy(int size, RandomNumberGenerator randomNumberGenerator) {
        validateSize(size);
        List<Integer> numbers = randomNumberGenerator.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, size);

        return new LottoNumbers(numbers.stream()
                .map(LottoNumber::from)
                .toList());
    }

    private static void validateSize(int size) {
        if (size > LottoNumber.MAX_NUMBER - LottoNumber.MIN_NUMBER + 1) {
            throw LottoNumberInvalidException.tooManyLottoNumbersSize();
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumbers that = (LottoNumbers) o;

        return lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
