package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    static InputView inputView = new InputView();

    @AfterEach
    void after() {
        Console.close();
    }

    @Test
    void 금액_입력_안내_문구_출력() {
        // given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1000".getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        inputView.lottoMoneyInput();

        // then
        Assertions.assertThat(outputStream.toString())
                .contains("구입금액을 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "51000", "45000"})
    void 돈_정상_입력(String rawMoney) {
        // given
        int expect = Integer.parseInt(rawMoney);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMoney.getBytes());
        System.setIn(inputStream);

        // when
        int money = inputView.lottoMoneyInput();

        // then
        Assertions.assertThat(money).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "100.", "100g", "..l"})
    void 돈_숫자_아닌_문자_입력(String rawMoney) {
        // given
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMoney.getBytes());
        System.setIn(inputStream);

        // when
        // then
        Assertions.assertThatThrownBy(() -> { inputView.lottoMoneyInput(); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "         "})
    void 돈_숫자_아닌_공백_입력(String rawMoney) {
        // given
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rawMoney.getBytes());
        System.setIn(inputStream);

        // when
        // then
        Assertions.assertThatThrownBy(() -> { inputView.lottoMoneyInput(); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMsg());
    }
}