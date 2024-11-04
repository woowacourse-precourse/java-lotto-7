package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoSellerTest {
    private final LottoSeller lottoSeller = new LottoSeller();

    @ParameterizedTest
    @MethodSource("lottoCountData")
    @DisplayName("1000원 단위의 정상 입력 시 로또 개수 반환")
    void testConvertToCountWithValidInput(int inputPrice, int expectedResult) {
        // when
        int lottoCount = lottoSeller.convertToCount(inputPrice);

        // then
        assertEquals(lottoCount,expectedResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 2500, 999})
    @DisplayName("1000원 단위가 아닌 입력 시 예외 발생")
    void testConvertToCountWithInvalidInput(int inputPrice) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> lottoSeller.convertToCount(inputPrice),
                "구매금액은 1000원단위여야합니다."
        );
    }

    static Stream<Arguments> lottoCountData() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(2000, 2),
                Arguments.of(3000, 3)
        );
    }
}