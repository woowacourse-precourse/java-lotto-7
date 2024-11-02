package lotto.validator;

import static lotto.validator.LottoNumbersValidator.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersValidatorTest {

    @DisplayName("로또 숫자 성공 테스트")
    @Test
    void validateLottoNumber_success() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> validate(numbers));
    }
}