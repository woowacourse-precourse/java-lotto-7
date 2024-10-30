package lotto;

import lotto.model.Lotto;
import lotto.utils.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_금액_정상처리() {
        String input = "1000";
        assertDoesNotThrow(() -> validator.validateInputPurchaseAmount(input));
    }

    @Test
    void 숫자가_아닐_때_예외발생() {
        String input = "Faker";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInputPurchaseAmount(input);
        });
        assertEquals("숫자만 입력할 수 있습니다.", exception.getMessage());
    }

    @Test
    void 금액이_1000_미만일_때_예외발생() {
        String input = "500";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            validator.validateInputPurchaseAmount(input);
        });
        assertEquals("1000 이상의 금액을 입력해야 합니다.", exception.getMessage());
    }


}
