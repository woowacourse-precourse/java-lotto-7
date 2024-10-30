package lotto;

import lotto.model.enums.LottoResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @BeforeEach
    void setUp() {
        LottoResult.updatePrizeCount(3, false);
        LottoResult.updatePrizeCount(4, false);
        LottoResult.updatePrizeCount(5, true);
        LottoResult.updatePrizeCount(5, false);
    }

    @Test
    @DisplayName("당첨 내역이 성공적으로 조회 되는지 확인합니다.")
    void 당첨_내역_조회() {
        Assertions.assertEquals(0, LottoResult.FIRST.getCount());
        Assertions.assertEquals(1, LottoResult.SECOND.getCount());
        Assertions.assertEquals(1, LottoResult.THIRD.getCount());
        Assertions.assertEquals(1, LottoResult.FOURTH.getCount());
        Assertions.assertEquals(1, LottoResult.FIFTH.getCount());
    }


    @Test
    @DisplayName("당첨 내역이 성공적으로 초기화 되는지 확인합니다.")
    void 초기화_메서드_작동_확인() {
        LottoResult.initializeCount();

        Assertions.assertEquals(0, LottoResult.FIRST.getCount());
        Assertions.assertEquals(0, LottoResult.SECOND.getCount());
        Assertions.assertEquals(0, LottoResult.THIRD.getCount());
        Assertions.assertEquals(0, LottoResult.FOURTH.getCount());
        Assertions.assertEquals(0, LottoResult.FIFTH.getCount());
    }


}
