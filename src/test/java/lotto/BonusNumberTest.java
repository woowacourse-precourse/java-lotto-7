package lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.dto.WinningNumberDto;
import lotto.winning.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("문자와 공백 포함한 보너스 번호 입력")
    @ParameterizedTest
    @ValueSource(strings = {"", "\n"})
    void 문자_공백_보너스번호(String inputBonusNumber) {
        BonusNumber bonusNumber = new BonusNumber();
        assertThatThrownBy(() -> bonusNumber.getBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복인 보너스 번호 입력")
    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndBonus")
    void 당첨번호_중복인_보너스번호(List<Integer> winningNumbers, String inputBonusNumber) {
        WinningNumberDto.set(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber();
        assertThatThrownBy(() -> bonusNumber.getBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideWinningNumbersAndBonus() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "1"),
                Arguments.of(List.of(23, 24, 32, 39, 40, 45), "40")
        );
    }

    @DisplayName("범위 벗어난 보너스 번호 입력")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1", "1000"})
    void 범위_벗어난_보너스번호(String inputBonusNumber) {
        BonusNumber bonusNumber = new BonusNumber();
        assertThatThrownBy(() -> bonusNumber.getBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실수나 소수인 보너스 번호 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1.0", "4.4", "45.0", "33.1"})
    void 실수_소수_보너스번호(String inputBonusNumber) {
        BonusNumber bonusNumber = new BonusNumber();
        assertThatThrownBy(() -> bonusNumber.getBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1개 이상 입력 보너스 번호 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2", "44, 45"})
    void 한개_이상_보너스번호(String inputBonusNumber) {
        BonusNumber bonusNumber = new BonusNumber();
        assertThatThrownBy(() -> bonusNumber.getBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
