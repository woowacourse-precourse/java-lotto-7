package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int price = Input.purchasePrice();
            LottoShop lottoShop = new LottoShop(price);
            lottoShop.issueLotto();
            Output.printLotto(lottoShop.getCount(), lottoShop.getLottos());

            List<Integer> winNumber = Input.winNumber();
            int bonus = Input.inputBonus(winNumber);

            LottoChecker lottoChecker = new LottoChecker();
            lottoChecker.checkLotto(winNumber, lottoShop.getLottos(), bonus);

            Output.printResult(lottoChecker.getRankCount(), lottoChecker.calculateProfit(price));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

