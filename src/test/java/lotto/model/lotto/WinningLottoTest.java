package lotto.model.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호 정상 생성 테스트")
    void validWinningNumber() {
        // given
        Lotto lottoNumber = new Lotto("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("30");

        // when
        WinningLotto winningLotto = new WinningLotto(lottoNumber, bonusNumber);

        // then
        assertNotNull(winningLotto);
    }

    @Test
    @DisplayName("보너스 번호 예외 테스트")
    void duplicatedBonusNumber() {
        // given
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("5");

        // when & then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_CONFLICT_ERROR.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("로또 번호 예외 테스트")
    @ValueSource(strings = {"1,2,a,4", "%"})
    void invalidWinningNumber(final String lottoNumber) {
        BonusNumber bonusNumber = new BonusNumber("30");

        // when & then
        assertThatThrownBy(() -> new WinningLotto(new Lotto(lottoNumber), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
