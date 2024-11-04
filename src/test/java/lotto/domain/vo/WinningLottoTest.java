package lotto.domain.vo;

import static lotto.common.constant.ErrorMessages.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.entity.Lotto;
import lotto.domain.factory.LottoFactory;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호의 중복 검증한다")
    void WinningLottoShouldBeValidOnDuplicate() {
        Lotto lotto = LottoFactory.from("1,2,3,4,5,6");
        String inputBonus = "6";

        assertThatThrownBy(() -> WinningLotto.of(lotto, inputBonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(DUPLICATED.toString());
    }
}