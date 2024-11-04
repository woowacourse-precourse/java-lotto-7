package lotto.view;

import static lotto.constant.ApplicationConstants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constant.ApplicationConstants.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static lotto.constant.ApplicationConstants.INPUT_WINNING_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonuseNumber;
import lotto.domain.Lotto;
import lotto.service.AmountValidatorService;
import lotto.service.IntegerParserService;
import lotto.service.LottoPurchaseService;

public class InputView {

    private final IntegerParserService integerParserService;
    private final AmountValidatorService amountValidatorService;
    private final LottoPurchaseService lottoPurchaseService;

    public InputView(IntegerParserService integerParserService, AmountValidatorService amountValidatorService,
                     LottoPurchaseService lottoPurchaseService) {
        this.integerParserService = integerParserService;
        this.amountValidatorService = amountValidatorService;
        this.lottoPurchaseService = lottoPurchaseService;
    }

    public int getUserLottoPurchaseAmount() {
        while (true) {
            System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
            try {
                int purchaseAmount = integerParserService.parse(Console.readLine());
                amountValidatorService.checkPurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public Lotto getUserWinningLotto() {
        while (true) {
            System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
            try {
                List<Integer> winningLottoNumber = lottoPurchaseService.splitLottoNumber(Console.readLine());
                return new Lotto(winningLottoNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonuseNumber getUserBonusNumber(Lotto winningLottoNumber) {
        while (true) {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            try {
                int bonusNumber = integerParserService.parse(Console.readLine());
                return new BonuseNumber(bonusNumber, winningLottoNumber.getNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
