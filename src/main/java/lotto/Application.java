package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoInputHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputHandler inputHandler = new LottoInputHandler();
        LottoService lottoService = new LottoService(inputHandler.getTotalPurchase());

        List<List<Integer>> totalRandomNumbers = lottoService.generateLottoTickets();
        Lotto lotto = getValidatedLottoWithRetry(lottoService, inputHandler);
        getValidatedBonusNumberWithRetry(lottoService, lotto, inputHandler);
        Console.close();
    }

    private static Lotto getValidatedLottoWithRetry(LottoService lottoService, LottoInputHandler inputHandler) {
        while (true) {
            try {
                return lottoService.getValidatedLotto(inputHandler.getWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getValidatedBonusNumberWithRetry(LottoService lottoService, Lotto lotto, LottoInputHandler inputHandler) {
        while (true) {
            try {
                int bonusNumber = lottoService.getValidatedBonusNumber(lotto, inputHandler.getBonusNumber());
                lottoService.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}