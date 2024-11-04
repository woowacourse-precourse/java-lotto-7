package lotto;

public class InitialController {
  public InitialController(Input input){
    //이거 중간에 로또지를 출력해야 할 것 같음
    initialLottoPaper(initialPurchaseAmountInput(input).getPurchaseQuantity());
    initialwinningNumberInput(input);
  }

  public PurchaseAmount initialPurchaseAmountInput(Input input)
  {
    int purchaseAmount = input.inputPurchaseAmount();
    return new PurchaseAmount(purchaseAmount);
  }

  public void initialwinningNumberInput(Input input)
  {
    LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers();
    lottoWinningNumbers.assignWinningNumber(input.inputWinningNumber());
    lottoWinningNumbers.assignBonusNumber(input.inputBonusNumber());
  }

  public void initialLottoPaper(int purchaseQuantity)
  {
    LottoGenerator lottoGenerator = new LottoGenerator();
    lottoGenerator.printLotto(lottoGenerator.generateLotto(purchaseQuantity));
  }

}
