package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

    @ParameterizedTest
    @MethodSource("purchasePriceData")
    @DisplayName("정상적인 구매 금액 입력은 정수로 반환")
    void testGetPurchasePriceWithValidInput(String inputStr, int expectedResult) {
        //when
        int price = InputView.convertToInt(inputStr, "구매금액");

        //then
        assertThat(price).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", ""})
    @DisplayName("잘못된 구매 금액 입력 시 예외 발생")
    void testGetPurchasePriceWithInvalidInput(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputView.convertToInt(inputStr, "구매금액"))
                .withMessage("구매금액은(는) 정수여야합니다.");
    }

    @ParameterizedTest
    @MethodSource("bonusNumData")
    @DisplayName("정상적인 보너스 번호 입력")
    void testGetBonusNumWithValidInput(String inputStr, int expectedResult) {
        //when
        int bonusNum = InputView.convertToInt(inputStr, "보너스 번호");

        //then
        assertThat(bonusNum).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", ""})
    @DisplayName("잘못된 보너스 번호 입력 시 예외 발생")
    void testGetBonusNumWithInvalidInput(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputView.convertToInt(inputStr, "보너스 번호"))
                .withMessage("보너스 번호은(는) 정수여야합니다.");
    }

    @ParameterizedTest
    @MethodSource("winningNumsData")
    @DisplayName("정상적인 당첨 번호 입력")
    void testGetWinningNumsWithValidInput(String inputStr, List<Integer> expectedResult) {
        List<Integer> winningNums = InputView.convertToIntList(inputStr);
        assertEquals(winningNums, expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,abc", "1,  ,3", "", ","})
    @DisplayName("잘못된 당첨 번호 입력 시 예외 발생")
    void testGetWinningNumsWithInvalidInput(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputView.convertToIntList(inputStr))
                .withMessage("당첨번호는 정수여야합니다.");
    }

    static Stream<Arguments> purchasePriceData() {
        return Stream.of(
                Arguments.of("1000", 1000),
                Arguments.of("2000", 2000),
                Arguments.of("3000", 3000),
                Arguments.of("5000", 5000)
        );
    }

    static Stream<Arguments> bonusNumData() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("10", 10),
                Arguments.of("45", 45)
        );
    }

    static Stream<Arguments> winningNumsData() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("10,11,12,13,14,15", List.of(10, 11, 12, 13, 14, 15)),
                Arguments.of("20,21,22,23,24,25", List.of(20, 21, 22, 23, 24, 25))
        );
    }
}