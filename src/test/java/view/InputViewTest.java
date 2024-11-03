package view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputViewTest {

    // TODO: scanner 때문에 전체 테스트 실패
    @Test
    void 금액_입력_테스트() {
        String simulatedInput = "14000\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        int money = inputView.getInputMoney();
        inputView.closeScanner();

        assertThat(money).isEqualTo(14000);
    }

    @Test
    void 번호_입력_테스트() {
        String simulatedInput = "1,4,5,11,32,43\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        List<Integer> numbers = inputView.getInputNumber();
        inputView.closeScanner();

        assertThat(numbers).contains(1, 4, 5, 11, 32, 43);
    }

    @Test
    void 보너스_번호_입력_테스트() {
        String simulatedInput = "14\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        int bonus = inputView.getInputBonus();
        inputView.closeScanner();

        assertThat(bonus).isEqualTo(14);
    }

}