package lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @MethodSource("lotto.parameterizedTest.MethodSource#generateNormalLottoNumber")
    void 모든_검증에_통과하여_정상적으로_생성된다(Integer number) {
        // given

        // when
        BonusNumber bonusNumber = new BonusNumber(number);

        // then
        assertThat(bonusNumber.number()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void validateInRange_보너스_번호의_범위가_맞지_않아_검증에_실패한다(Integer number) {
        // given

        // when

        // then
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
    }
}