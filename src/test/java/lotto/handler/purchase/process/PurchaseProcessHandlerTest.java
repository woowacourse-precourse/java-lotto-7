package lotto.handler.purchase.process;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import lotto.handler.purchase.dto.LottosDTO;
import lotto.handler.purchase.dto.PurchaseAmountDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchaseProcessHandlerTest {
    private PurchaseProcessHandler purchaseProcessHandler;
    private HandlerToken handlerToken;
    private LottosDTO lottosDTO;

    @BeforeEach
    void 구매_과정_핸들러와_핸들러_토큰_초기화() {
        purchaseProcessHandler = new PurchaseProcessHandler(new LottoGenerator());
        handlerToken = new HandlerToken();
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, PurchaseAmountDTO.create("3000"));
        handlerToken = purchaseProcessHandler.process(handlerToken);
        lottosDTO = handlerToken.getContent(TokenType.LOTTOS_DTO, LottosDTO.class);
    }

    @Test
    void process_시_LottosDTO가_HandlerToken에_존재해야_한다() {
        assertNotNull(lottosDTO);
    }

    @Test
    void HandlerToken에_3000원이_입력됐을_시_process_후_3개의_Lotto가_있어야_한다() {
        assertEquals(3, lottosDTO.getLottos().size());
    }
}