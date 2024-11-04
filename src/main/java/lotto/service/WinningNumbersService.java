package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

import java.util.List;

import static lotto.view.OutputView.printErrorMessage;

public class WinningNumbersService {
    private final InputView inputView = new InputView();

    public WinningNumbers getWinningNumbers() {
        WinningNumbers winningNumbers = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                String inputWinningNumbers = inputView.getWinningNumbers();
                winningNumbers = new WinningNumbers(inputWinningNumbers);

                validInput = true;

            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }

        return winningNumbers; // 유효한 WinningNumbers 객체를 반환
    }

    public void getBonusNumber(WinningNumbers winningNumbers) {
        boolean validInput = false;
        String rawBonusNumber = null;

        while (!validInput) {
            try {
                rawBonusNumber = inputView.getBonusNumber();
                winningNumbers.addBonusNumber(rawBonusNumber);

                validInput = true;

            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    public List<LottoRank> getWinningRanks (Lottos lottos, WinningNumbers winningNumbers) {
        return winningNumbers.getWinningRanks(lottos);
    }

}
