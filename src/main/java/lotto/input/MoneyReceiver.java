package lotto.input;

import lotto.domain.Money;
import lotto.annotation.Retry;
import lotto.message.LottoMessage;
import lotto.message.MessagePrinter;

import java.math.BigInteger;

public class MoneyReceiver implements Receiver<Money> {

    private final InputProvider inputProvider;

    public MoneyReceiver(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Retry
    @Override
    public Money receiveWithMessage() {
        MessagePrinter.printMessage(LottoMessage.ENTER_PURCHASE_AMOUNT);
        String input = inputProvider.readLine();
        validateNumber(input);
        validateRange(input);
        return new Money(Integer.parseInt(input));
    }

    private void validateRange(String input) {
        try {
            BigInteger value = new BigInteger(input);
            if (value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                throw new IllegalArgumentException("[ERROR] 입력한 값이 정수의 최대값을 초과했습니다. 입력한 값 : " + input);
            }
            if (value.compareTo(BigInteger.valueOf(1000)) < 0) {
                throw new IllegalArgumentException("[ERROR] 입력한 금액은 1000원보다 커야 합니다. 입력한 값 : " + input);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자 형식입니다. 입력한 값 : " + input, e);
        }
    }
}
