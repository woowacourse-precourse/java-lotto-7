package lotto;

import lotto.Random.RandomLottoNumberGenerator;
import lotto.input.BonusNumberValidator;
import lotto.input.PurchaseAmountValidator;
import lotto.input.WinningNumbersValidator;

import java.util.List;

import static lotto.enums.LottoConstants.*;

public class LottoController {
    PurchaseAmountValidator purchaseAmountValidator;
    WinningNumbersValidator winningNumbersValidator;
    BonusNumberValidator bonusNumberValidator;

    public LottoController() {
        this.purchaseAmountValidator = new PurchaseAmountValidator();
        this.winningNumbersValidator = new WinningNumbersValidator();
        this.bonusNumberValidator = new BonusNumberValidator();
    }

    public void start(){
        LottoGenerator lottoGenerator = new LottoGenerator(new RandomLottoNumberGenerator());
        int purchaseAmount = purchaseAmountValidator.promptAndGetValidatedInput();
        List<Integer> winningNumbers = winningNumbersValidator.promptAndGetValidatedInput();
        int bonusAmount = bonusNumberValidator.promptAndGetValidatedInput(winningNumbers);
        List<Lotto> lottoBatch = lottoGenerator.generateLottoBatch(lottoGenerator.getLottoBatchSize(purchaseAmount));
        Player player = new Player(purchaseAmount, lottoBatch);
        LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusAmount);
        lottoMachine.calculateWinningStatistics(player.getLottoBatch());


    }
}
