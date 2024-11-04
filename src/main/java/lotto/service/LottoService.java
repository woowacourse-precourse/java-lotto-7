package lotto.service;

import lotto.collection.WinningNumber;
import lotto.domain.LottoResult;
import lotto.util.ProgramExit;
import lotto.view.ErrorOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.enums.LottoConstant.ACCESS_COUNT;
import static lotto.view.OutputView.ENTER_BONUS_NUMBER;
import static lotto.view.OutputView.ENTER_WINNING_NUMBER;

public class LottoService {
    // 싱글톤 패턴
    private static final LottoService instance = new LottoService();

    protected LottoService() {
    }

    public static LottoService getInstance() {
        return instance;
    }

    public WinningNumber getWinningNumbers() {
        for (int i = 0; i < ACCESS_COUNT.getValue(); i++) {
            try {
                String[] winningNumber = inputWinningNumbers();
                return new WinningNumber(winningNumber);

            } catch (IllegalArgumentException e) {
                ErrorOutputView.printErrorMessage(e.getMessage());
            }
        }
        ProgramExit.run(ACCESS_COUNT.getValue());
        return null;
    }

    private String[] inputWinningNumbers() {
        OutputView.printMessage(ENTER_WINNING_NUMBER.getMessage());
        return InputView.readLine().split(",");
    }

    public LottoResult getBonusNumbers(WinningNumber winningNumbers) {
        for (int i = 0; i < ACCESS_COUNT.getValue(); i++) {
            try {
                OutputView.newLine();
                OutputView.printMessage(ENTER_BONUS_NUMBER.getMessage());
                String bonusNumber = InputView.readLine();
                return new LottoResult(winningNumbers, bonusNumber);

            } catch (IllegalArgumentException e) {
                ErrorOutputView.printErrorMessage(e.getMessage());
            }
        }
        ProgramExit.run(ACCESS_COUNT.getValue());
        return null;
    }

}
