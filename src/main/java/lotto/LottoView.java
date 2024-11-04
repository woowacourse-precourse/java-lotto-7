package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoView {

    public int purchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = Integer.parseInt(input);
        System.out.println();
        return purchaseAmount;
    }

    public List<Integer> lottoWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputLottoWinningNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputLottoWinningNumbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        System.out.println();
        return winningNumbers;
    }

    public int lottoBonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonusNumber;
    }

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printLottoRanksInfo() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank lottoRank : LottoRank.valuesList()) {
            if (!lottoRank.getBonusMatched()) {
                System.out.println(lottoRank.getMatchCount() + "개 일치 (" + String.format("%,d", lottoRank.getPrizeAmount()) + "원) - " + lottoRank.getCount() + "개");
                continue;
            }
            System.out.println(lottoRank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + String.format("%,d", lottoRank.getPrizeAmount()) + "원) - " + lottoRank.getCount() + "개");
        }
    }

    public void printLottoPrizeInfo(int totalPrize, double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
        System.out.println();
    }
}
