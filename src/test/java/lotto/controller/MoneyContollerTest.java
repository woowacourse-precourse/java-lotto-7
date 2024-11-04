package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyControllerTest {

    private MoneyController moneyController;
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        moneyController = new MoneyController();
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("올바른 금액을 입력하면 로또 수량을 반환한다")
    void returnLottoCountWithValidAmount() {
        // given
        String input = "5000\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int lottoCount = moneyController.inputMoney();

        // then
        assertThat(lottoCount).isEqualTo(5);
        assertThat(outputStreamCaptor.toString())
            .contains("5개를 구매했습니다.");
    }

    @Test
    @DisplayName("잘못된 금액을 입력하면 재입력을 받는다")
    void retryWithInvalidAmount() {
        // given
        String input = String.format("1200%n2000%n");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int lottoCount = moneyController.inputMoney();

        // then
        assertThat(lottoCount).isEqualTo(2);
        assertThat(outputStreamCaptor.toString())
            .contains("구입 금액은 1,000원 단위로 입력해주세요.")
            .contains("2개를 구매했습니다.");
    }

    @Test
    @DisplayName("문자열을 입력하면 재입력을 받는다")
    void retryWithInvalidFormat() {
        // given
        String input = String.format("abc%n3000%n");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int lottoCount = moneyController.inputMoney();

        // then
        assertThat(lottoCount).isEqualTo(3);
        assertThat(outputStreamCaptor.toString())
            .contains("숫자만 입력해주세요.")
            .contains("3개를 구매했습니다.");
    }

    @Test
    @DisplayName("여러 번의 잘못된 입력 후 올바른 금액을 입력하면 로또 수량을 반환한다")
    void returnLottoCountAfterMultipleInvalidInputs() {
        // given
        String input = String.format("abc%n-1000%n1500%n4000%n");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int lottoCount = moneyController.inputMoney();

        // then
        assertThat(lottoCount).isEqualTo(4);
        assertThat(outputStreamCaptor.toString())
            .contains("숫자만 입력해주세요.")
            .contains("구입 금액은 1,000원 단위로 입력해주세요.")
            .contains("4개를 구매했습니다.");
    }
}