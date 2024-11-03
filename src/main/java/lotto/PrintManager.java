package lotto;

import java.util.EnumMap;
import java.util.List;

public class PrintManager {
    public void printPriceNotice() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    public void printLottoNumbers(int numberOfLotto, List<Lotto> purchasedLotto) {
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

        for (Lotto lotto : purchasedLotto) {
            StringBuilder oneLottoNumbers = new StringBuilder();
            oneLottoNumbers.append("[");
            for (Integer number : lotto.getNumbers()) {
                oneLottoNumbers.append(number + ", ");
            }
            oneLottoNumbers.delete(oneLottoNumbers.length() - 2 , oneLottoNumbers.length());
            oneLottoNumbers.append("]");
            System.out.println(oneLottoNumbers);
        }
        System.out.println("");
    }

    public void printWinningLottoNotice() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNotice() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningResult(EnumMap<MatchCount, Integer> winningResult) {
        
    }
}
