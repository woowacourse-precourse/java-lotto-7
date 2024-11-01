package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoConfig;
import lotto.controller.LottoController;
import lotto.controller.ProfitRateController;
import lotto.controller.WinnerLottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoConfig.getLottoBuyController();
        WinnerLottoController winnerLottoController = LottoConfig.getWinnerLottoController();
        ProfitRateController profitRateController = LottoConfig.getProfitRateController();

        try {
            lottoController.buy();

            winnerLottoController.create();
            winnerLottoController.printStatus();

            profitRateController.print();
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException("구입 금액이 크거나 처리할 수 없는 당첨 금액입니다!");
        } finally {
            Console.close();
        }
    }
}
