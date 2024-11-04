package lotto;

import lotto.errors.BonusNumberErrors;
import lotto.errors.PurchaseAmountErrors;
import lotto.errors.WinningNumbersErrors;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    PurchaseAmountErrors errorHandler1 = new PurchaseAmountErrors();
    WinningNumbersErrors errorHandler2 = new WinningNumbersErrors();
    BonusNumberErrors errorHandler3 = new BonusNumberErrors();

    @Test
    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생한다.")
    void 구입금액이_숫자가_아닐_경우_에러() {
        assertThatThrownBy(() -> errorHandler1.validateNumericPurchaseAmount("1000a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력해 주세요.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    void 구입금액이_1000원_단위가_아닐_경우_에러() {
        assertThatThrownBy(() -> errorHandler1.validatePurchaseAmountInThousands(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 미만일 경우 예외가 발생한다.")
    void 구입금액이_1000원_미만일_경우_에러() {
        assertThatThrownBy(() -> errorHandler1.validateMinimumPurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최소 구입 금액은 1000원입니다.");
    }

    @Test
    @DisplayName("구입 금액이 모든 조건을 만족할 경우 예외가 발생하지 않는다.")
    void 구입금액이_모든_조건을_만족할_경우_정상처리() {
        assertThatNoException().isThrownBy(() -> errorHandler1.errorCheck("5000"));
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어날 경우 예외가 발생한다.")
    void 로또번호가_범위를_벗어날_경우_에러() {
        assertThatThrownBy(() -> errorHandler2.validateWinningNumberRange(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    void 로또번호에_중복된_숫자가_있을_경우_에러() {
        assertThatThrownBy(() -> errorHandler2.validateWinningNumberUniqueness(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("로또번호가 6개가 아닐 경우 예외가 발생한다.")
    void 로또번호가_6개가_아닐_경우_에러() {
        assertThatThrownBy(() -> errorHandler2.validateWinningNumberSize(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 모든 조건을 만족할 경우 예외가 발생하지 않는다.")
    void 로또번호가_모든_조건을_만족할_경우_정상처리() {
        assertThatNoException().isThrownBy(() -> errorHandler2.errorCheck(List.of(1, 2, 3, 4, 5, 6)));
    }


    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    void 보너스번호가_숫자가_아닐_경우_에러() {
        assertThatThrownBy(() -> errorHandler3.validateNumericBonusNumber("7a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자만 입력해야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    void 보너스번호가_1부터_45_사이가_아닐_경우_에러() {
        assertThatThrownBy(() -> errorHandler3.validateBonusNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    void 보너스번호가_당첨번호와_중복될_경우_에러() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> errorHandler3.validateBonusNumberUniqueness(5, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 모든 조건을 만족할 경우 예외가 발생하지 않는다.")
    void 보너스번호가_모든_조건을_만족할_경우_정상처리() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatNoException().isThrownBy(() -> errorHandler3.errorCheck("7", winningNumbers));
    }
}
