package console;

import camp.nextstep.edu.missionutils.Console;
import exception.Exception;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class Input {

    private final Exception exception = new Exception();
    private List<Integer> winningNumber;

    public void makeEmptyLine(String message) {
        if (message == null || message.isBlank()) {
            System.out.println();
            return;
        }
        System.out.println(message);
    }

    public long returnLottoCount() {
        try {
            makeEmptyLine("1000원 단위로 구입금액을 입력해주세요(숫자만 입력해주세요)");
            String buyPriceInput = Console.readLine().trim();
            makeEmptyLine(null);
            long buyPrice = exception.verifyBuyPrice(buyPriceInput);
            long lottoCount = buyPrice / 1000;
            makeEmptyLine(lottoCount + "개를 구매했습니다.");
            return lottoCount;
        } catch (IllegalArgumentException e) {
            makeEmptyLine(e.getMessage());
            makeEmptyLine(null);
            return returnLottoCount();
        }
    }

    public Lotto receiveWiningNumber() {
        try {
            makeEmptyLine("당첨 번호를 입력해 주세요(콤마로 구분하여 공백없이 작성해주세요)");
            String winingNumberInput = Console.readLine().trim();
            List<Integer> winningNumber = changeStrToIntList(winingNumberInput);
            Lotto winningLotto = new Lotto(winningNumber);
            this.winningNumber = winningNumber;
            return winningLotto;
        } catch (IllegalArgumentException e) {
            makeEmptyLine(e.getMessage());
            makeEmptyLine(null);
            return receiveWiningNumber();
        }
    }

    public List<Integer> changeStrToIntList(String string) {
        try {
            return Arrays.stream(string.split(","))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 1~45사이의 당첨번호를 콤마로 구분하여 입력해주세요.", e);
        }
    }

    public int receiveBonusNumber() {
        try {
            makeEmptyLine("보너스 번호를 입력해 주세요(1~45 이내의 숫자만 입력해주세요)");
            String bonusNumberInput = Console.readLine().trim();
            int bonusNumber = exception.verifyBonusNumber(bonusNumberInput);
            if (winningNumber.contains(bonusNumber)) {
                exception.throwException("보너스 번호는 당첨번호에 포함이 안된 숫자여야 합니다");
            }
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            makeEmptyLine(e.getMessage());
            makeEmptyLine(null);
            return receiveBonusNumber();
        }
    }

}
