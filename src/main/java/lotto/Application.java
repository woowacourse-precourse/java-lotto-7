package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoConfig;
import lotto.controller.LottoController;
import lotto.controller.ProfitRateController;
import lotto.controller.StatusController;
import lotto.controller.WinnerLottoController;

public class Application {
    private static final LottoController lottoController = LottoConfig.getLottoBuyController();
    private static final WinnerLottoController winnerLottoController = LottoConfig.getWinnerLottoController();
    private static final StatusController statusController = LottoConfig.getStatusController();
    private static final ProfitRateController profitRateController = LottoConfig.getProfitRateController();

    public static void main(String[] args) {
        try {
            lottoController.buy();

            winnerLottoController.input();

            statusController.print();

            profitRateController.print();
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException("구입 금액이 크거나 처리할 수 없는 당첨 금액입니다!");
        } finally {
            Console.close();
        }
    }
}
