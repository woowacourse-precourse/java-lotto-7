package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private static final Integer MINIMUM_CASH_UNIT = 1000;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Integer parseInputToCash(String input) {
        Integer cash = 0;

        while (true) {
            try {
                checkCashisNumber(input);

                cash = Integer.parseInt(input);
                checkMinimumCash(cash);
                checkMinimumCashUnit(cash);

                break;
            } catch (IllegalArgumentException e) {
                input = inputView.inputCash();
            }
        }

        return cash;
    }

    public Integer parseCashToLottoAmount(Integer cash) {
        return cash / MINIMUM_CASH_UNIT;
    }

    public Lotto parseWinningNumber(String input) {
        Lotto winningLotto;
        List<Integer> winningNumbers = new ArrayList<>();

        while (true) {
            try {
                String[] numbers = input.split(",");

                winningNumbers.clear();
                winningNumbers = addWinningNumbers(winningNumbers, numbers);

                winningLotto = new Lotto(winningNumbers);

                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(ErrorMessage.INVALID_WINNING_NUMBER);
                input = inputView.inputWinningNumber();
            }
        }

        return winningLotto;
    }

    public Integer parseBonusNumber(Lotto winningLotto, String bonusNumberInput) {
        Integer bonusNumber = 0;

        while (true) {
            try {
                bonusNumber = Integer.parseInt(bonusNumberInput);

                checkBonusNumberRange(bonusNumber);
                checkhaveBonusNumber(winningLotto.getNumbers(), bonusNumber);

                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(ErrorMessage.INVALID_BONUS_NUMBER);
                bonusNumberInput = inputView.inputBonusNumber();
            }
        }

        return bonusNumber;
    }

    public List<Lotto> getLotto(Integer lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);

            lottos.add(lotto);
        }

        return lottos;
    }

    public Boolean haveBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        Boolean haveBonusNumber = false;

        if (numbers.contains(bonusNumber)) {
            return true;
        }

        return haveBonusNumber;
    }

    public void checkCashisNumber(String input) {
        if (!LottoUtils.isNumber(input)) {
            outputView.printError(ErrorMessage.INVALID_INPUT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void checkMinimumCash(Integer cash) {
        if (cash < MINIMUM_CASH_UNIT) {
            outputView.printError(ErrorMessage.INVALID_INPUT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void checkMinimumCashUnit(Integer cash) {
        if (cash % MINIMUM_CASH_UNIT != 0) {
            outputView.printError(ErrorMessage.INVALID_CASH_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> addWinningNumbers(List<Integer> winningNumbers, String[] numbers) {
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    public void checkBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    public void checkhaveBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (haveBonusNumber(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
