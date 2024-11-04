package lotto.temp;

import lotto.model.Lotto;
import lotto.util.CommonIo;
import lotto.util.ErrorMessage;
import lotto.util.Message;

import java.util.List;

public class IoController {
    private final CommonIo io;

    public IoController(CommonIo io) {
        this.io = io;
    }

    public String inputPurchaseAmount() {
        return io.receiveInput();
    }

    public int convertInputToInt(String input) {
        try {
            return io.convertStringToInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_TAG.getSentence()
                    + ErrorMessage.INVALID_NUMBER.getError(), e);
        }
    }

    public void printPurchaseLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> io.printMessage(lotto.getNumbers()));
    }

    public String inputWinningNumbers() {
        return io.receiveInput();
    }

    public String inputBonusNumber() {
        return io.receiveInput();
    }
}
