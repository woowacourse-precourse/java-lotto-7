package lotto.service;

import lotto.collection.WinningNumbers;
import lotto.domain.user.User;
import lotto.util.ProgramExit;
import lotto.view.ErrorOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.enums.LottoConstant.ACCESS_COUNT;
import static lotto.view.OutputView.ENTER_WINNING_NUMBER;

public class LottoService {
    // 싱글톤 패턴
    private static final LottoService instance = new LottoService();
    private final UserService userService = UserService.getInstance();

    protected LottoService() {
    }

    public static LottoService getInstance() {
        return instance;
    }

    public void getWinningNumbers(int userId) {
        int count = ACCESS_COUNT.getValue();
        User user = userService.findById(userId);

        for (int i = 0; i < count; i++) {
            try {
                String[] winningNumber = inputWinningNumbers();
                user.addWinningNumbers(new WinningNumbers(winningNumber));
                return;

            } catch (IllegalArgumentException e) {
                ErrorOutputView.printErrorMessage(e.getMessage());
            }
        }
        ProgramExit.run(count);
    }

    private String[] inputWinningNumbers() {
        OutputView.printMessage(ENTER_WINNING_NUMBER.getMessage());
        return InputView.readLine().split(",");
    }

}
