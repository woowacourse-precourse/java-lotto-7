package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoResult;


public class ConsoleView {
    public String getPurchaseLottoAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountUserInput = Console.readLine();
        System.out.println();
        return purchaseAmountUserInput;
    }


    public String getWinningNumbers() { // 숫자가 아닌 값이면 예외
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInputWinningNumbers = Console.readLine();
        System.out.println();
        return userInputWinningNumbers;
    }

    public String getBonusNumber() { // 한글자의 숫자가 아니면 예외
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
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

        List<LottoResult> resultOrder = makeOrderList();

        for(LottoResult lottoResult : resultOrder) {
            String result = lottoResult.getResult();
            Integer price = lottoResult.getPrice();
            Integer count = lottoResults.get(lottoResult);
            System.out.println(result + " (" + String.format("%,d", price) + "원) - " + count + "개");
        }
    }

    public void printRateOfReturn(Float rateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%,.1f", rateOfReturn) + "%입니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private List<LottoResult> makeOrderList() {
        List<LottoResult> resultOrder = List.of(
                LottoResult.FIFTH,
                LottoResult.FOURTH,
                LottoResult.THIRD,
                LottoResult.SECOND,
                LottoResult.FIRST
        );
        return resultOrder;
    }
}
