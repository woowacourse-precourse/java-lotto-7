package lotto.model.draw_numbers;

import lotto.model.draw_numbers.builder.DrawNumbersBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DrawNumbersBuilderTest {

    @ParameterizedTest
    @MethodSource("provideDuplicate")
    void duplicateNumberTest(String winningNumbers, String bonusNumber) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                buildLottoResult(winningNumbers, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("provideExceedRange")
    void ExceedRangeNumberTest(String winningNumbers, String bonusNumber) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                buildLottoResult(winningNumbers, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("provideNonNumber")
    void NonNumberTest(String winningNumbers, String bonusNumber) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                buildLottoResult(winningNumbers, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("provideInsufficient")
    void InsufficientNumberTest(String winningNumbers, String bonusNumber) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                buildLottoResult(winningNumbers, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("provideExcess")
    void ExcessNumberCountTest(String winningNumbers, String bonusNumber) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                buildLottoResult(winningNumbers, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("provideWrongFormat")
    void WrongFormatNumberTest(String winningNumbers, String bonusNumber) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                buildLottoResult(winningNumbers, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("provideEmpty")
    void EmptyNumberTest(String winningNumbers, String bonusNumber) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                buildLottoResult(winningNumbers, bonusNumber));
    }

    static Stream<Arguments> provideDuplicate() {
        return Stream.of(
                makeArguments("1,2,3,4,5,5",     "6"),   // 당첨 번호 중복
                makeArguments("1,2,3,4,5,6",     "6")    // 보너스 번호 중복
        );
    }

    static Stream<Arguments> provideExceedRange() {
        return Stream.of(
                makeArguments("1,2,3,4,5,46",    "6"),   // 당첨 번호 범위 초과
                makeArguments("-1,2,3,4,5,6",    "7"),   // 당첨 번호 범위 초과
                makeArguments("1,2,3,4,5,6",     "-1"),  // 보너스 번호 범위 초과
                makeArguments("1,2,3,4,5,6",     "46")   // 보너스 번호 범위 초과
        );
    }

    static Stream<Arguments> provideNonNumber() {
        return Stream.of(
                makeArguments("1,2,3,4,5,n",     "7"),   // 당첨 번호 문자 입력
                makeArguments("1,2,3,4,5,6",     "n")    // 보너스 번호 문자 입력
        );
    }

    static Stream<Arguments> provideInsufficient() {
        return Stream.of(
                makeArguments("1,2,3,4,5,",      "6")    // 당첨 번호 개수 부족
        );
    }

    static Stream<Arguments> provideExcess() {
        return Stream.of(
                makeArguments("1,2,3,4,5,6,7", "8")    // 당첨 번호 개수 초과
        );
    }

    static Stream<Arguments> provideWrongFormat() {
        return Stream.of(
                makeArguments("1,2,3,4,5,6,",    "7"),     // 당첨 번호 잘못된 형식
                makeArguments("1,2,3,4,5,  6",    "7"),    // 당첨 번호 잘못된 형식
                makeArguments("1,2,3,4,5,6",     "7,"),    // 보너스 번호 잘못된 형식
                makeArguments("1,2,3,4,5,6",     "7   ")   // 보너스 번호 잘못된 형식
        );
    }

    static Stream<Arguments> provideEmpty() {
        return Stream.of(
                makeArguments("",                "7"),   // 당첨 번호 빈 형식
                makeArguments("1,2,3,4,5,6",     "")     // 보너스 번호 빈 형식
        );
    }

    private static void buildLottoResult(String winningNumbers, String bonusNumber) {
        DrawNumbersBuilder builder = new DrawNumbersBuilder();

        DrawNumbers drawNumbers = builder.winningNumbers(winningNumbers)
                .bonusNumber( bonusNumber)
                .build();
    }

    private static Arguments makeArguments(String winningNumber, String bonusNumber) {
        return Arguments.of(winningNumber, bonusNumber);
    }
}
