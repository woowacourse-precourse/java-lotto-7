package lotto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Supplier;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    private ErrorHandler errorHandler;
    private InputHandler inputHandler;
    private OutputView outputView;


    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        errorHandler = new ErrorHandler(outputView);
        inputHandler = new InputHandler(errorHandler);
    }

    @Test
    void 유효한입력_예외없이반환() {
        //given
        Supplier<String> validInput = () -> "Valid input";

        //when
        String result = inputHandler.retryOnError(validInput);

        //then
        assertEquals("Valid input", result);
    }

    @Test
    void 예외발생_시재시도_정상입력반환() {
        //given
        InputView inputView = new InputView() {
            private boolean firstAttempt = true;

            @Override
            public String requestLottoPurchaseAmount() {
                if (firstAttempt) {
                    firstAttempt = false;
                    throw new IllegalArgumentException("Invalid input");
                }
                return "1000";
            }
        };

        //when
        String result = inputHandler.retryOnError(inputView::requestLottoPurchaseAmount);

        //then
        assertEquals("1000", result);
        System.out.println("입력값: " + result);
    }
}