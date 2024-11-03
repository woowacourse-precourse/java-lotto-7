package lotto;

import lotto.dto.InputDTO;
import lotto.dto.Lotto;
import lotto.exceptioin.InputException;
import lotto.handler.OutputHandler;
import lotto.service.LottoNumberService;
import lotto.service.LottoResultService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputException inputException = new InputException();
        OutputHandler outputHandler = new OutputHandler();
        LottoNumberService lottoNumberService = new LottoNumberService();
        LottoResultService lottoResultService = new LottoResultService();

        int money = inputException.getValidMoney();

        List<Lotto> purchasedLottos = lottoNumberService.generateLottos(money);
        outputHandler.printLottoNumbers(purchasedLottos);

        List<Integer> winningNumbers = inputException.getValidWinningNumbers();

        int bonusNumber = inputException.getValidBonusNumber();

        InputDTO inputDTO = new InputDTO(winningNumbers, bonusNumber, money);

        lottoResultService.calculateWinningsStatistics(inputDTO, purchasedLottos);
        double profitRate = lottoNumberService.calculateProfitRate(inputDTO, purchasedLottos, money);
        outputHandler.printProfitRate(profitRate);
    }
}
