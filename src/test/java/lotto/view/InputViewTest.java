package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.exception.InputNumberFormatException;
import lotto.exception.lotto.LottoInputFormatException;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력값 검증")
class InputViewTest extends NsTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("입력한 구입 금액이 숫자인지")
    void validateInputPurchaseMoney() {
        run("3000");
        assertThat(inputView.inputPurchaseMoney()).isEqualTo(3_000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"money", "돈", "$"})
    @DisplayName("입력한 구입 금액이 숫자가 아니라면 예외처리 되는지")
    void invalidInputPurchaseMoney(String inputPurchaseMoney) {
        run(inputPurchaseMoney);
        assertThatThrownBy(() -> inputView.inputPurchaseMoney())
                .isInstanceOf(InputNumberFormatException.class)
                .hasMessage(ErrorMessage.INPUT_NUMBER_FORMAT);
    }

    @Test
    @DisplayName("입력한 당첨 번호가 쉼표로 구분되는지")
    void validateInputWinningNumber() {
        run("1,2,3,4,5,6");
        assertThat(inputView.inputWinningNumber()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1;2;3;4;5;6", "1,2;3,4,5,6", "1a2,3,4,5,6", "1ㄱ2,3,4,5,6"})
    @DisplayName("입력한 당첨 번호가 쉼표가 아닌 다른 문자로 구분되면 예외처리 되는지")
    void invalidInputWinningNumber(String inputWinningNumber) {
        run(inputWinningNumber);
        assertThatThrownBy(() -> inputView.inputWinningNumber())
                .isInstanceOf(LottoInputFormatException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_FORMAT);
    }

    @Test
    @DisplayName("입력한 보너스 번호가 숫자인지")
    void validateInputBonusNumber() {
        run("1");
        assertThat(inputView.inputBonusNumber()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"bonus", "보너스", "$"})
    @DisplayName("입력한 보너스 번호가 숫자가 아니라면 예외처리 되는지")
    void invalidInputBonusNumber(String inputBonusNumber) {
        run(inputBonusNumber);
        assertThatThrownBy(() -> inputView.inputBonusNumber())
                .isInstanceOf(InputNumberFormatException.class)
                .hasMessage(ErrorMessage.INPUT_NUMBER_FORMAT);
    }

    @Override
    protected void runMain() {}
}