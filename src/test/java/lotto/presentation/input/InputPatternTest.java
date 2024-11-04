package lotto.presentation.input;

import static lotto.presentation.input.InputPattern.isInvalidBonusNumber;
import static lotto.presentation.input.InputPattern.isInvalidPurchaseAmount;
import static lotto.presentation.input.InputPattern.isInvalidWinningNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputPatternTest {

    @DisplayName("구입금액 입력에 쉼표 외 구분자 사용, 세 자리수 구분 규격 위반, 다른 화폐 단위를 사용할 수 없다.")
    @ValueSource(strings = {"10,00", "1000won", "1/000원", "10,0000원"})
    @ParameterizedTest
    void 구입금액_패턴_통과_실패(String input) {
        assertThat(isInvalidPurchaseAmount(input)).isTrue();
    }

    @DisplayName("구입금액 입력은 쉼표로 구분 가능하고, 원화 단위를 붙일 수 있다.")
    @ValueSource(strings = {"1000", "1,000", "1,000원", "100,000원"})
    @ParameterizedTest
    void 구입금액_패턴_통과(String input) {
        assertThat(isInvalidPurchaseAmount(input)).isFalse();
    }

    @DisplayName("당첨번호 입력에 쉼표 구분자 사이 한 칸 초과 공백, 다른 구분자를 사용할 수 없다.")
    @ValueSource(strings = {"1.2.3.4.5.6", "1,  2,  3,  4,  5,  6"})
    @ParameterizedTest
    void 당첨번호_패턴_통과_실패(String input) {
        assertThat(isInvalidWinningNumbers(input)).isTrue();
    }

    @DisplayName("당첨번호 입력에 쉼표 구분자 사이 한 칸 공백을 사용할 수 있다.")
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6"})
    @ParameterizedTest
    void 당첨번호_패턴_통과(String input) {
        assertThat(isInvalidWinningNumbers(input)).isFalse();
    }

    @DisplayName("보너스번호 입력에 음수는 올 수 없다.")
    @Test
    void 보너스번호_패턴_통과_실패() {
        assertThat(isInvalidBonusNumber("-1")).isTrue();
    }

    @DisplayName("보너스번호 입력에 양수만 사용할 수 있다.")
    @ValueSource(strings = {"0", "1", "45", "46"})
    @ParameterizedTest
    void 보너스번호_패턴_통과(String input) {
        assertThat(isInvalidBonusNumber(input)).isFalse();
    }

}
