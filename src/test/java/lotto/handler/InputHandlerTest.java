package lotto.handler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.util.messages.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerTest {
    private static final String PURCHASE_PRICE_NOT_INTEGER = "money";
    private static final String PURCHASE_PRICE_UNDER_1000 = "900";
    private static final String BONUS_NUMBER_NOT_INTEGER = "bonus";

    private InputStream inputStream;

    private InputHandler inputHandler = new InputHandler();

    @BeforeEach
    void 입력값_검증을_위한_스트림_초기화() {
        this.inputStream = new ByteArrayInputStream(
                (PURCHASE_PRICE_NOT_INTEGER + "\n" + PURCHASE_PRICE_UNDER_1000 + "\n" + BONUS_NUMBER_NOT_INTEGER)
                        .getBytes());
    }

    @Test
    void 입력된_구입_금액이_정수가_아닐_경우_예외가_발생한다() {
        // when
        System.setIn(inputStream);

        // then
        assertThatThrownBy(() -> inputHandler.getPurchasePrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PRICE_IS_NOT_NUMBER.getMessage());
    }

    @Test
    void 입력된_구입_금액이_1000원_미만일_경우_예외가_발생한다() {
        // when
        System.setIn(inputStream);

        // then
        assertThatThrownBy(() -> inputHandler.getPurchasePrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PRICE_IS_UNDER_1000.getMessage());
    }

    @Test
    void 입력된_보너스_번호가_정수가_아닐_경우_예외가_발생한다() {
        // when
        System.setIn(inputStream);

        // then
        assertThatThrownBy(() -> inputHandler.getBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_IS_NOT_INTEGER.getMessage());
    }
}
