package lotto.controller;


import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.service.GameService;
import lotto.util.InputUtil;
import lotto.view.error.ErrorView;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class GameController {

    private GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void run() {
        purchaseAndViewLottos();
        generateWinningLottoAndViewResult();
    }

    public void purchaseAndViewLottos() {
        int money = inputMoney();

        LottoTicket lottoTicket = gameService.purchaseLotto(money);
        OutputView.outputLottoNumbers(lottoTicket);
    }

    public int inputMoney() {
        while(true) {
            String inputMoney = InputView.inputMoney();
            try {
                return InputUtil.parseMoney(inputMoney);
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void generateWinningLottoAndViewResult() {
        Lotto lotto = inputLottoNumbers();
        Bonus bonusNumber = inputBonusNumber(lotto.getNumbers());

        LottoResult lottoResult = gameService.resultLotto(lotto, bonusNumber);
        OutputView.outputRankSummary(lottoResult.getResultRank(), lottoResult.calculateProfitRate());
    }


    public Lotto inputLottoNumbers() {
        List<Integer> numbers;
        while(true) {
            String inputLottoNumbers = InputView.inputLottoNumbers();
            try {
                numbers = InputUtil.splitNumbers(inputLottoNumbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
    }

    public Bonus inputBonusNumber(List<Integer> numbers) {
        int bonus;
        while(true) {
            String inputBonusNumber = InputView.inputBonusNumber();
            try {
                bonus = InputUtil.parseBonusNumber(inputBonusNumber);
                return new Bonus(numbers, bonus);
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
    }


}
