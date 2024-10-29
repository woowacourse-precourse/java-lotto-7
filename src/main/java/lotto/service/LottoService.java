package lotto.service;

import static lotto.utils.ErrorMessages.*;

import com.sun.nio.sctp.AbstractNotificationHandler;
import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResultManager;
import lotto.utils.ErrorMessages;

public class LottoService {

    public LottoResultManager initializeLottoGame(String inputPrice, String inputWinningLotto, String inputBonusNumber){

        Lotto winningLotto = initializeWinningLotto(inputWinningLotto);
        BonusNumber bonusNumber = initializeBonusNumber(inputBonusNumber);
        LottoMachine lottoMachine = initializeLottoMachine(inputPrice);

        return new LottoResultManager(winningLotto, bonusNumber, lottoMachine.getPrice());
    }

    private LottoMachine initializeLottoMachine(String inputPrice){
        return new LottoMachine(parseToInteger(inputPrice));
    }

    private Lotto initializeWinningLotto(String inputWinningLotto){
        return new Lotto(parseInputToList(inputWinningLotto));
    }

    private BonusNumber initializeBonusNumber(String inputBonusNumber){
        return new BonusNumber(parseToInteger(inputBonusNumber));
    }


    private List<Integer> parseInputToList(String inputLottoNumbers) {
        String[] splitLottoNumbers = inputLottoNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : splitLottoNumbers) {
            numbers.add(parseToInteger(number));
        }

        return numbers;
    }

    private Integer parseToInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MUST_INTEGER);
        }
    }



}
