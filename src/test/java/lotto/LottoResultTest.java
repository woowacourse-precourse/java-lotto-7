package lotto;

import lotto.model.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    LottoResult lottoResult;

    @BeforeEach
    void setup() {
        lottoResult = new LottoResult();
    }
    @DisplayName("상금 계산기 테스트")
    @Test
    void 상금_계산기_테스트() {
        lottoResult.updateLottoRankSize(1);
    }
}
