package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호가_1에서_45_범위_내에_없으면_예외가_발생한다(Integer number) {
        assertThatThrownBy(() -> new LottoBonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("정상_보너스_번호")
    void 보너스_번호_정상(Integer number) {
        //when
        LottoBonusNumber bonusNumber = new LottoBonusNumber(number);

        //then
        assertThat(bonusNumber.getNumber()).isEqualTo(number);
    }

    static Stream<Arguments> 정상_보너스_번호() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(11),
                Arguments.of(21),
                Arguments.of(31),
                Arguments.of(41)
        );
    }

}
