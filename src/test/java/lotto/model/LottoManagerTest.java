package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    @Test
    @DisplayName("구입 가능한 로또 개수가 올바른지 확인한다.")
    void 구입_가능한_로또_개수가_올바른지_확인한다() {
        LottoManager lottoManager = new LottoManager();
        int expect = 5;

        int numOfLotto = lottoManager.getBuyableCount(new Money(5500));

        assertEquals(numOfLotto, expect);
    }
}