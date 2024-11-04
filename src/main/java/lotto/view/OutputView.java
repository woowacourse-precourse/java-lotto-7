package lotto.view;

import lotto.message.Message;
import lotto.model.MyLotto;
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

    public void printWinningPlaces(MyLotto myLotto) {
        System.out.println(Message.WIN_STAT_MESSAGE);
        Message.MATCH_3.printFormatted(myLotto.getFifthPlace());
        Message.MATCH_4.printFormatted(myLotto.getFourthPlace());
        Message.MATCH_5.printFormatted(myLotto.getThirdPlace());
        Message.MATCH_5_BONUS.printFormatted(myLotto.getSecondPlace());
        Message.MATCH_6.printFormatted(myLotto.getFirstPlace());
    }
}
