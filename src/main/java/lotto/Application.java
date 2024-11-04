package lotto;

import Calculator.CheckWinning;
import Calculator.Profit;
import buy.BuyingLotto;
import java.util.List;
import java.util.Map;
import print.InfoPrinter;
import print.InputRequest;

public class Application {
    public static void main(String[] args) {
        InputRequest inputRequest = new InputRequest();
        int money = inputRequest.moneyRequest();

        BuyingLotto buyingLotto = new BuyingLotto();
        List<Lotto> purchasedLottos = buyingLotto.buyLotto(money);

        InfoPrinter infoPrinter = new InfoPrinter();
        infoPrinter.purchasedLottoInfoPrint(money / 1000, purchasedLottos);

        CheckWinning checkWinning = new CheckWinning();
        Map<Integer, Integer> result = checkWinning.checkWinLottoTotal(purchasedLottos);

        infoPrinter.winningResultPrint(result);
        double profit = new Profit().calculate(result, money);
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
