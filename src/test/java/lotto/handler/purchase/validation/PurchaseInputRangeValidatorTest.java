package lotto.handler.purchase.validation;

import lotto.handler.purchase.dto.PurchaseAmountDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseInputRangeValidatorTest {
    private HandlerToken handlerToken;

    @BeforeEach
    void 핸들러_토큰_초기화() {
        handlerToken = new HandlerToken();
    }

    @Test
    @DisplayName("구매 금액이 범위 내일 때 통과")
    void validate_범위_내일_때_통과() {
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, PurchaseAmountDTO.create("5000"));
        PurchaseInputRangeValidator validator = new PurchaseInputRangeValidator();
        Assertions.assertDoesNotThrow(() -> validator.validate(handlerToken));
    }

    @Test
    @DisplayName("구매 금액이 범위를 벗어날 경우 예외 발생")
    void validate_범위를_벗어날_때_예외_발생() {
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, PurchaseAmountDTO.create("500"));
        PurchaseInputRangeValidator validator = new PurchaseInputRangeValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(handlerToken));
    }
}