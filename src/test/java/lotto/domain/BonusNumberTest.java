package lotto.domain;

import lotto.exception.lotto.LottoNumberDuplicateException;
import lotto.exception.lotto.LottoNumberRangeException;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("보너스 번호 검증")
class BonusNumberTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("1~45 사이의 당첨 번호와 중복되지 않는 숫자일 때")
    void validateBonusNumber() {
        assertThat(BonusNumber.of(winningLotto, 45)).isInstanceOf(BonusNumber.class);
    }

    @ParameterizedTest(name = "{index} : {3}")
    @MethodSource("generateExceptionData")
    @DisplayName("예외 검증")
    void invalidBonusNumber(int inputBonusNumber, Class expectedExceptionClass,
                            String errorMessage, String message) {
        assertThatThrownBy(() -> {
            BonusNumber.of(winningLotto, inputBonusNumber);
        }).isInstanceOf(expectedExceptionClass)
                .hasMessage(errorMessage);
    }

    static Stream<Arguments> generateExceptionData() {
        return Stream.of(
                Arguments.of(0, LottoNumberRangeException.class
                        , ErrorMessage.LOTTO_NUMBER_RANGE, "1~45 사이가 아닐 때"),
                Arguments.of(46, LottoNumberRangeException.class
                        , ErrorMessage.LOTTO_NUMBER_RANGE, "1~45 사이가 아닐 때"),
                Arguments.of(6, LottoNumberDuplicateException.class,
                        ErrorMessage.LOTTO_NUMBER_DUPLICATE, "당첨 번호와 중복될 때")
        );
    }
}