package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    List<Integer> winningNumbers;
    Lotto lotto;
    int bonus;

    @BeforeEach
    void setUp() {
        winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        bonus = 8;
    }
    @Test
    void 당첨번호와_로또번호의_일치_개수와_보너스_일치_확인_테스트() {
        LottoResult lottoResult = new LottoResult(winningNumbers, lotto, bonus);
        assertEquals(lottoResult.matchingCount(),4);
        assertTrue(lottoResult.bonusMatch());
    }

}
