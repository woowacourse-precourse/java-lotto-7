package view;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputviewTest {

    @Test
    @DisplayName("1000원 미만의 금액 입력 시 예외 발생")
    void testPurchaseBelowMinimum() {
        Inputview inputview = new Inputview();
        assertThatThrownBy(() -> inputview.Purchase("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력한 금액이 작습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 구매금액 입력 시 예외 발생")
    void testPurchaseInvalidInput() {
        Inputview inputview = new Inputview();
        assertThatThrownBy(() -> inputview.Purchase("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자로 변환하지 못하였습니다.");
    }

    @Test
    @DisplayName("정상적인 구매 금액 입력")
    void testValidPurchase() {
        Inputview inputview = new Inputview();
        assertThat(inputview.Purchase("1000")).isEqualTo(1000);
    }

    @Test
    @DisplayName("올바른 당첨 번호 입력")
    void testValidWinningNumbers() {
        Inputview inputview = new Inputview();
        Lotto lotto = inputview.winningNumbr("1,2,3,4,5,6");
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("잘못된 형식의 당첨 번호 입력 시 예외 발생")
    void testInvalidWinningNumberFormat() {
        Inputview inputview = new Inputview();
        assertThatThrownBy(() -> inputview.winningNumbr("1,2,3,a,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자로 변환하지 못하였습니다.");
    }

    @Test
    @DisplayName("범위를 벗어난 보너스 번호 입력 시 예외 발생")
    void testBonusNumberOutOfRange() {
        Inputview inputview = new Inputview();
        assertThatThrownBy(() -> inputview.bonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호와 중복된 보너스 번호 입력 시 예외 발생")
    void testDuplicateBonusNumber() {
        Inputview inputview = new Inputview();
        inputview.winningNumbr("1,2,3,4,5,6");
        assertThatThrownBy(() -> inputview.bonusNumber("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨번호와 중복됩니다.");
    }

    @Test
    @DisplayName("문자열을 콤마로 분리")
    void testSplitByComma() {
        Inputview inputview = new Inputview();
        String[] result = inputview.splitByComma("1,2,3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("문자열을 정수로 변환")
    void testStringToInt() {
        Inputview inputview = new Inputview();
        assertThat(inputview.stringToInt("123")).isEqualTo(123);
    }

    @Test
    @DisplayName("잘못된 문자열을 정수로 변환 시 예외 발생")
    void testInvalidStringToInt() {
        Inputview inputview = new Inputview();
        assertThatThrownBy(() -> inputview.stringToInt("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자로 변환하지 못하였습니다.");
    }

    @Test
    @DisplayName("숫자 범위 검증")
    void testValidateNumberInRange() {
        Inputview inputview = new Inputview();
        assertThatThrownBy(() -> inputview.validateNumberInRange(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}