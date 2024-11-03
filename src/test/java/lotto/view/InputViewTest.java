package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.exception.InputNumberFormatException;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThat(inputView.inputPurchaseMoney()).isEqualTo(3000);
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

    @Override
    protected void runMain() {}
}