package lotto.domain.lottos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.domain.number.RandomLottoNumberMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomLottosTest {
    private RandomLottos randomLottos;

    @BeforeEach
    void setUp() {
        randomLottos = new RandomLottos(new RandomLottoNumberMaker());
    }

    @Test
    void 랜덤_로또가_생성되지_않았을_떄() {
        assertTrue(randomLottos.isEmptyRandomLotto());
    }

}