package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoWinCheckTest {
    private static final Lotto WIN_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final int BONUS_NUMBER = 7;

    private LottoWinCheck lottoWinCheck;

    @BeforeEach
    void setUp() {
        lottoWinCheck = new LottoWinCheck(new LottoWinNumbers(WIN_LOTTO, BONUS_NUMBER));
    }

    @Test
    void 일등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(1, lottoWinCheck.getWinResult(List.of(lotto)).getOrDefault(1, 0));
    }

    @Test
    void 이등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertEquals(1, lottoWinCheck.getWinResult(List.of(lotto)).getOrDefault(2, 0));
    }

    @Test
    void 삼등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        assertEquals(1, lottoWinCheck.getWinResult(List.of(lotto)).getOrDefault(3, 0));
    }

    @Test
    void 사등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        assertEquals(1, lottoWinCheck.getWinResult(List.of(lotto)).getOrDefault(4, 0));
    }

    @Test
    void 오등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertEquals(1, lottoWinCheck.getWinResult(List.of(lotto)).getOrDefault(5, 0));
    }
}
