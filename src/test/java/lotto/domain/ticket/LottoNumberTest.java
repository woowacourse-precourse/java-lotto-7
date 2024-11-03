package lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("1~45범위가 아닌 수로 생성 시 IllegalArgumentException을 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("generateInvalidRange")
    void testThrowIllegalArgumentException(int numberValue) {
        assertThatThrownBy(() -> LottoNumber.of(numberValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateInvalidRange() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(46)
        );
    }

    @DisplayName("equals와 hashcode를 오버라이딩 하는지 확인")
    @Test
    void testEqualsAndHashCode() {
        int sameValue = 10;

        LottoNumber lottoNumber = LottoNumber.of(sameValue);
        LottoNumber another = LottoNumber.of(sameValue);

        assertThat(lottoNumber)
                .isEqualTo(another)
                .hasSameHashCodeAs(another);
    }
}