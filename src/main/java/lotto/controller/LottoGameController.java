package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningStatistic;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
import lotto.service.WinningNumberService;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.*;

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
        this.winningNumberService = winningNumberService;
    }

    public void run() {
        List<Lotto> purchasedLottos;
        List<Integer> winningNumbers;
        Lotto winningLotto;
        int bonusNumber;

        purchasedLottos = purchaseLotto();
        winningLotto = new Lotto(setWinningNumbers());
        bonusNumber = setBonusNumber(winningLotto.getNumbers());
        calculateWinningStatics(purchasedLottos, winningLotto, bonusNumber);

    }

    public List<Lotto> purchaseLotto() {
        int purchasedLottoCount;
        List<Lotto> lottos;

        purchasedLottoCount = lottoPurchaseService.getPurchasedLottoCount();
        outputView.printPurchasedLottoCount(purchasedLottoCount);
        lottos = lottoGeneratorService.generateLotto(purchasedLottoCount);
        outputView.printLottoNumbers(lottos);

        return lottos;
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
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스번호가 당첨번호와 중복됩니다.");
        }
        return true;
    }

    public void calculateWinningStatics(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        LottoResultService lottoResultService = new LottoResultService(purchasedLottos, winningLotto, bonusNumber);
        List<WinningStatistic> winningStatistics = new ArrayList<>();

        for(Lotto purchasedLotto : purchasedLottos) {
            int count = lottoResultService.countMatchingNumbers(purchasedLotto, winningLotto);
            if (count == 5 && lottoResultService.matchBonus(purchasedLotto, bonusNumber)){
//                winningStatistics.add(5, ));
            }
        }
    }


}
