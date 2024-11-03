package lotto;

import lotto.dto.InputDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {

    @Test
    public void testValidInput() {
        // Given: 유효한 당첨 번호, 보너스 번호, 구입 금액
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int money = 1000;

        // When: 유효한 값으로 InputDTO 생성
        InputDTO inputDTO = new InputDTO(winningNumbers, bonusNumber, money);

        // Then: 입력된 값이 올바르게 저장되어야 함
        assertEquals(winningNumbers, inputDTO.getWinningNumbers(), "당첨 번호가 올바르게 저장되어야 합니다.");
        assertEquals(bonusNumber, inputDTO.getBonusNumber(), "보너스 번호가 올바르게 저장되어야 합니다.");
        assertEquals(money, inputDTO.getMoney(), "구입 금액이 올바르게 저장되어야 합니다.");
    }

    @Test
    public void testInvalidWinningNumbers() {
        // Given: 유효하지 않은 당첨 번호 (7개 숫자)
        List<Integer> invalidWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 8;
        int money = 1000;

        // When & Then: 잘못된 당첨 번호로 InputDTO 생성 시 예외가 발생해야 함
        assertThrows(IllegalArgumentException.class, () -> {
            new InputDTO(invalidWinningNumbers, bonusNumber, money);
        }, "당첨 번호가 6개가 아니면 예외가 발생해야 합니다.");
    }

    @Test
    public void testInvalidBonusNumber() {
        // Given: 유효하지 않은 보너스 번호 (범위 초과)
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int invalidBonusNumber = 50; // 1~45 범위를 벗어남
        int money = 1000;

        // When & Then: 잘못된 보너스 번호로 InputDTO 생성 시 예외가 발생해야 함
        assertThrows(IllegalArgumentException.class, () -> {
            new InputDTO(winningNumbers, invalidBonusNumber, money);
        }, "보너스 번호가 1~45 범위를 벗어나면 예외가 발생해야 합니다.");
    }

    @Test
    public void testInvalidMoney() {
        // Given: 유효하지 않은 구입 금액 (1000원 단위가 아님)
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int invalidMoney = 1500;

        // When & Then: 잘못된 구입 금액으로 InputDTO 생성 시 예외가 발생해야 함
        assertThrows(IllegalArgumentException.class, () -> {
            new InputDTO(winningNumbers, bonusNumber, invalidMoney);
        }, "구입 금액이 1000원 단위가 아니면 예외가 발생해야 합니다.");
    }
}
