package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class LottoView {
    private static final String WINNING_DELIMITER = ",";

    public BigDecimal inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String str = Console.readLine();
        return new BigDecimal(convertStringToInt(str));
    }

    private int convertStringToInt(String str) {
        validateToInt(str);
        return Integer.parseInt(str);
    }

    private void validateToInt(String str) {
        if (StringUtils.isBlank(str) || !str.codePoints().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 가능합니다.");
        }
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
        String[] winningNumberSplit = winningNumber.split(WINNING_DELIMITER);
        System.out.println();
        return winningNumberToList(winningNumberSplit);
    }

    private List<Integer> winningNumberToList(String[] winningNumberSplit) {
        return Arrays.stream(winningNumberSplit)
                .map(this::convertStringToInt)
                .toList();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        return convertStringToInt(bonusNumber);
    }

    public void printWinningTrace(String winningTrace) {
        System.out.println("당첨 통계\n---");
        System.out.println(winningTrace);
    }

    public void printWinningRate(String winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }
}
