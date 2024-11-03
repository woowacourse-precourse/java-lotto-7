package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputViewTest {

    private final InputView inputView = new InputView();
    private final InputStream originalStdin = System.in; // 원래의 System.in 저장

    @AfterEach
    public void tearDown() {
        System.setIn(originalStdin); // System.in 복원
        Console.close(); // Scanner 닫기
    }

    @DisplayName("정상적인 돈 입력")
    @Test
    public void testInputMoney_ValidInput() {
        //given
        String simulatedInput = "1000\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        //when
        Money money = inputView.inputMoney();

        //then
        assertThat(money).isNotNull();
        assertThat(money.getValue()).isEqualTo(1000);
    }

    @DisplayName("잘못된 돈 입력 후 제대로 된 입력")
    @Test
    public void testInputMoney_InvalidInput() {
        //given
        String simulatedInput = "invalid\n1000\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        //when
        Money money = inputView.inputMoney();

        //then
        assertThat(money).isNotNull();
        assertThat(money.getValue()).isEqualTo(1000);
    }

    @DisplayName("제대로 된 로또 번호 입력")
    @Test
    public void testValidInputLottoNumber() {
        //given
        String simulatedInput = "1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        //when
        Lotto lotto = inputView.inputOwnLotto();

        //then
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("잘못된 로또 번호 입력 후 제대로 된 입력")
    @Test
    public void testInvalidInputLottoNumber() {
        //given
        String simulatedInput = "1,2,3,4,5,6,7\n1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        //when
        Lotto lotto = inputView.inputOwnLotto();

        //then
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("제대로 된 추가 번호 입력")
    @Test
    public void testValidInputBonusNumber() {
        //given
        String simulatedInput = "7\n";
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        //when
        int bonusNumber = inputView.inputBonusNumber(lotto);

        //then
        assertThat(bonusNumber).isEqualTo(7);
    }

    @DisplayName("잘못된 추가 번호 입력 후 제대로 된 입력")
    @Test
    public void testInvalidInputBonusNumber() {
        //given
        String simulatedInput = "invalid\n7\n"; // 줄바꿈 추가
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        //when
        int bonusNumber = inputView.inputBonusNumber(lotto);

        //then
        assertThat(bonusNumber).isEqualTo(7);
    }
}
