package lotto.view;

import lotto.dto.Purchase;
import lotto.message.Message;
import lotto.model.MyLotto;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
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
        Message.WIN_STAT_MESSAGE.println();
        Message.MATCH_3.printFormatted(myLotto.getFifthPlace());
        Message.MATCH_4.printFormatted(myLotto.getFourthPlace());
        Message.MATCH_5.printFormatted(myLotto.getThirdPlace());
        Message.MATCH_5_BONUS.printFormatted(myLotto.getSecondPlace());
        Message.MATCH_6.printFormatted(myLotto.getFirstPlace());
    }

    public void printProfitability(Purchase purchase, BigInteger profit) {
        if (profit.equals(BigInteger.ZERO)) {
            Message.TOTAL_PROFITATABILITY.printFormatted(0);
        }
        if (!profit.equals(BigInteger.ZERO)) {
            Message.TOTAL_PROFITATABILITY.printFormatted(new BigDecimal(profit)
                    .divide(new BigDecimal(purchase.getMoney()), 10, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100))
                    .doubleValue());
        }
    }
}
