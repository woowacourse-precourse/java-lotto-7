package lotto;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.utils.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import lotto.utils.ErrorMessage;

class LottoTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
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
        assertEquals(ErrorMessage.INVALID_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    void 금액이_1000_미만일_때_예외발생() {
        String input = "500";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInputPurchaseAmount(input);
        });
        assertEquals(ErrorMessage.PURCHASE_AMOUNT_TOO_LOW.getMessage(), exception.getMessage());
    }

    @Test
    void 구입금액이_1000원_단위로_떨어지지_않을_때_예외발생() {
        String input = "1500";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInputPurchaseAmount(input);
        });
        assertEquals(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE.getMessage(), exception.getMessage());
    }

    @Test
    void 로또_번호가_6개가_아니면_예외발생() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(numbers);
        });
        assertEquals(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage(), exception.getMessage());
    }

    @Test
    void 중복이_있을_때_예외발생() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(numbers);
        });
        assertEquals(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    void 번호가_범위를_벗어나면_예외발생() {
        List<Integer> numbers = Arrays.asList(0, 2, 5, 10, 50, 100);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(numbers);
        });
        assertEquals(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    void 유효한_로또번호일_경우_정상생성() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @Test
    void 보너스_번호가_범위를_벗어나면_예외발생() {
        String inputBonusNumber = "50";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInputBonusNumber(inputBonusNumber, winningNumbers);
        });
        assertEquals(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    void 보너스_번호가_당첨번호와_중복되면_예외발생() {
        String inputBonusNumber = "5";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInputBonusNumber(inputBonusNumber, winningNumbers);
        });
        assertEquals(ErrorMessage.DUPLICATE_BONUS_NUMBER_WITH_WINNING.getMessage(), exception.getMessage());
    }
}
