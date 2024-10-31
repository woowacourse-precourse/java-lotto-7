package console;

import camp.nextstep.edu.missionutils.Console;
import exception.Exception;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class Input {

}
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
