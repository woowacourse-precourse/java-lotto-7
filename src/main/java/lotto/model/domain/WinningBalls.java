package lotto.model.domain;

import java.util.List;

public class WinningBalls {

    private final LottoNumbers lottoNumbers;

    public WinningBalls(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public boolean isDistinct(int number) {
        long duplicatingCount = lottoNumbers.getNumbers().stream()
                .filter(num -> num == number)
                .count();

        return duplicatingCount == 0;
    }

    public int getSameNumberCount(Lotto lotto) {
        return (int) this.lottoNumbers.getNumbers().stream()
                .filter(lotto::hasNumber)
                .count();
    }

    protected List<Integer> getNumbers() {
        return this.lottoNumbers.getNumbers();
    }
}
