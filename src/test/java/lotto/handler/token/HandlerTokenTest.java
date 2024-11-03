package lotto.handler.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.handler.purchase.dto.PurchaseAmountDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandlerTokenTest {

    private HandlerToken handlerToken;

    @BeforeEach
    void 핸들러_토큰_초기화() {
        handlerToken = new HandlerToken();
    }

    @Test
    @DisplayName("addContent 메서드를 사용하여 컨텐츠 추가 후 getContent 메서드로 가져올 수 있어야 한다.")
    void addContent와_getContent_메서드_테스트() {
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, 1000);
        Integer content = handlerToken.getContent(TokenType.PURCHASE_AMOUNT_DTO, Integer.class);
        assertEquals(1000, content);
    }

    @Test
    @DisplayName("getContent 메서드 호출 시 잘못된 타입으로 요청할 경우 ClassCastException 발생")
    void getContent_잘못된_파라미터_테스트() {
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, 1000);
        assertThrows(ClassCastException.class, () -> {
            handlerToken.getContent(TokenType.PURCHASE_AMOUNT_DTO, String.class);
        });
    }

    @Test
    @DisplayName("removeContent 메서드를 사용하여 컨텐츠를 삭제할 수 있어야 한다.")
    void removeContent_메서드_테스트() {
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, 1000);
        handlerToken.removeContent(TokenType.PURCHASE_AMOUNT_DTO);
        assertThrows(ClassCastException.class, () -> {
            handlerToken.getContent(TokenType.PURCHASE_AMOUNT_DTO, PurchaseAmountDTO.class);
        });
    }

    @Test
    @DisplayName("hasInvalidInput 메서드는 INVALID_INPUT_ERROR 키가 존재할 경우 true를 반환해야 한다.")
    void hasInvalidInput_메서드_테스트() {
        assertFalse(handlerToken.hasInvalidInput());
        handlerToken.addContent(TokenType.INVALID_INPUT_ERROR, "Invalid input");
        assertTrue(handlerToken.hasInvalidInput());
    }

    @Test
    @DisplayName("checkEnd 메서드 호출 후 isExpired 메서드가 true를 반환해야 한다.")
    void 토큰_유효값_확인_테스트() {
        assertFalse(handlerToken.isExpired());
        handlerToken.checkEnd();
        assertTrue(handlerToken.isExpired());
    }
}