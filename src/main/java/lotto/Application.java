package lotto;

public class Application {
    public static void main(String[] args) {
        TotalLottoPriceInputHandler totalLotto = new TotalLottoPriceInputHandler();
        LottoNumbers lottoNumbers = new LottoNumbers(totalLotto.getTotalLottoPrice());
        lottoNumbers.printLottos();
        WinningNumberInputHandler winningNumber = new WinningNumberInputHandler();
        BonusNumberInputHandler bonusNumber = new BonusNumberInputHandler(winningNumber.getWinningNumber());
        MatchLotto match = new MatchLotto(totalLotto.getTotalLottoPrice(),
                winningNumber.getWinningNumber(),
                bonusNumber.getBonusNumber(),
                lottoNumbers);
        match.printTotalResult();
    }
}
