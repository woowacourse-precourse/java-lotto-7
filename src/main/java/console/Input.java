package console;

import camp.nextstep.edu.missionutils.Console;
import exception.Exception;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class Input {

    private final Exception exception = new Exception();

    public void makeEmptyLine(String message) {
        if (message == null || message.isBlank()) {
            System.out.println();
            return;
        }
        System.out.println(message);
    }

    public long returnLottoCount() {
        makeEmptyLine("1000원 단위로 구입금액을 입력해주세요(숫자만 입력해주세요)");
        String buyPriceInput = Console.readLine().trim();
        makeEmptyLine(null);
        long buyPrice = exception.verifyBuyPrice(buyPriceInput);
        long lottoCount = buyPrice / 1000;
        makeEmptyLine(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public Lotto receiveWiningNumber() {
        makeEmptyLine("당첨 번호를 입력해 주세요(콤마로 구분하여 공백없이 작성해주세요)");
        String winingNumberInput = Console.readLine().trim();
        exception.verifyWiningNumber(winingNumberInput);
        List<Integer> winningNumber = changeStrToIntList(winingNumberInput);
        Lotto winningLotto = new Lotto(winningNumber);
        return winningLotto;

    }

    public List<Integer> changeStrToIntList(String string) {
        String[] onlyNumbers = string.split(",");
        List<Integer> sortedList = Arrays.stream(onlyNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        return sortedList;
    }

}
