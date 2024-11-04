package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ValidateTest {
    @Test
    @DisplayName("구입 금액 유효성 검사 - 유효한 금액")
    void isValidPurchaseAmount_valid() {
        Validate.isValidPurchaseAmount("3000"); // 정상적으로 통과해야 함
    }

    @Test
    @DisplayName("구입 금액 유효성 검사 - 유효하지 않은 금액")
    void isValidPurchaseAmount_invalid() {
        assertThatThrownBy(() -> Validate.isValidPurchaseAmount("2500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위의 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 유효한 번호")
    void isValidWinningNumbers_valid() {
        List<Integer> validWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Validate.isValidWinningNumbers(validWinningNumbers); // 정상적으로 통과해야 함
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 잘못된 개수")
    void isValidWinningNumbers_invalidCount() {
        List<Integer> invalidWinningNumbers = List.of(1, 2, 3);
        assertThatThrownBy(() -> Validate.isValidWinningNumbers(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호 유효성 검사 - 잘못된 번호")
    void isValidWinningNumber_invalid() {
        List<Integer> invalidWinningNumbers = List.of(1, 2, 3, 4, 5, 50);
        assertThatThrownBy(() -> Validate.isValidWinningNumber(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호들은 1부터 45 사이의 서로 중복되지 않는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 유효한 번호")
    void isValidBonusNumber_valid() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Validate.isValidBonusNumber(7, winningNumbers); // 정상적으로 통과해야 함
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사 - 잘못된 번호 (중복)")
    void isValidBonusNumber_invalid_duplicate() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Validate.isValidBonusNumber(6, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 유효성 검사 - 유효한 번호")
    void isValidLottoNumber_valid() {
        List<Integer> validLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Validate.isValidLottoNumber(validLottoNumbers); // 정상적으로 통과해야 함
    }

    @Test
    @DisplayName("로또 번호 유효성 검사 - 잘못된 개수")
    void isValidLottoNumber_invalidCount() {
        List<Integer> invalidLottoNumbers = List.of(1, 2, 3);
        assertThatThrownBy(() -> Validate.isValidLottoNumber(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 유효성 검사 - 중복된 번호")
    void isValidLottoNumber_hasDuplicates() {
        List<Integer> duplicateLottoNumbers = List.of(1, 2, 2, 3, 4, 5);
        assertThatThrownBy(() -> Validate.isValidLottoNumber(duplicateLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 서로 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 유효성 검사 - 범위를 초과한 번호")
    void isValidLottoNumber_outOfRange() {
        List<Integer> outOfRangeLottoNumbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> Validate.isValidLottoNumber(outOfRangeLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 서로 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
    }
}
