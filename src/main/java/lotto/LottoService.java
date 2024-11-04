package lotto;

import java.util.List;

public class LottoService {
    private LottoShop lottoShop;
    private LottoChecker lottoChecker;

    public void run(){
        try {
            int price = purchaseLotto();
            issueLottos(price);

            List<Integer> winNumbers = getWinningNumbers();
            int bonus = getBonusNumber(winNumbers);
            checkLottoResults(winNumbers, bonus);
            printResults(price);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int purchaseLotto() {
        return Input.purchasePrice();
    }

    private void issueLottos(int price) {
        lottoShop = new LottoShop(price);
        lottoShop.issueLotto();
        Output.printLotto(lottoShop.getCount(), lottoShop.getLottos());
    }
    private List<Integer> getWinningNumbers() {
        return Input.winNumber();
    }

    private int getBonusNumber(List<Integer> winNumbers) {
        return Input.inputBonus(winNumbers);
    }

    private void checkLottoResults(List<Integer> winNumbers, int bonusNumber) {
        this.lottoChecker = new LottoChecker();
        lottoChecker.checkLotto(winNumbers, lottoShop.getLottos(), bonusNumber);
    }
    private void printResults(int price) {
        Output.printResult(lottoChecker.getRankCount(), lottoChecker.calculateProfit(price));
    }

}
