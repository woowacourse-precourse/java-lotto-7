package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoPurchaseService;
import lotto.service.WinningNumberService;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.List;

import static lotto.util.NumberUtil.parseLottoNumber;

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
        Lotto winningLotto;
        int bonusNumber;

        purchaseLotto();
        winningLotto = new Lotto(setWinningNumbers());
        bonusNumber = setBonusNumber(winningLotto.getNumbers());
        System.out.println(winningLotto.getNumbers());
        System.out.println(bonusNumber);
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

    public int setBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber;

        while (true) {
            try {
                inputBonusNumber = inputView.promptBonusNumber();
                Integer bonusNumber = parseLottoNumber(inputBonusNumber);
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public boolean validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스번호가 당첨번호와 중복됩니다.");
        }
        return true;
    }


}
