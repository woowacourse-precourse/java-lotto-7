package lotto.handler;

import lotto.handler.token.HandlerToken;

public class EndHandler extends LottoHandler {
    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        handlerToken.checkEnd();
        return handlerToken;
    }
}
