package lotto.Random;

import java.util.List;

public class TestLottoNumberGenerator implements RandomGenerator{
    private List<Integer> lottoNumbers;

    public TestLottoNumberGenerator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<Integer> getRandomNumber() {
        return lottoNumbers;
    }
}
