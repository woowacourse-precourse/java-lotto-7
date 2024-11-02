package lotto.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("로또 구입 금액 유효성 검사 - 성공 테스트")
    void validateLottoPurchaseAmount_success() {
        // given
        Integer lottoPurchaseAmount = 2000;

        // when & then
        assertThatCode(() -> Validator.validateLottoPurchaseAmount(lottoPurchaseAmount))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 구입 금액 유효성 검사: 음수 - 예외 테스트")
    void validateLottoPurchaseAmount_nonNegative() {
        // given
        Integer lottoPurchaseAmount = -1000;

        // when & then
        assertThatThrownBy(() -> Validator.validateLottoPurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 구입 금액 유효성 검사: 배수 아님 - 예외 테스트")
    void validateLottoPurchaseAmount_notMultiple() {
        // given
        Integer lottoPurchaseAmount = 2500;

        // when & then
        assertThatThrownBy(() -> Validator.validateLottoPurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 성공 테스트")
    void validateWinningTicket_success() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatCode(() -> Validator.validateWinningTicket(winningTicket))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사: 음수 포함 - 에외 테스트")
    void validateWinningTicket_nonNegative() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, -4, 5, 5);

        // when & then
        assertThatThrownBy(() -> Validator.validateWinningTicket(winningTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사: 중복된 번호 - 에외 테스트")
    void validateWinningTicket_duplicatedNumber() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> Validator.validateWinningTicket(winningTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사: 범위 초과 - 에외 테스트")
    void validateWinningTicket_exceededRange() {
        // given
        List<Integer> winningTicket = Arrays.asList(0, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> Validator.validateWinningTicket(winningTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사: 범위 미달 - 에외 테스트")
    void validateWinningTicket_insufficientRange() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> Validator.validateWinningTicket(winningTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사: 개수 초과 - 에외 테스트")
    void validateWinningTicket_exceededCount() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThatThrownBy(() -> Validator.validateWinningTicket(winningTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사: 개수 미달 - 에외 테스트")
    void validateWinningTicket_insufficientCount() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> Validator.validateWinningTicket(winningTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 성공 테스트")
    void validateBonusNumber_success() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        // when & then
        assertThatCode(() -> Validator.validateBonusNumber(winningTicket, bonusNumber))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사: 음수 - 예외 테스트")
    void validateBonusNumber_nonNegative() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = -7;

        // when & then
        assertThatThrownBy(() -> Validator.validateBonusNumber(winningTicket, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사: 당첨 번호와 중복 - 예외 테스트")
    void validateBonusNumber_duplicateWinningNumber() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 6;

        // when & then
        assertThatThrownBy(() -> Validator.validateBonusNumber(winningTicket, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사: 범위 초과 - 예외 테스트")
    void validateBonusNumber_exceededRange() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 46;

        // when & then
        assertThatThrownBy(() -> Validator.validateBonusNumber(winningTicket, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사: 범위 미달 - 예외 테스트")
    void validateBonusNumber_insufficientRange() {
        // given
        List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 0;

        // when & then
        assertThatThrownBy(() -> Validator.validateBonusNumber(winningTicket, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
