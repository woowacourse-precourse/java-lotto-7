package lotto.validator;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoNumberValidatorTest {

    @Test
    @DisplayName("로또 번호가 주어진 범위(1~45)에 있지 않은 경우에 예외가 발생한다")
    void shouldThrowExceptionForInvalidLottoNumberRange() {
        // given
        Set<Integer> invalidNumbers = Set.of(1, 2, 3, 4, 5, 100);
        WinningLottoNumberValidator validator = new WinningLottoNumberValidator(invalidNumbers);

        // when & then
        assertSimpleTest(() ->
                assertThatThrownBy(validator::validateAll)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoException.INVALID_RANGE.getMessage())
        );
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니라면 예외가 발생한다")
    void shouldThrowExceptionForInvalidLottoCount() {
        // given
        Set<Integer> invalidNumbers = Set.of(1, 2, 3, 4, 5);
        WinningLottoNumberValidator validator = new WinningLottoNumberValidator(invalidNumbers);

        // when & then
        assertSimpleTest(() ->
                assertThatThrownBy(validator::validateAll)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoException.INVALID_COUNT.getMessage())
        );
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호 set 안의 숫자와 중복되면 예외가 발생한다")
    void shouldThrowExceptionForDuplicationBonusNumber() {
        // given
        Set<Integer> invalidNumbers = Set.of(1, 2, 3, 4, 5, 6);
        WinningLottoNumberValidator validator = new WinningLottoNumberValidator(invalidNumbers);
        int bonusNumber = 6;

        // when & then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateBonusNumber(bonusNumber))
                        .hasMessage(LottoException.DUPLICATE_LOTTO_NUMBER.getMessage())
        );
    }

}
