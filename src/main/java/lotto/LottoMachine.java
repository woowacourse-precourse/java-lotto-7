package lotto;

import static lotto.Input.*;

import java.util.List;

public class LottoMachine {
    public static final int PRICE_OF_ONE_LOTTERY_TICKET = 1000;

    public LottoTicket generateLottoTicket(int amount) {
        int lottoCount = calculateLottoCount(amount);
        List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
        return new LottoTicket(lottos);
    }

    private int calculateLottoCount(int amount) {
        return amount / PRICE_OF_ONE_LOTTERY_TICKET;
    }

    public void run() {

        try {
            int purchaseAmount = validateDivisibleByThousand(
                    toInt(validateIsNumber(validateNotEmpty(getPurchaseAmount()))));

            LottoTicket lottoTicket = generateLottoTicket(purchaseAmount);
            lottoTicket.showLottoTicket();

            List<Integer> winningNumbers = toInt(validateIsNumber(split(getWinningNumber())));

            int bonusNumber = toInt(validateIsNumber(validateNotEmpty(getBonusNumber())));

            WinningNumbers winningNumberObject = new WinningNumbers(winningNumbers, bonusNumber);

            LottoResult lottoResult = new LottoResult();
            lottoResult.evaluateLottoResults(lottoTicket, winningNumberObject);
            lottoResult.displayWinningStatistics();

            double rateOfReturn = lottoResult.calculateRateOfReturn(purchaseAmount);
            lottoResult.displayRateOfReturn(rateOfReturn);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }

}
