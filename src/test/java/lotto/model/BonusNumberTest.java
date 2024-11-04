package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.ExceptionMessage;
import lotto.constant.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BonusNumberTest {
    private static final Lotto MAIN_NUMBERS = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("입력값을 가진 객체가 생성된다.")
    void testCreateBonusNumberIfValueIsValid() {
        int value = 7;
        BonusNumber bonusNumber = BonusNumber.of(value, MAIN_NUMBERS);
        assertThat(bonusNumber.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @MethodSource("provideOutOfLottoRangeNumbers")
    @DisplayName("로또 범위가 아닌 수를 입력하면 예외가 발생한다.")
    void testThrowExceptionIfValueIsOutOfLottoRange(int value) {
        assertThatThrownBy(() -> BonusNumber.of(value, MAIN_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_INVALID_RANGE.getMessage());
    }

    private static Stream<Integer> provideOutOfLottoRangeNumbers() {
        return Stream.of(Rule.MIN_LOTTO_NUMBER - 1, Rule.MAX_LOTTO_NUMBER + 1);
    }


    @Test
    @DisplayName("메인 당첨 번호와 중복된 수를 입력하면 예외가 발생한다.")
    void testThrowExceptionIfValueIsDuplicatedWithMainNumbers() {
        int duplicatedValue = MAIN_NUMBERS.getNumbers().getFirst();
        assertThatThrownBy(() -> BonusNumber.of(duplicatedValue, MAIN_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_DUPLICATED_NUMBER.getMessage());
    }
}
