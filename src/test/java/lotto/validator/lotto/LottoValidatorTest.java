package lotto.validator.lotto;

import lotto.error.lotto.LottoErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {

    @DisplayName("구입금액을 위한 입력은 양수여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    void 구입금액_양수_입력값_테스트(String purchaseAmount) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        lottoValidator.validatePurchaseAmount(purchaseAmount);
    }

    @DisplayName("구입금액을 위한 입력이 양수외의 값은 들어올 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000a", "b", "1000 "})
    void 구입금액_양수_외_입력값_테스트(String purchaseAmount) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validatePurchaseAmount(purchaseAmount);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INPUT_DATA_IS_NOT_POSITIVE);
    }

    @DisplayName("구입금액은 정책에 맞춘 단위어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    void 구입금액_정책_테스트(String purchaseAmount) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        lottoValidator.validatePurchaseAmount(purchaseAmount);
    }

    @DisplayName("정책에 맞지 않는 구입금액은 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "100"})
    void 구입금액_정책_외_테스트(String purchaseAmount) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validatePurchaseAmount(purchaseAmount);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INVALID_PURCHASE_POLICY);
    }
}
