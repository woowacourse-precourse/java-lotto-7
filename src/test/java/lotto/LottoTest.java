package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.InputNumberException;
import lotto.exception.PurchaseException;
import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.validator.LottoBonusNumberValidator;
import lotto.validator.LottoPurchaseValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("구입금액이 비어있으면 예외가 발생한다.")
    @Test
    void 구입금액이_비어있으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validateAndParse(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseException.EMPTY_INPUT.getMessage());
    }

    @DisplayName("구입금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void 구입금액이_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validateAndParse("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseException.INVALID_FORMAT.getMessage());
    }

    @DisplayName("구입금액이 int 범위를 초과하면 예외가 발생한다.")
    @Test
    void 구입금액이_int_범위를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validateAndParse("3000000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseException.OUT_OF_INT_RANGE.getMessage());
    }

    @DisplayName("구입금액이 0 이하이면 예외가 발생한다.")
    @Test
    void 구입금액이_0_이하면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseException.NON_POSITIVE_AMOUNT.getMessage());
    }

    @DisplayName("구입금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 입력값이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseException.INVALID_UNIT.getMessage());
    }

    @DisplayName("유효한 구입금액이 입력되면 LottoPurchase 객체가 정상적으로 생성된다.")
    @Test
    void 유효한_구입_금액이_입력되면_LottoPurchase_객체가_정상적으로_생성된다() {
        int validAmount = 5000;
        LottoPurchase lottoPurchase = new LottoPurchase(validAmount);
        assertThat(lottoPurchase).isNotNull();
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.INVALID_LENGTH.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.DUPLICATE_NUMBERS.getMessage());
    }

    @DisplayName("보너스 번호가 비어있을 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_비어있을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoBonusNumberValidator.validateAndParse("", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.EMPTY_INPUT.getMessage());
    }

    @DisplayName("보너스 번호가 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_정수가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoBonusNumberValidator.validateAndParse("abc", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.INVALID_FORMAT.getMessage());
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어날_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoBonusNumberValidator.validateAndParse("46", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.INVALID_RANGE.getMessage());

        assertThatThrownBy(() -> LottoBonusNumberValidator.validateAndParse("0", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.INVALID_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoBonusNumberValidator.validateAndParse("3", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.DUPLICATE_NUMBER_WITH_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("유효한 보너스 번호가 입력될 경우 검증에 통과한다.")
    @Test
    void 유효한_보너스_번호가_입력될_경우_검증에_통과한다() {
        int validBonusNumber = LottoBonusNumberValidator.validateAndParse("7", List.of(1, 2, 3, 4, 5, 6));
        assertThat(validBonusNumber).isEqualTo(7);
    }
}
