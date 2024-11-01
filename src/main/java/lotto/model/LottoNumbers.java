package lotto.model;

import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
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
