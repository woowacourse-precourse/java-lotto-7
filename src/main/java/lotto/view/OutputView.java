package lotto.view;

import lotto.message.Message;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final String OPEN_PAREN = "[";
    private final String CLOSE_PAREN = "]";
    private final String COMMA = ",";
    private final String SPACE = " ";

    public void printLottoAmount(BigInteger purchaseAmount) {
        System.out.println(purchaseAmount + Message.PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void printMyLotto(List<Integer> randomNumbers) {
        System.out.print(OPEN_PAREN);
        String lottoNumbers = randomNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(COMMA + SPACE));
        System.out.println(lottoNumbers + CLOSE_PAREN);
    }
}
