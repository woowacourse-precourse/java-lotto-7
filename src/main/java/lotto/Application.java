package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoHandlerBuilder;
import lotto.config.LottoHandlerDependencyConfig;
import lotto.handler.LottoHandler;
import lotto.handler.token.HandlerToken;

public class Application {
    public static void main(String[] args) {
        LottoHandlerDependencyConfig lottoHandlerDependencyConfig = new LottoHandlerDependencyConfig(
                new LottoHandlerBuilder());
        LottoHandler lottoHandler = lottoHandlerDependencyConfig.lottoHandler();

        lottoHandler.handle(new HandlerToken());
        Console.close();
    }
}
