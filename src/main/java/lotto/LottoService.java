package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private static final Integer MINIMUM_CASH_UNIT = 1000;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public LottoService() {
    }

    public Integer parseInputToCash(String input) {
        Integer cash = 0;

        while (true) {
            try {
                if (!LottoUtils.isNumber(input)) {
                    System.out.println(ErrorMessage.INVALID_INPUT_MESSAGE.getMessage());
                    throw new IllegalArgumentException();
                }

                cash = Integer.parseInt(input);

                if (cash < MINIMUM_CASH_UNIT) {
                    System.out.println(ErrorMessage.INVALID_INPUT_MESSAGE.getMessage());
                    throw new IllegalArgumentException();
                }

                if (cash % MINIMUM_CASH_UNIT != 0) {
                    System.out.println(ErrorMessage.INVALID_CASH_MESSAGE.getMessage());
                    throw new IllegalArgumentException();
                }

                break;
            } catch (IllegalArgumentException e) {
                inputView.inputCash();
            }
        }

        return cash;
    }

    public Integer parseCashToLottoAmount(Integer cash) {
        return cash / MINIMUM_CASH_UNIT;
    }

    public Lotto parseWinningNumber(String input) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] numbers = input.split(",");
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        Lotto winningLotto = new Lotto(winningNumbers);

        return winningLotto;
    }

    public Integer parseBonusNumber(String input) {
        if (!LottoUtils.isNumber(input)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
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
}
