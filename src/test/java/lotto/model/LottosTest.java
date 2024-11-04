package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottosTest {
    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos();
        Winning.initCount();
    }

    @Test
    void 넘긴_List로_lotto_만들고_put_테스트() {
        lottos.allocateLottosByRandomNumber(List.of(1, 2, 3, 4, 5, 6), Lotto::new);

        assertEquals(1, lottos.size());
    }

    @Test
    void toString_테스트() {
        lottos.allocateLottosByRandomNumber(List.of(1, 2, 3, 4, 5, 6), Lotto::new);
        lottos.allocateLottosByRandomNumber(List.of(1, 2, 3, 4, 5, 6), Lotto::new);
        lottos.allocateLottosByRandomNumber(List.of(1, 2, 3, 4, 5, 6), Lotto::new);

        String string = lottos.toStringAllLottoNumber();

        assertEquals("[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n", string);
    }

    @Test
    void 수익률_둘째_소수점자리_반올림_확인() {
        lottos.allocateLottosByRandomNumber(List.of(1, 2, 3, 4, 5, 6), Lotto::new);
    }

    @Test
    void 로또_번호가_당첨_번호_count_테스트() {
        Lotto lotto = lottos.allocateLottosByRandomNumber(List.of(1, 2, 3, 4, 5, 6), Lotto::new);

        lottos.setByCorrectCount(List.of(1, 2, 3, 8, 8, 9), 10);

        Winning winning = lottos.getWinning(lotto);

        assertEquals(Winning.THREE, winning);

        lottos.setByCorrectCount(List.of(1, 2, 3, 4, 5, 9), 6);

        winning = lottos.getWinning(lotto);

        assertEquals(Winning.FIVE_BONUS, winning);
    }

    @Test
    void 수익률_계산_테스트() {
        lottos.allocateLottosByRandomNumber(List.of(1, 2, 3, 4, 5, 6), Lotto::new);

        lottos.setByCorrectCount(List.of(1, 2, 3, 8, 8, 9), 10);
        LottoValue lottoValue = new LottoValue(BigDecimal.valueOf(5000));

        BigDecimal winningRate = lottos.calculateWinningRate(lottoValue.lottoPrice());

        assertEquals(100, winningRate.intValue());

        lottoValue = new LottoValue(BigDecimal.valueOf(8000));

        winningRate = lottos.calculateWinningRate(lottoValue.lottoPrice());

        assertEquals(62.5, winningRate.doubleValue());
    }
}