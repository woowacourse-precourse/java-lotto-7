package lotto.handler;

import lotto.handler.token.HandlerToken;

public abstract class LottoHandler {
    protected LottoHandler nextHandler = null;
    protected LottoHandler prevHandler = null;

    public LottoHandler setNextHandler(LottoHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void setPrevHandler(LottoHandler prevHandler) {
        this.prevHandler = prevHandler;
    }

    protected abstract HandlerToken process(HandlerToken handlerToken);

    public void handle(HandlerToken handlerToken) {
        HandlerToken resultToken = process(handlerToken);

        if (canProceed(resultToken)) {
            nextHandler.handle(resultToken);
        }
    }

    private boolean canProceed(HandlerToken resultToken) {
        return nextHandler != null && !resultToken.isExpired();
    }
}
