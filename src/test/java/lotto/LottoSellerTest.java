package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoSellerTest {

    private LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        lottoSeller = new LottoSeller();
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"\n"})
    @EmptySource
    @NullSource
    @DisplayName("공백 입력 테스트")
    void 입력으로_공백이_들어오면_예외가_발생한다(String candidate) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottoSeller.isNumber(candidate))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_IS_EMPTY.getErrorMessage()));

    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"-1000", "1000f", "!"})
    @DisplayName("0과 양수가 아닌 로또 금액 테스트")
    void 로또_구매금액이_0_혹은_양수가_아니라면_예외가_발생한다(String candidate) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottoSeller.isNumber(candidate))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_NOT_POSITIVE_NUMBER.getErrorMessage()));

    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"0", "1000", "1001", "1000000"})
    @DisplayName("0 혹은 양수인 로또 금액 테스트")
    void 로또_구매금액이_0_혹은_양수라면_정상동작한다(String candidate) {
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> lottoSeller.isNumber(candidate)));
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"10001", "10", "0"})
    @DisplayName("구매금액이 1000의 배수가 아닌 테스트")
    void 로또_구매금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다(String candidate) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottoSeller.cashValidate(candidate))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_NOT_DIVISIBLE_BY_THOUSAND.getErrorMessage()));

        assertEquals(0, lottoSeller.getLottoNumber());
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"1000", "2000", "100000"})
    @DisplayName("구매금액이 1000의 배수인 테스트")
    void 로또_구매금액이_1000으로_나누어_떨어지면_정상동작한다(String candidate) {
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> lottoSeller.cashValidate(candidate)));
        assertFalse(lottoSeller.getLottoNumber()== 0);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"1000", "2000"})
    @DisplayName("로또 출력 테스트")
    void 로또를_구매하면_형식에_맞게_출력한다(String candidate){
        lottoSeller.cashValidate(candidate);
        lottoSeller.buyLotto();

        assertSimpleTest(()->
                assertThat(lottoSeller.printLotto()
                        .matches("\\d+개를 구매했습니다.\\n\\[\\d+(, \\d+){5}\\]\\n")));
    }
}
