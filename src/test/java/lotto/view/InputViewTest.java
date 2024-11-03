package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생하고 재입력이 가능하다.")
    void 구입_금액_예외_처리() {
        String input = "1500\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = InputView.purchase();

        assertEquals(1000, result);
    }


    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생하고 재입력이 가능하다.")
    void 보너스_번호_중복_예외() {
        String input = "3\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        int result = InputView.bonusNumber(winningNumbers);

        assertEquals(7, result);
    }


    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않을 경우 정상 작동한다.")
    void 보너스_번호_중복_아닐_경우_정상_작동() {
        String input = "7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        int result = InputView.bonusNumber(winningNumbers);
        assertEquals(7, result);
    }
}
