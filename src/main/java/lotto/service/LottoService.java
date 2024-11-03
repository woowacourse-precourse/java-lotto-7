package lotto.service;

import static lotto.util.LottoUtil.parseWinningNumbers;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoService() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public Lotto setLotto() {
        Lotto lotto = createLotto();

        while (true) {
            int bonusNumber = getBonusNumber();
            try {
                lotto.createBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return lotto;
    }

    public Lotto createLotto() {
        List<Integer> lottoNumbers = setWinningNumbers();
        try {
            return new Lotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLotto();
        }
    }

    public List<Integer> setWinningNumbers() {
        outputView.printWinningNumbers();
        String input = inputView.inputUserForData();
        try {
            return parseWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setWinningNumbers();
        }
    }

    public int getBonusNumber() {
        outputView.printBonusNumber();
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }
}
