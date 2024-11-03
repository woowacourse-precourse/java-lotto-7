package lotto.handler.purchase.validation;

import lotto.handler.purchase.dto.PurchaseAmountDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseInputFormatValidatorTest {
    private HandlerToken handlerToken;

    @BeforeEach
    void 핸들러_토큰_초기화() {
        handlerToken = new HandlerToken();
    }

    @Test
    @DisplayName("구매 금액에 숫자만 있는 경우 통과")
    void validate_숫자만_있을_때_통과() {
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, PurchaseAmountDTO.create("5000"));
        PurchaseInputFormatValidator validator = new PurchaseInputFormatValidator();
        Assertions.assertDoesNotThrow(() -> validator.validate(handlerToken));
    }

    @Test
    @DisplayName("구매 금액에 숫자가 아닌 문자가 포함될 경우 예외 발생")
    void validate_숫자가_아닐_때_예외_발생() {
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, PurchaseAmountDTO.create("5a000"));
        PurchaseInputFormatValidator validator = new PurchaseInputFormatValidator();
        Assertions.assertThrows(NumberFormatException.class, () -> validator.validate(handlerToken));
    }
}