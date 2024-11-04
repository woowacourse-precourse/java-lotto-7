package lotto;

import lotto.Random.RandomLottoNumberGenerator;
import lotto.input.BonusNumberValidator;
import lotto.input.PurchaseAmountValidator;
import lotto.input.WinningNumbersValidator;

import java.util.List;

public class LottoController {
    private final PurchaseAmountValidator purchaseAmountValidator;
    private final WinningNumbersValidator winningNumbersValidator;
    private final BonusNumberValidator bonusNumberValidator;
    private final LottoGenerator lottoGenerator;

    public LottoController() {
        this.purchaseAmountValidator = new PurchaseAmountValidator();
        this.winningNumbersValidator = new WinningNumbersValidator();
        this.bonusNumberValidator = new BonusNumberValidator();
        this.lottoGenerator = new LottoGenerator(new RandomLottoNumberGenerator());
    }

    public void start() {
        int purchaseAmount = getPurchaseAmount();
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        List<Lotto> lottoBatch = generateLottoBatchAndDisplay(purchaseAmount);

        calculateAndDisplayResults(purchaseAmount, lottoBatch, winningNumbers, bonusNumber);
    }

    private int getPurchaseAmount() {
        purchaseAmountValidator.displayPrompt();  // 한 번만 프롬프트 메시지 출력
        return purchaseAmountValidator.promptAndGetValidatedInput();
    }

    private List<Integer> getWinningNumbers() {
        winningNumbersValidator.displayPrompt();  // 한 번만 프롬프트 메시지 출력
        return winningNumbersValidator.promptAndGetValidatedInput();
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        bonusNumberValidator.displayPrompt();  // 한 번만 프롬프트 메시지 출력
        return bonusNumberValidator.promptAndGetValidatedInput(winningNumbers);
    }

    private List<Lotto> generateLottoBatchAndDisplay(int purchaseAmount) {
        int lottoCount = lottoGenerator.getLottoBatchSize(purchaseAmount);
        List<Lotto> lottoBatch = lottoGenerator.generateLottoBatch(lottoCount);
        lottoGenerator.displayLottoBatchSize(lottoBatch.size());
        lottoGenerator.displayLottoBatch(lottoBatch);
        return lottoBatch;
    }

    private void calculateAndDisplayResults(int purchaseAmount, List<Lotto> lottoBatch, List<Integer> winningNumbers, int bonusNumber) {
        Player player = new Player(purchaseAmount, lottoBatch);
        LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber);
        lottoMachine.calculateWinningStatistics(player.getLottoBatch());
        lottoMachine.displayWinningStatistics();
        double profitRate = player.getProfitRate(lottoMachine.getTotalPrize());
        player.displayProfitRate(profitRate);
    }
}
