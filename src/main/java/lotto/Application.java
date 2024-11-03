package lotto;

import static lotto.usecase.config.UsecaseConfig.getCompileStatisticsUsecase;
import static lotto.usecase.config.UsecaseConfig.getCreatePrizeUsecase;
import static lotto.usecase.config.UsecaseConfig.getCreateTicketUsecase;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine(
                getCreateTicketUsecase(),
                getCreatePrizeUsecase(),
                getCompileStatisticsUsecase()
        );

        lottoTicketMachine.run();
    }
}
