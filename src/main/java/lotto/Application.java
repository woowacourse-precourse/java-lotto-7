package lotto;

import lotto.presentation.LottoWinningClient;
import lotto.presentation.input.InputView;
import lotto.presentation.result.ResultView;
import lotto.service.LottoWinningService;

public class Application {

    public static void main(String[] args) {
        LottoWinningClient lottoWinningClient = new LottoWinningClient(
                new InputView(),
                new ResultView(),
                new LottoWinningService()
        );

        lottoWinningClient.run();
    }

}
