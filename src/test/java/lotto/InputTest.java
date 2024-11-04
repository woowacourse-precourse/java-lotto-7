package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {

    @Test
    @DisplayName("정상적인 구입 금액 입력")
    void inputMoney_정상_입력() {
        run("5000");
        Integer money = Input.inputMoney();
        assertThat(money).isEqualTo(5000);
    }

    @Test
    @DisplayName("당첨 번호 정상적인 입력")
    void inputWinNumbers_정상_입력() {
        run("1,2,3,4,5,6");
        List<Integer> winNumbers = Input.inputWinNumbers();
        assertThat(winNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("정상적인 보너스 번호 입력")
    void inputBonusNumber_정상_입력() {
        run("7");
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = Input.inputBonusNumber(winNumbers);
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("구입금액 1000 단위가 아닌 경우")
    void inputMoney_1000_단위_아님() {
        run("1500");
        assertThatThrownBy(Input::inputMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 돈은 1000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("잘못된 숫자 형식일 경우")
    void inputWinNumbers_잘못된_숫자_형식() {
        run("1, 2, three, 4, 5, 6");
        assertThatThrownBy(Input::inputWinNumbers)
                .isInstanceOf(NumberFormatException.class);
    }

    @Override
    public void runMain() {
        // 필요할 경우 main 메서드를 설정합니다.
    }
}
