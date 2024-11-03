package lotto.config;

import lotto.handler.LottoHandler;

public class LottoHandlerBuilder {
    private LottoHandler headHandler;
    private LottoHandler currentHandler;

    public LottoHandlerBuilder addNextHandler(LottoHandler lottoHandler) {
        addHeadHandler(lottoHandler);
        updateCurrentHandler(lottoHandler);
        return this;
    }

    public LottoHandler build() {
        return headHandler;
    }

    private void addHeadHandler(LottoHandler lottoHandler) {
        if (headHandler == null) {
            headHandler = lottoHandler;
            currentHandler = headHandler;
        }
    }

    private void updateCurrentHandler(LottoHandler lottoHandler) {
        lottoHandler.setPrevHandler(currentHandler);
        currentHandler.setNextHandler(lottoHandler);
        currentHandler = lottoHandler;
    }
}
