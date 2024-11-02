package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class LottoView {
    private static final String WINNING_DELIMITER = ",";

    public BigDecimal inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return convertStringToBigDecimal(Console.readLine());
    }

    private static BigDecimal convertStringToBigDecimal(String str) {
        return new BigDecimal(Integer.parseInt(str));
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        System.out.println();
        return Arrays.stream(winningNumber.split(WINNING_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        return Integer.parseInt(bonusNumber);
    }

    public void printWinningTrace(String winningTrace) {
        System.out.println("당첨 통계\n---");
        System.out.println(winningTrace);
    }

    public void printWinningRate(String winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }
}
