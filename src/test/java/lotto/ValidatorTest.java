package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.ConstantMessage;
import lotto.utils.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("validateLottoNumber - 유효한 단일 번호 테스트")
    void validateLottoNumberTest() {
        validator.validateLottoNumber(5);
        assertThatThrownBy(() -> validator.validateLottoNumber(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ConstantMessage.ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
    }

    @Test
    @DisplayName("validateLottoNumber - 유효한 번호 리스트 테스트")
    void validateLottoNumberListTest() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        validator.validateLottoNumber(validNumbers);

        List<Integer> invalidNumbers = List.of(1, 2, 2, 4, 5, 6);
        assertThatThrownBy(() -> validator.validateLottoNumber(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ConstantMessage.ErrorMessage.DUPLICATED_LOTTO_VALUE.getMessage());
    }

    @Test
    @DisplayName("validateDuplicated - 중복 값 테스트")
    void validateDuplicatedTest() {
        List<Integer> values = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        validator.validateDuplicated(values, 6);

        assertThatThrownBy(() -> validator.validateDuplicated(values, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ConstantMessage.ErrorMessage.DUPLICATED_LOTTO_VALUE.getMessage());
    }

    @Test
    @DisplayName("validatePrice - 가격 유효성 테스트")
    void validatePriceTest() {
        validator.validatePrice(3000);

        assertThatThrownBy(() -> validator.validatePrice(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ConstantMessage.ErrorMessage.INVALID_PRICE.getMessage());
    }
}
