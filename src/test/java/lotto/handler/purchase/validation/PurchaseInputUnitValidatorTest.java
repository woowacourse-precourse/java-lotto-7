package lotto.handler.purchase.validation;

import lotto.handler.purchase.dto.PurchaseAmountDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseInputUnitValidatorTest {
    private HandlerToken handlerToken;

    @BeforeEach
    void 핸들러_토큰_초기화() {
        handlerToken = new HandlerToken();
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위일 때 통과")
    void validate_1000원_단위일_때_통과() {
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, PurchaseAmountDTO.create("1000"));
        PurchaseInputUnitValidator validator = new PurchaseInputUnitValidator();
        Assertions.assertDoesNotThrow(() -> validator.validate(handlerToken));
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아닐 경우 예외 발생")
    void validate_1000원_단위가_아닐_때_예외_발생() {
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, PurchaseAmountDTO.create("1500"));
        PurchaseInputUnitValidator validator = new PurchaseInputUnitValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(handlerToken));
    }
}