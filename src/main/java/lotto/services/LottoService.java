package lotto.services;

import lotto.views.InputView;
import lotto.models.Lotto;
import lotto.models.Bonus;

import java.util.ArrayList;
import java.util.List;


public class LottoService {
    private static final String DELIMITER = ",";
    private final InputView inputView;

    public LottoService(InputView inputView) {
        this.inputView = inputView;
    }

    private List<Integer> stringToList (String lottoNumberInput) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] tokens = lottoNumberInput.split(DELIMITER);
        try {
            for (String token : tokens) {
                numbers.add(Integer.parseInt(token));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다. ");
        }
        return numbers;
    }

    public void lotto () {
        String lottoInput = inputView.requestUserInput(InputView.promptForInput.LottoNumbers);
        try {
            List<Integer> lottoNumbers = stringToList(lottoInput);
            Lotto lotto = new Lotto(lottoNumbers);
        } catch(IllegalArgumentException e) {
            lotto();
        }
        String bonusInput = inputView.requestUserInput(InputView.promptForInput.BonusNumber);
        Bonus bonus = new Bonus(bonusInput);

    }



}
