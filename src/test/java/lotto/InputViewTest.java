package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    InputView inputView = new InputView();

    @ParameterizedTest
    @DisplayName("구입금액 입력 예외 발생")
    @ValueSource(strings = {"1500", "-3000", "abcd", "500", "0", " ", ""})
    void checkAmount(String input) {
        assertThatThrownBy(() -> inputView.checkAmount(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("\\[ERROR] 구입금액은 1000원 단위로 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 입력 예외 발생")
    @ValueSource(strings = {"0", "46", "a", "-1", "", " "})
    void checkInputLottoNumbers(String input) {
        assertThatThrownBy(() -> inputView.checkWinningLottoNumbers(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("\\[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 입력 예외 발생")
    @ValueSource(strings = {"0", "46", "a", "-1", "1,2", " ", ""})
    void checkInputBonusNumbers(String input) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> inputView.checkInputBonusNumber(input, lotto)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageMatching("\\[ERROR] 보너스 번호는 1부터 45 사이의 숫자 중 하나를 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 로또 번호가 중복일시 예외 발생")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void checkDuplicateBonusNumbers(String input) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> inputView.checkInputBonusNumber(input, lotto)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageMatching("\\[ERROR] 보너스 번호는 로또와 중복되지 않는 숫자여야 합니다.");
    }

}