package lotto.domain;

import lotto.error.NumberErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    @Test
    void 보너스번호는_문자일_수_없다() {
        //given
        String bonusNumber = "1a";

        //when & then
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 보너스번호는_1에서_45_사이여야_한다(String bonusNumber) {
        //when & then
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.NOT_ALLOWED_NUMBER.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void 정상_테스트(String bonusNumber) {
        //when & then
        assertThatCode(() -> new BonusNumber(bonusNumber))
                .doesNotThrowAnyException();
    }

    static Stream<String> provideNumbers() {
        return IntStream.rangeClosed(1, 45)
                .mapToObj(n -> String.valueOf(n));
    }
}