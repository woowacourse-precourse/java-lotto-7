package lotto.temp;

import lotto.model.Lotto;
import lotto.util.CommonIo;

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
            String message = "[ERROR] 숫자만 입력 가능합니다.";
            io.printMessage(message);
            return -1;
        }
    }

    public void printPurchaseLottoNumbers(List<Lotto> lottos){
        lottos.forEach(lotto -> io.printMessage(lotto.getNumbers()));
    }

    public String inputWinningNumbers() {
        return io.receiveInput();
    }

    public String inputBonusNumber() {
        return io.receiveInput();
    }

}
