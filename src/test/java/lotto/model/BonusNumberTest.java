package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("보너스 번호가 유효 범위 내에 있고 당첨 번호와 중복되지 않으면 객체를 생성할 수 있다.")
    @ValueSource(ints = {1, 7, 15, 30, 45})
    void createBonusNumberSuccessfully(int bonusNumber) {
        // given
        List<Integer> winningNumbers = List.of(2, 3, 4, 5, 6, 8);

        // when
        BonusNumber result = BonusNumber.of(bonusNumber, winningNumbers);

        // then
        assertThat(result.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 범위(1-45) 밖에 있으면 예외를 발생시킨다.")
    @ValueSource(ints = {0, 46, 100})
    void throwExceptionWhenBonusNumberOutOfRange(int bonusNumber) {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_RANGE.message());
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 발생시킨다.")
    @ValueSource(ints = {3, 4, 5})
    void throwExceptionWhenBonusNumberIsDuplicate(int bonusNumber) {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATE.message());
    }
}
