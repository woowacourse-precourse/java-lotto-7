package lotto.util.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[CALCULATOR TEST]")
class LottoCalculatorTest {

    @DisplayName("투입 금액에 대한 올바른 1000원짜리 로또의 구매 가능 갯수를 반환한다.")
    @ParameterizedTest(name = "({index}) {0} ==> {1}")
    @CsvSource(
            value = {
                "180000,180", "8000,8", "1000,1"
            },
            delimiterString = ","
    )
    void 올바른_투입금액에_대한_로또_구매_가능_갯수를_반환한다(
            // given
            long money, long expected
    ) {
        // when
        long numberOfAbleToPurchase = LottoCalculator.getNumberOfAbleToPurchase(money);

        // then
        assertThat(numberOfAbleToPurchase).isEqualTo(expected);
    }

}