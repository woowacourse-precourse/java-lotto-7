package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int inputMoney = Money.inputMoney();

        int numberOfLotto = inputMoney / 1000;
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

        BuyLotto lottoList = new BuyLotto(numberOfLotto);
        lottoList.printLottoList();

        List<Integer> winningNumbers = WinningNumber.inputWinningNumbers();
        Lotto lotto = new Lotto(winningNumbers);

        int bonusNumber = BonusNumber.inputBonusNumber(lotto.getLotto());

        Result result = new Result(inputMoney);
        Result.compareLottoNumber(lottoList.getLottoList(), lotto.getLotto(), bonusNumber);
        Result.printResults();
        result.printRateOfReturn();
    }
}
