package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Validator validator = new Validator();

        Integer money = inputView.inputMoney();
        Buyer buyer = new Buyer(money, new LottoStore());
        buyer.buyLotto();

        List<Integer> winningNumbers = inputView.inputWinningLottoNumbers();
        int bonusNumber = inputView.inputBonusLottoNumber(winningNumbers);
        validator.validateLottoNumbers(winningNumbers);

        LottoResultSystem lottoResultSystem = new LottoResultSystem(winningNumbers, bonusNumber);
        lottoResultSystem.displayResults(buyer.getPurchasedLottos(), buyer.getMoney());
    }
}
