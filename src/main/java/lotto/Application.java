package lotto;

import lotto.adapter.in.console.LottoConsoleHandler;
import lotto.config.context.ApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.getInstance(Application.class);
        LottoConsoleHandler handler = context.getBean(LottoConsoleHandler.class);

        handler.run();
    }
}
