package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputProcessorTest {

    InputProcessor inputProcessor = new InputProcessor();

    @Test
    @DisplayName("구입 금액 숫자 입력 테스트")
    void processPriceNumberTest() {
        assertThatThrownBy(() ->
                inputProcessor.processPrice("aaa")).isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 구입금액은 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("구입 금액 음수 입력 테스트")
    void processPriceNegativeTest() {
        assertThatThrownBy(() ->
                inputProcessor.processPrice("-8000")).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 음수를 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("구입 금액 입력 단위 테스트")
    void processPriceThousandTest() {
        assertThatThrownBy(() ->
                inputProcessor.processPrice("1111")).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 구입금액의 단위는 1000입니다.");
    }

    @Test
    @DisplayName("당첨 번호 입력 중복 테스트")
    void processVictoryNumberDuplicateTest() {
        assertThatThrownBy(() ->
                inputProcessor.processVictoryNumber("1,2,3,4,5,4")).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 당첨 번호는 중복되어서는 안됩니다.");
    }

    @Test
    @DisplayName("당첨 번호 입력 범위 테스트")
    void processVictoryNumberRangeTest() {
        assertThatThrownBy(() ->
                inputProcessor.processVictoryNumber("1,2,3,4,5,46")).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 당첨 번호는 1과 45사이의 숫자여야 합니다.");
        assertThatThrownBy(() ->
                inputProcessor.processVictoryNumber("-1,2,3,4,5,45")).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 당첨 번호는 1과 45사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호 입력 사이즈 테스트")
    void processVictoryNumberSizeTest() {
        assertThatThrownBy(() ->
                inputProcessor.processVictoryNumber("1,2,3,4,5,6,7")).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호 당첨 번호 중복 테스트")
    void processBonusNumberDuplicateTest() {
        inputProcessor.processVictoryNumber("1,2,3,4,5,6");
        assertThatThrownBy(() ->
                inputProcessor.processBonusNumber("6")).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 보너스 번호와 당첨 번호는 중복되어서 안됩니다.");
    }

    @Test
    @DisplayName("보너스 번호 입력 범위 테스트")
    void processBonusNumberRangeTest() {
        assertThatThrownBy(() ->
                inputProcessor.processBonusNumber("46")).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 보너스 번호는 1과 45사이의 숫자여야 합니다.");

        assertThatThrownBy(() ->
                inputProcessor.processBonusNumber("0")).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 보너스 번호는 1과 45사이의 숫자여야 합니다.");
    }
}