package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    private final Validator validator = new Validator();

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1500", "-1000", "abc", ",./", "10 00"})
    void 로또_구입_금액_유효성_검증_실패_테스트(String input) {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}