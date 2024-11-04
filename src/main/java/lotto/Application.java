package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int buyingPrice= InputHandler.getBuyingPrice();
        int buyingAmount = buyingPrice / LOTTO_PRICE;
        List<Lotto> lottos = LottoGenerator.getLotto(buyingAmount);
        System.out.println(buyingAmount + "개를 구매했습니다.");
        lottos.forEach(System.out::println);

        System.out.println("당첨 번호를 입력해주세요.");
        List<Integer> winningNumber = InputHandler.getWinningNumber();

        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = InputHandler.getBonusNumber();

        LottoChecker lottoChecker = new LottoChecker(winningNumber, bonusNumber);
        for(Lotto lotto : lottos) {
            lottoChecker.recordLottoRank(lotto);
        }
        lottoChecker.printRankResult();
        System.out.printf("총 수익률은 %.1f%% 입니다.\n", 1.0 * lottoChecker.getTotalPrize() / buyingPrice * 100);
    }
}
