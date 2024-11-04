package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.converter.validator.LottoMoneyValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoValidator 테스트")
public class LottoMoneyValidatorTest {

    private LottoMoneyValidator lottoMoneyValidator;

    @BeforeEach
    void setUp() {
        lottoMoneyValidator = new LottoMoneyValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"14001", "-1000", "0"})
    void 구입금액은_양수이고_1000원으로_나누어_떨어져야_한다(String money) {

        //when & then
        assertThatThrownBy(() -> lottoMoneyValidator.validate(money))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
