package lotto;

import lotto.IO.InputHandler;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int price = InputHandler.getPrice();
        LottoList lottoList = new LottoList(LottoManager.getTotal(price));

        System.out.println(lottoList.getLottoList().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }

        List<Integer> winningNumber = InputHandler.getWinningLottoNumber();
        int bonusNumber = InputHandler.getBonusNumber(winningNumber);

        System.out.println("당첨 확인 결과:");
        Map<LottoRank, Integer> result = LottoManager.findWinningLotto(lottoList, winningNumber, bonusNumber);

        double profit = LottoManager.calculateProfit(result, price);
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}