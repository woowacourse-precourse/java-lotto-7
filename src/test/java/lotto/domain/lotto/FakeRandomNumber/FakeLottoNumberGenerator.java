package lotto.domain.lotto.FakeRandomNumber;

import java.util.List;
import lotto.domain.lotto.random.CreateRandomNumbers;

public class FakeLottoNumberGenerator implements CreateRandomNumbers {

    @Override
    public List<Integer> getRandomNumbers() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
