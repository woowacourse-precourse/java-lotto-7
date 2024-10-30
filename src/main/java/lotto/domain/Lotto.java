package lotto.domain;

import lotto.service.LottoNumGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_NUM_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto(LottoNumGenerator lottoNumGenerator) {
        numbers = generateLottoNumbers(lottoNumGenerator);
    }

    public int countMatchingLottoNumber(Set<Integer> winningLottoNumbers) {
        Set<Integer> purchasedNumbers = new HashSet<>(numbers);
        purchasedNumbers.retainAll(winningLottoNumbers);
        return purchasedNumbers.size();
    }

    private List<Integer> generateLottoNumbers(LottoNumGenerator lottoNumGenerator) {
        return lottoNumGenerator.generateNumbers(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_NUM_COUNT);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
