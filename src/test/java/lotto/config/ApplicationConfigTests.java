package lotto.config;

import static org.junit.jupiter.api.Assertions.*;

import lotto.controller.LottoInputController;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationConfigTests {

    @Test
    @DisplayName("InputView 객체가 싱글톤 객체인지 확인")
    void getInputViewTest() {
        InputView expected = ApplicationConfig.inputView;

        assertEquals(
                ApplicationConfig.getInputView().hashCode(),
                expected.hashCode()
        );
    }

    @Test
    @DisplayName("OutputView 객체가 싱글톤 객체인지 확인")
    void getOutputViewTest() {
        OutputView expected = ApplicationConfig.outputView;

        assertEquals(
                ApplicationConfig.getOutputView().hashCode(),
                expected.hashCode()
        );
    }

    @Test
    @DisplayName("LottoInputController 객체가 싱글톤 객체인지 확인")
    void getInputControllerTest() {
        LottoInputController expected = ApplicationConfig.lottoInputController;

        assertEquals(
                ApplicationConfig.getInputController().hashCode(),
                expected.hashCode()
        );
    }
}