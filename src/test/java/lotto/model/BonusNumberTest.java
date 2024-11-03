package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusNumberTest {

    @DisplayName("올바른 입력값을 통해 객체 생성을 시도")
    @Test
    void 올바른_입력값을_통해_객체_생성을_시도() {
        List<Integer> givenBannedNumbers = List.of(10, 11, 12, 13, 14, 15);
        int givenBonusNumber = 1;

        BonusNumber actualBonusNumber = new BonusNumber(givenBonusNumber, givenBannedNumbers);

        assertThat(actualBonusNumber.getNumber()).isEqualTo(givenBonusNumber);
    }

    @DisplayName("잘못된 입력값을 통해 객체 생성을 시도")
    @ParameterizedTest(name = "금액 {0}을 입력할 경우 : {1}")
    @MethodSource
    void 잘못된_금액을_통해_객체_생성을_시도(int inputNumber, List<Integer> bannedNumbers, String expectedExceptionMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(inputNumber, bannedNumbers))
                .withMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> 잘못된_금액을_통해_객체_생성을_시도() {
        List<Integer> bannedNumbers = List.of(10, 11, 12, 13, 14, 15);
        return Stream.of(
                Arguments.of(0, bannedNumbers, BonusNumber.NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE),
                Arguments.of(-1, bannedNumbers, BonusNumber.NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE),
                Arguments.of(10, bannedNumbers, BonusNumber.BANNED_NUMBER_MESSAGE),
                Arguments.of(10, null, BonusNumber.NULL_BANNED_NUMBER_EXCEPTION_MESSAGE)
        );
    }
}