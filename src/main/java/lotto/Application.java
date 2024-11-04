package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        NumberGenerator generator = new NumberGenerator();
        int price = lottoInput.inputPrice();//가격
        int countPurchase = generator.countPurchases(price);//구매 갯수
        System.out.println("\n" + countPurchase + "개를 구매했습니다.");
        List<Lotto> lottoList = generator.setLottoNumber(price);
        LottoPrint.printNumbers(lottoList);
        System.out.println();

        List<Integer> winningNumbers = lottoInput.inputWinningNumber();
        int bonusNumber = lottoInput.inputBonusNumber();

        LottoStatistics stats = new LottoStatistics(price);
        for (Lotto lotto : lottoList) {
            int matchCount = stats.calculateMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            stats.recordResult(matchCount, bonusMatch);
        }
        stats.printStatistics();
    }
}
