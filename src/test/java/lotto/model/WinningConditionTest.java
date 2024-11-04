package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class WinningConditionTest {

    @DisplayName("올바른 입력을 통해 객체 생성을 시도")
    @ParameterizedTest(name = "{0}과 {1}을 입력할 경우")
    @CsvSource({"0,true", "0,false", "5,true", "5,false"})
    void 올바른_입력을_통해_객체_생성을_시도(int matchedNumberCount, boolean isBonusNumberMatched) {
        WinningCondition actualCondition = new WinningCondition(matchedNumberCount, isBonusNumberMatched);

        assertThat(actualCondition.getMatchedNumberCount()).isEqualTo(matchedNumberCount);
        assertThat(actualCondition.isBonusNumberRequired()).isEqualTo(isBonusNumberMatched);
    }

    @DisplayName("잘못된 입력을 통해 객체 생성을 시도")
    @ParameterizedTest(name = "{0}과 {1}을 입력할 경우 : {2}")
    @MethodSource
    void 잘못된_입력을_통해_객체_생성을_시도(int matchedNumberCount, boolean isBonusNumberMatched, String expectedExceptionMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningCondition(matchedNumberCount, isBonusNumberMatched))
                .withMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> 잘못된_입력을_통해_객체_생성을_시도() {
        return Stream.of(
                Arguments.of(-10, true, WinningCondition.NOT_ZERO_OR_POSITIVE_PRICE_EXCEPTION_MESSAGE),
                Arguments.of(-10, false, WinningCondition.NOT_ZERO_OR_POSITIVE_PRICE_EXCEPTION_MESSAGE)
        );
    }

    @DisplayName("당첨 여부 판단")
    @ParameterizedTest(name = "{0}일때, ({1},{2}) 조건이라면 : 당첨 {3}")
    @MethodSource
    void 당첨_여부_판단(
            WinningCondition condition, int matchedNumberCount,
            boolean isBonusNumberMatched, boolean expectedWinningResult
    ) {
        boolean actualWinningResult = condition.checkWinning(matchedNumberCount, isBonusNumberMatched);

        assertThat(actualWinningResult).isEqualTo(expectedWinningResult);
    }

    static Stream<Arguments> 당첨_여부_판단() {
        return Stream.of(
                Arguments.of(new WinningCondition(5, false), 3, true, false),
                Arguments.of(new WinningCondition(5, false), 3, false, false),
                Arguments.of(new WinningCondition(5, false), 5, true, true),
                Arguments.of(new WinningCondition(5, false), 5, false, true),
                Arguments.of(new WinningCondition(5, true), 3, true, false),
                Arguments.of(new WinningCondition(5, true), 3, false, false),
                Arguments.of(new WinningCondition(5, true), 5, true, true),
                Arguments.of(new WinningCondition(5, true), 5, false, false)
        );
    }
}