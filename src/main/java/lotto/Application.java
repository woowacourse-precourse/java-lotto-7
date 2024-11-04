package lotto;

import static lotto.utils.ErrorMessage.BIG_MONEY;

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
            throw new IllegalArgumentException(BIG_MONEY.getMessage());
        } finally {
            Console.close();
        }
    }
}
