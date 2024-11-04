package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 유효한_금액_예외_발생_없음(){
        int purchaseAmount = 8000;
        assertThatCode(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @Test
    void 유효하지_않은_금액은_예외가_발생(){
        int purchaseAmount = 1500;
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @Test
    void validateDuplicate_로또번호_중복된_숫자_예외_발생(){
        List<Integer> numbers = List.of(1,2,3,4,5,5);
        assertThatThrownBy(() -> Validator.validateDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 중복된 숫자가 포함될 수 없습니다.");
    }

    @Test
    void validateLottoSize_로또번호가_6개_아니면_예외_발생() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> Validator.validateLottoSize(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @Test
    void validateNumberRange_로또번호_범위_초과_예외_발생() {
        int number = 46;
        assertThatThrownBy(() -> Validator.validateNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void validateBonusDuplicate_보너스번호가_당첨번호와_중복되지_않으면_예외_발생_없음() {
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        assertThatCode(() -> Validator.validateBonusDuplicate(winNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }
}