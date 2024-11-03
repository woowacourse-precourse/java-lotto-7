package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningResultTest {

    @Test
    void matchCount와_동일한_WinningResult반환() {
        assertEquals(WinningResult.fromMatchCount("5"), WinningResult.FIVE);
    }

    @Test
    void matchCount가_WinningResult에_없음() {
        Assertions.assertThatThrownBy(() -> WinningResult.fromMatchCount("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문장만들기() {
        int num = 3;
        assertEquals(WinningResult.THREE.makeSentence(num), "3개 일치 (5,000원) - " + num + "개");
    }
}
