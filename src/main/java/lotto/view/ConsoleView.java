package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoResult;


public class ConsoleView {
    public Integer getPurchaseLottoAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        Integer purchaseAmount = Integer.parseInt(Console.readLine());
        System.out.println();
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() { // 숫자가 아닌 값이면 예외
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInputWinningNumbers = Console.readLine();
        System.out.println();
        return Arrays.stream(userInputWinningNumbers.split(",")).map(Integer::parseInt).toList();
    }

    public Integer getBonusNumber() { // 한글자의 숫자가 아니면 예외
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonusNumber;
    }

    public void printIssuedLotto(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");

        for (Lotto lotto: lotteries) {
            System.out.println(lotto.getLottoNumbers().stream().sorted().toList());
        }
        System.out.println();
    }

    public void printStatistics(Map<LottoResult, Integer> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(LottoResult.FIFTH.getResult() + " " + "(" + String.format("%,d", LottoResult.FIFTH.getPrice()) + "원) - " + lottoResults.get(LottoResult.FIFTH) + "개" );
        System.out.println(LottoResult.FOURTH.getResult() + " " + "(" + String.format("%,d", LottoResult.FOURTH.getPrice()) + "원) - " + lottoResults.get(LottoResult.FOURTH) + "개" );
        System.out.println(LottoResult.THIRD.getResult() + " " + "(" + String.format("%,d", LottoResult.THIRD.getPrice()) + "원) - " + lottoResults.get(LottoResult.THIRD) + "개" );
        System.out.println(LottoResult.SECOND.getResult() + " " + "(" + String.format("%,d", LottoResult.SECOND.getPrice()) + "원) - " + lottoResults.get(LottoResult.SECOND) + "개" );
        System.out.println(LottoResult.FIRST.getResult() + " " + "(" + String.format("%,d", LottoResult.FIRST.getPrice()) + "원) - " + lottoResults.get(LottoResult.FIRST) + "개" );
    }

    public void printRateOfReturn(Float rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
