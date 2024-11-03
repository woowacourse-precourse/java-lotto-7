package lotto.business.draw;

import static lotto.Util.tryGetUntilSuccess;

import java.util.List;
import lotto.io.IOManager;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoResult;
import lotto.lotto.WinningNumbers;

public class ManualDrawStrategy implements DrawStrategy {
    private final IOManager ioManager;

    public ManualDrawStrategy(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    @Override
    public LottoResult draw() {
        WinningNumbers inputWinningNumbers = tryGetUntilSuccess(this::getWinningNumbers, this::printLinebreak);

        return tryGetUntilSuccess(() -> {
            int bonusNumber = getBonusNumberFromUser();
            return new LottoResult(inputWinningNumbers, new LottoNumber(bonusNumber));
        }, this::printLinebreak);
    }

    private WinningNumbers getWinningNumbers() {
        askUserToInputWinningNumbers();
        List<LottoNumber> inputWinningNumbers = getIntListFromUser().stream().map(LottoNumber::new).toList();
        return new WinningNumbers(inputWinningNumbers);
    }

    private void askUserToInputWinningNumbers() {
        ioManager.printMessage("당첨 번호를 입력해 주세요.");
    }

    private List<Integer> getIntListFromUser() {
        return ioManager.getUserNumbers();
    }

    private int getBonusNumberFromUser() {
        askUserToInputBonusNumber();
        return getIntFromUser();
    }

    private void askUserToInputBonusNumber() {
        ioManager.printMessage("보너스 번호를 입력해 주세요.");
    }

    private int getIntFromUser() {
        return ioManager.getUserNumber();
    }

    private void printLinebreak() {
        ioManager.printMessage("");
    }
}
