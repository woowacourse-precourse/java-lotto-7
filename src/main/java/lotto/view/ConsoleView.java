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
        String purchaseAmountUserInput = Console.readLine();

        if (isNumeric(purchaseAmountUserInput)){
            Integer purchaseAmount = Integer.parseInt(purchaseAmountUserInput);
            System.out.println();
            return purchaseAmount;
        }
        throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로만 이루어져야 합니다.");
    }

    private static boolean isNumeric(String purchaseAmountUserInput) {
        return purchaseAmountUserInput.matches("\\d+");
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

        List<LottoResult> resultOrder = List.of(
                LottoResult.FIFTH,
                LottoResult.FOURTH,
                LottoResult.THIRD,
                LottoResult.SECOND,
                LottoResult.FIRST
        );

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
}
