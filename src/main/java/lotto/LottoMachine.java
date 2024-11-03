package lotto;

import java.util.List;

public class LottoMachine {
    public static final int PRICE_OF_ONE_LOTTERY_TICKET = 1000;

    public LottoTicket generateLottoTicket(PurchaseAmount purchaseAmount) {
        int lottoCount = calculateLottoCount(purchaseAmount);
        List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
        return new LottoTicket(lottos);
    }

    private int calculateLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / PRICE_OF_ONE_LOTTERY_TICKET;
    }

    public void run() {

        try {

            Input input = new Input();
            PurchaseAmount purchaseAmount = new PurchaseAmount(input.getPurchaseAmount());


            LottoTicket lottoTicket = generateLottoTicket(purchaseAmount);
            lottoTicket.showLottoTicket();

            LottoNumbers lottoNumbers = new LottoNumbers(input.getWinningNumbers(), input.getBonusNumber());

            LottoResult lottoResult = new LottoResult();
            lottoResult.evaluateLottoResults(lottoTicket, lottoNumbers);
            lottoResult.displayWinningStatistics();

            double rateOfReturn = lottoResult.calculateRateOfReturn(purchaseAmount);
            lottoResult.displayRateOfReturn(rateOfReturn);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }

}
