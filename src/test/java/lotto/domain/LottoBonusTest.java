package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBonusTest {

    @DisplayName("보너스 번호 설정 테스트")
    @Test
    void 보너스_번호_설정_테스트() {
        LottoBonus lottoBonus = new LottoBonus();
        int bonusNumber = 7;
        lottoBonus.setLottoBonusNumber(bonusNumber);
        assertEquals(bonusNumber, lottoBonus.getBonusNumber());
    }
}
