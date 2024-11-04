package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {


    private static LottoResult createLottoResult() {
        Lotto givenLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto givenLotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto givenLotto3 = new Lotto(List.of(3, 4, 5, 6, 7, 8));

        Lotto givenLotto4 = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        Lotto givenLotto5 = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        Lotto givenLotto6 = new Lotto(List.of(6, 7, 8, 9, 10, 11));
        Lotto givenLotto7 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        List<Lotto> givenLottos = List.of(givenLotto1, givenLotto2, givenLotto3, givenLotto4, givenLotto5, givenLotto6,
                givenLotto7);

        WinningLotto givenWinningLotto = new WinningLotto(List.of(4, 5, 6, 7, 8, 9), 10);

        return LottoResult.of(givenLottos, givenWinningLotto);
    }

    @Test
    @DisplayName("로또의 결과가 정상적으로 생성된다.")
    void test() {
        LottoResult lottoResult = createLottoResult();

        assertEquals(lottoResult.getCount(Rank.FIRST), 1);
        assertEquals(lottoResult.getCount(Rank.SECOND), 1);
        assertEquals(lottoResult.getCount(Rank.THIRD), 1);
        assertEquals(lottoResult.getCount(Rank.FOURTH), 2);
        assertEquals(lottoResult.getCount(Rank.FIFTH), 2);
        assertEquals(lottoResult.getCount(Rank.NONE), 0);
    }

    @Test
    @DisplayName("로또의 이익률이 정상적으로 표시된다.")
    void calculateProfitRate() {
        LottoResult lottoResult = createLottoResult();

        double expected = 29023000;

        double result = lottoResult.calculateProfitRate(7000);

        assertEquals(expected, result);
    }
}
