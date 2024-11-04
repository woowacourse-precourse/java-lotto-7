package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.service.LottoService;
import lotto.service.UserLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserLottoController {

    private final LottoService lottoService;
    private final UserLottoService userLottoService;

    public UserLottoController(LottoService lottoService, UserLottoService userLottoService) {
        this.lottoService = lottoService;
        this.userLottoService = userLottoService;
    }

    public List<Lotto> buyAndPrintLottos(int lottoAmount) {
        List<Lotto> lottos = lottoService.buyLottos(lottoAmount);
        lottos.stream()
            .map(Lotto::getNumbers)
            .forEach(OutputView::printLottoNumbers);
        return lottos;
    }

    public List<Integer> defaultLottoNumbers() {
        OutputView.printMessageDefaultLottoNumbers();
        while (true) {
            try {
                List<String> defaultNumbers = InputView.inputDefaultLottoNumbers();
                userLottoService.validateDefaultNumber(defaultNumbers);
                return defaultNumbers.stream()
                    .map(Integer::parseInt)
                    .toList();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int bonusNumber() {
        OutputView.printMessageBonusNumber();
        while (true) {
            try {
                String bonusNumber = InputView.inputBonusNumber();
                userLottoService.validateBonusNumber(bonusNumber);
                return Integer.parseInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printWinningStatistics(UserLotto userLotto) {
        Map<Rank, Integer> statistics = userLottoService.calculateWinningStatistics(
            userLotto.getLottos(),
            userLotto.getDefaultLottoNumbers(),
            userLotto.getBonusNumber()
        );
        int totalPrize = userLottoService.calculateTotalPrize(statistics);
        double rateOfReturn = calculateRateOfReturn(totalPrize, userLotto.getLottos().size());
        OutputView.printWinningStatistics(statistics);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private double calculateRateOfReturn(int totalPrize, int totalLottos) {
        return (totalPrize * 100.0) / (totalLottos * 1000);
    }
}
