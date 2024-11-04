package lotto;

import lotto.controller.LottoController;
import lotto.model.administrator.Lotto;
import lotto.model.administrator.LottoBonusNumber;
import lotto.model.statistic.LottoStatisticsDto;
import lotto.model.user.LottoResultDto;
import lotto.service.LottoAdministratorService;
import lotto.service.LottoUserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class DrawGames {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoController controller;

    public DrawGames() {
        inputView = new InputView();
        outputView = new OutputView();
        controller = new LottoController(
                new LottoUserService(),
                new LottoAdministratorService()
        );
    }

    public void run() {
        LottoResultDto lottoResultDto = getLottoResult();
        Lotto winningNumbers = getWinningNumbers();
        LottoBonusNumber bonusNumber = getBonusNumber();

        printLottoStatistics(lottoResultDto, winningNumbers, bonusNumber);
    }

    private void printLottoStatistics(LottoResultDto lottoResultDto, Lotto winningNumbers, LottoBonusNumber bonusNumber) {
        LottoStatisticsDto lottoStatisticsDto = controller.getStatistics(
                lottoResultDto, winningNumbers, bonusNumber
        );
        outputView.printWinningResult(lottoStatisticsDto);
    }

    private LottoResultDto getLottoResult() {
        try {
            String insertedMoney = inputView.purchaseLottery();
            outputView.newLine();

            LottoResultDto lottoResultDto = controller.buyLotto(insertedMoney);
            outputView.printLottoResult(
                    lottoResultDto.lottoResults(),
                    lottoResultDto.lotteryCount()
            );
            outputView.newLine();

            return lottoResultDto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoResult();
        }
    }

    private Lotto getWinningNumbers() {
        try {
            String winningNumbers = inputView.inputWinningNumbers();
            Lotto lotto = controller.setWinningNumbers(winningNumbers);
            outputView.newLine();

            return lotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    private LottoBonusNumber getBonusNumber() {
        try {
            String bonusNumberInput = inputView.inputBonusNumber();
            LottoBonusNumber bonusNumber = controller.setBonusNumber(bonusNumberInput);
            outputView.newLine();

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }
}
