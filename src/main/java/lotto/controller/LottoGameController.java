package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoPurchaseService;
import lotto.service.WinningNumberService;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.List;

public class LottoGameController {
    private final LottoPurchaseService lottoPurchaseService;
    private final OutputView outputView;
    private final LottoGeneratorService lottoGeneratorService;
    private final InputView inputView;
    private final WinningNumberService winningNumberService;

    // WinningNumberService를 생성자에서 주입받도록 수정
    public LottoGameController(
            LottoPurchaseService lottoPurchaseService,
            OutputView outputView,
            LottoGeneratorService lottoGeneratorService,
            InputView inputView,
            WinningNumberService winningNumberService) {
        this.lottoPurchaseService = lottoPurchaseService;
        this.outputView = outputView;
        this.lottoGeneratorService = lottoGeneratorService;
        this.inputView = inputView;
        this.winningNumberService = winningNumberService; // 주입받은 WinningNumberService 저장
    }

    public void run() {
        List<Integer> winningNumbers;
        int bonusNumber;

        purchaseLotto();
        winningNumbers = setWinningNumbers();

    }

    public void purchaseLotto() {
        int purchasedLottoCount;
        List<Lotto> lottos;

        purchasedLottoCount = lottoPurchaseService.getPurchasedLottoCount();
        outputView.printPurchasedLottoCount(purchasedLottoCount);
        lottos = lottoGeneratorService.generateLotto(purchasedLottoCount);
        outputView.printLottoNumbers(lottos);
    }

    public List<Integer> setWinningNumbers() {
        String inputWinningNumbers;

        while (true) {
            try {
                inputWinningNumbers = inputView.promptWinningNumbers();
                List<Integer> winningNumbers = winningNumberService.generateWinningNumbers(inputWinningNumbers);
                return winningNumbers;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }




}
