package lotto.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.handler.token.HandlerToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoHandlerTest {
    private TestHandler firstHandler;
    private TestHandler secondHandler;
    private TestHandler thirdHandler;

    @BeforeEach
    void 여러_핸들러_구성_초기화() {
        firstHandler = new TestHandler();
        secondHandler = new TestHandler();
        thirdHandler = new TestHandler();

        firstHandler.setNextHandler(secondHandler);
        secondHandler.setPrevHandler(firstHandler);
        secondHandler.setNextHandler(thirdHandler);
        thirdHandler.setPrevHandler(secondHandler);
    }

    @Test
    @DisplayName("연결된 핸들러들은 handle 시 각 process가 실행되어야 한다.(검증 에러 시 무한루프 확인)")
    void 연결된_핸들러가_실행되었을때_각_핸들러의_process가_실행되야_한다() {
        HandlerToken token = new HandlerToken();

        firstHandler.handle(token);

        assertEquals(1, firstHandler.getProcessCount());
        assertEquals(1, secondHandler.getProcessCount());
        assertEquals(1, thirdHandler.getProcessCount());
    }

    @Test
    @DisplayName("토큰이 만료되면 다음 핸들러로 진행되지 않아야 한다.")
    void 토큰_만료_시_다음_핸들러로_진행되면_안됨() {
        HandlerToken token = new HandlerToken();

        secondHandler.setExpired(true);

        firstHandler.handle(token);

        assertEquals(1, firstHandler.getProcessCount());
        assertEquals(1, secondHandler.getProcessCount());
        assertEquals(0, thirdHandler.getProcessCount());
    }

    @Test
    @DisplayName("핸들러가 체인에서 잘 연결되는지 확인")
    void 초기화시_각_핸들러는_next_prev_핸들러를_가져야_한다() {
        assertEquals(secondHandler, firstHandler.nextHandler);
        assertEquals(firstHandler, secondHandler.prevHandler);
        assertEquals(thirdHandler, secondHandler.nextHandler);
        assertEquals(secondHandler, thirdHandler.prevHandler);
    }

    @DisplayName("테스트 핸들러 세팅")
    private static class TestHandler extends LottoHandler {
        private int processCount = 0;
        private boolean isExpired = false;

        @Override
        protected HandlerToken process(HandlerToken handlerToken) {
            processCount++;
            if (isExpired) {
                handlerToken.checkEnd(); // Expire the token
            }
            return handlerToken;
        }

        public int getProcessCount() {
            return processCount;
        }

        public void setExpired(boolean expired) {
            this.isExpired = expired;
        }
    }
}