package lotto.service;

import static lotto.utils.ErrorMessages.*;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResultManager;

public class LottoService {

    public LottoResultManager checkLottoResult(Lotto winningLotto, BonusNumber bonusNumber, LottoMachine lottoMachine) {
        LottoResultManager resultManager = new LottoResultManager(winningLotto, bonusNumber, lottoMachine.getPrice());

        List<Lotto> lottos = lottoMachine.getLottos();
        resultManager.checkLottos(lottos);

        return resultManager;
    }

    public LottoMachine createLottoMachine(String inputPrice) {
        LottoMachine lottoMachine = new LottoMachine(parseStringToInteger(inputPrice));
        lottoMachine.generateLotto();
        return lottoMachine;
    }

    public Lotto createWinningLotto(String inputWinningLottoNumbers) {
        return new Lotto(convertInputToNumberList(inputWinningLottoNumbers));
    }

    public BonusNumber createBonusNumber(String inputBonusNumber) {
        return new BonusNumber(parseStringToInteger(inputBonusNumber));
    }

    public void isBonusNumberDuplicateWithWinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> numbers = winningLotto.getNumbers();
        for (Integer number : numbers) {
            if (number.equals(bonusNumber.getBonusNumber())) {
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION);
            }
        }
    }

    private List<Integer> convertInputToNumberList(String inputLottoNumbers) {
        String[] splitLottoNumbers = inputLottoNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : splitLottoNumbers) {
            numbers.add(parseStringToInteger(number));
        }

        return numbers;
    }

    private Integer parseStringToInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MUST_INTEGER);
        }
    }
}
