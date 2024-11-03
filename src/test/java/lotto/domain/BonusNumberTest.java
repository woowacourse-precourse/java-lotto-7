package lotto.domain;

import lotto.constant.LottoErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("사용자 로또 번호에 보너스 번호가 포함되어 있는지 확인한다.")
    @Test
    void 보너스_번호_포함_여부_테스트() {
        BonusNumber bonusNumber = new BonusNumber(7, List.of(1, 2, 3, 4, 5, 6));
        Lotto userLottoWithBonus = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto userLottoWithoutBonus = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        assertThat(bonusNumber.containsBonusNumber(userLottoWithBonus)).isTrue();
        assertThat(bonusNumber.containsBonusNumber(userLottoWithoutBonus)).isFalse();
    }

    @DisplayName("당첨 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호와_보너스_번호_중복_예외_테스트() {
        assertThatThrownBy(() -> new BonusNumber(6, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessages.BONUS_NUMBER_DUPLICATE);
    }

    @DisplayName("보너스 번호가 1~45 범위 외의 숫자면 예외가 발생한다.")
    @Test
    void 범위_외의_숫자_예외_테스트() {
        assertThatThrownBy(() -> new BonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessages.NUMBER_OUT_OF_RANGE);
    }
}