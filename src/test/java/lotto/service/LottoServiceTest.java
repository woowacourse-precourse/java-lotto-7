package lotto.service;

import lotto.exception.lotto.LottoErrorMessages;
import lotto.service.lotto.LottoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {
    private final LottoServiceImpl lottoService = new LottoServiceImpl();

    @Test
    @DisplayName("로또 구입 금액이 양수가 아닐 경우 예외가 발생한다.")
    void 로또_구입_금액이_양수가_아닐_경우_예외가_발생한다() {
        // given
        int invalidAmount = -1000;

        // when, then
        assertThatThrownBy(() -> lottoService.validateInput(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessages.INVALID_AMOUNT_NON_POSITIVE.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    void 로또_구입_금액이_1000원_단위가_아닐_경우_예외가_발생한다() {
        // given
        int invalidAmount = 800;

        // when, then
        assertThatThrownBy(() -> lottoService.validateInput(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        // given
        int invalidAmount = 2500;

        // when, then
        assertThatThrownBy(() -> lottoService.validateInput(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 정상 입력된 경우 true를 반환한다.")
    void 로또_구입_금액이_정상_입력된_경우_true를_반환한다() {
        // given
        int validAmount = 3000;

        // when, then
        assertThat(lottoService.validateInput(validAmount)).isTrue();
    }
}