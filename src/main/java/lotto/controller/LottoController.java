package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    private final LottoResult lottoResult = new LottoResult();
    private static int count;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public void start() {
        start_1();
        start_2();
        start_3();
    }

    private void start_1() {
        while (true) {
            try {
                String inputCount = inputView.readPurchaseAmount();
                count = lottoService.extractLottoCount(inputCount);
                outputView.printLottoCount(count);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void start_2() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.readWinningNumbers();
                winningNumbers = lottoService.extractWinningNumbers(inputWinningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void start_3() {
        while (true) {
            try {
                String inputBonusNumbers = inputView.readBonusNumber();
                bonusNumber = lottoService.extractBonusNumber(inputBonusNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void proceed() {
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = lottoService.extractRandomNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            outputView.printLottoNumbers(lottoNumbers);
            LottoCount lottoCount = lottoService.matchLottoNumbers(winningNumbers, bonusNumber, lotto);
            lottoService.updateWinningResult(lottoCount, lottoResult);
        }
        lottoResult.updateResult();
    }

    public void finish() {
        outputView.printWinningStatistics();
        outputView.printSection();
        Map<String, Integer> result = lottoResult.getResult();
        outputView.printThreeMatches(result.get("three"));
        outputView.printFourMatches(result.get("four"));
        outputView.printFiveMatches(result.get("five"));
        outputView.printFiveBonusMatches(result.get("fiveBonus"));
        outputView.printSixMatches(result.get("six"));
        outputView.printResult(count * 1000, lottoResult);
    }
}
