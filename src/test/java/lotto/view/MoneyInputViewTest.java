package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MoneyInputViewTest {

    private MoneyInputView moneyInputView;
    private final InputStream originalStdin = System.in; // 원래의 System.in 저장

    @BeforeEach
    public void setUp() {
        moneyInputView = new MoneyInputView();
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalStdin); // System.in 복원
        Console.close(); // Scanner 닫기
    }

    @DisplayName("정상적인 입력")
    @Test
    public void testInputMoney_ValidInput() {
        // given
        String simulatedInput = "1000\n"; // 줄바꿈 추가
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes())); // 서로 다른 InputStream 설정

        // when
        Money money = moneyInputView.inputMoney();

        // then
        assertThat(money).isNotNull();
        assertThat(money.getValue()).isEqualTo(1000);
    }

    @DisplayName("잘못된 입력 후 제대로 된 입력")
    @Test
    public void testInputMoney_InvalidInput() {
        // given
        String simulatedInput = "invalid\n1000\n"; // 줄바꿈 추가
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes())); // 서로 다른 InputStream 설정

        // when
        Money money = moneyInputView.inputMoney();

        // then
        assertThat(money).isNotNull();
        assertThat(money.getValue()).isEqualTo(1000);
    }
}
