package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BonusNumberTest {

    private static final Stream<Arguments> normalBonusNumberArguemts() {
        return Stream.of(
            Arguments.arguments(List.of(1,2,3,4,5,6), 7),
            Arguments.arguments(List.of(45,44,43,42,21,10), 19),
            Arguments.arguments(List.of(10,15,20,25,30,35), 23)
        );
    }

    @ParameterizedTest
    @MethodSource("normalBonusNumberArguemts")
    @DisplayName("정상 기능 테스트")
    void 정상_기능_테스트(List<Integer> winningNumbers, Integer bonusNumber) {
        assertDoesNotThrow(() -> new BonusNumber(winningNumbers, bonusNumber));
    }

    private static final Stream<Arguments> exceptionBonusNumberArguments() {
        return Stream.of(
            Arguments.arguments("당첨 번호와 중복되는 보너스 번호인 경우", List.of(1,2,3,4,5,6), 6),
            Arguments.arguments("보너스 번호가 1에서 45사이의 숫자가 아닌 경우", List.of(1,2,3,4,5,6), 47),
            Arguments.arguments("보너스 번호가 1에서 45사이의 숫자가 아닌 경우", List.of(1,2,3,4,5,6), 0),
            Arguments.arguments("보너스 번호가 1에서 45사이의 숫자가 아닌 경우", List.of(1,2,3,4,5,6), -1)
        );
    }

    @ParameterizedTest(name = "보너스 번호: {0}")
    @DisplayName("보너스 번호 예외적인 상황")
    @MethodSource("exceptionBonusNumberArguments")
    void bonusNumberExceptionTest(String caseName, List<Integer> winningNumbers, Integer bonusNumber) {
        assertThatThrownBy(()-> new BonusNumber(winningNumbers, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
