package lotto.controller;

public class GameController {
    private LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
    private LottoResultController lottoResultController = new LottoResultController();
    private LottoPrizeController lottoPrizeController = new LottoPrizeController();

    public void play() {
        try {
            lottoPurchaseController.purchaseLotto();
            lottoResultController.inputWinnerNumbers();
            lottoPrizeController.calculatePrize(
                    lottoResultController.getWinnerLottoNumber(),
                    lottoResultController.getBonusNumber(),
                    lottoPurchaseController.getUserLottoNumbers(),
                    lottoPurchaseController.getAmount()
            );
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}