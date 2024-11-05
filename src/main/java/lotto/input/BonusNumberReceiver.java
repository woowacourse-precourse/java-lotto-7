package lotto.input;

import lotto.domain.BonusNumber;
import lotto.annotation.Retry;
import lotto.domain.Lotto;
import lotto.message.LottoMessage;
import lotto.message.MessagePrinter;

public class BonusNumberReceiver implements Receiver<BonusNumber> {

    private final InputProvider inputProvider;
    private final Lotto winningNumbers;

    public BonusNumberReceiver(InputProvider inputProvider, Lotto winningNumbers) {
        this.inputProvider = inputProvider;
        this.winningNumbers = winningNumbers;
    }

    @Retry
    @Override
    public BonusNumber receiveWithMessage() {
        MessagePrinter.printMessage(LottoMessage.ENTER_BONUS_NUMBER);
        String input = inputProvider.readLine();
        validateNumber(input);
        validateDuplicate(input);
        return new BonusNumber(Integer.parseInt(input));
    }

    private void validateDuplicate(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
