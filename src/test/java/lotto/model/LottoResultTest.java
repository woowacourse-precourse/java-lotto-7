package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private LottoResult lottoResult;

    @Test
    @DisplayName("해당 enum이 잘 초기화 되고 getter들이 동작한다.")
    void initializeTest(){
        assertEquals("3개 일치", LottoResult.FIFTH.getResult());
        assertEquals(5000, LottoResult.FIFTH.getPrice());
        assertEquals(3, LottoResult.FIFTH.getCount());

        // FOURTH 상수 테스트
        assertEquals("4개 일치", LottoResult.FOURTH.getResult());
        assertEquals(50000, LottoResult.FOURTH.getPrice());
        assertEquals(4, LottoResult.FOURTH.getCount());

        // THIRD 상수 테스트
        assertEquals("5개 일치", LottoResult.THIRD.getResult());
        assertEquals(1500000, LottoResult.THIRD.getPrice());
        assertEquals(5, LottoResult.THIRD.getCount());

        // SECOND 상수 테스트
        assertEquals("5개 일치, 보너스 볼 일치", LottoResult.SECOND.getResult());
        assertEquals(30000000, LottoResult.SECOND.getPrice());
        assertEquals(5, LottoResult.SECOND.getCount());

        // FIRST 상수 테스트
        assertEquals("6개 일치", LottoResult.FIRST.getResult());
        assertEquals(2000000000, LottoResult.FIRST.getPrice());
        assertEquals(6, LottoResult.FIRST.getCount());

        // NONE 상수 테스트
        assertEquals("3개 미만 일치", LottoResult.NONE.getResult());
        assertEquals(0, LottoResult.NONE.getPrice());
        assertEquals(0, LottoResult.NONE.getCount());
    }

}
