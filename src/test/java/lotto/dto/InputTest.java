package lotto.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    @DisplayName("정확한 구입 금액을 받는다.")
    public void purchaseMoney() {
        // GIVEN
        String input = "10000";

        // WHEN
        PurchaseMoneyRequestDTO purchaseMoneyRequestDTO = new PurchaseMoneyRequestDTO(input);

        // THEN
        assertThat(purchaseMoneyRequestDTO.getMoney()).isEqualTo(10000);
    }

    @Test
    @DisplayName("구입금액이 숫자가 아닌 경우 예외를 발생시킨다.")
    public void notNumberMoney() {
        // GIVEN
        String input = "12abc";

        // WHEN - THEN
        assertThatThrownBy(() -> new PurchaseMoneyRequestDTO(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호를 입력받는다.")
    public void winningNumber() {
        // GIVEN
        String input = "1,2,3,4,5,6";

        // WHEN
        WinningNumberRequestDTO winningNumberRequestDTO = new WinningNumberRequestDTO(input);

        // THEN
        assertThat(winningNumberRequestDTO.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("구분 후 숫자가 존재하지 않는 경우, 예외를 발생시킨다.")
    public void notNumberWinningNumber() {
        // GIVEN
        String input = "1,2,3,4,5,a";

        // WHEN - THEN
        assertThatThrownBy(() -> new WinningNumberRequestDTO(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 입력 숫자를 정확하게 전달한다.")
    public void bonusNumber() {
        // GIVEN
        String input = "5";

        // WHEN
        BonusNumberRequestDTO bonusNumberRequestDTO = new BonusNumberRequestDTO(input);

        // THEN
        assertThat(bonusNumberRequestDTO.getBonusNumber()).isEqualTo(5);
    }

    @Test
    @DisplayName("보너스 번호 입력이 숫자가 아닐 경우, 예외를 발생시킨다.")
    public void notNumberBonusNumber() {
        // GIVEN
        String input = "a";

        // WHEN - THEN
        assertThatThrownBy(() -> new BonusNumberRequestDTO(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
