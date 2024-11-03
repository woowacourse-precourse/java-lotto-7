package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.view.ValidatorOfView;

import java.util.ArrayList;
import java.util.List;


public class LottoService {
    private static final String DELIMITER_COMMA = ",";

    public static List<Integer> parseWinningNumber(String numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers.split(DELIMITER_COMMA)) {
            winningNumbers.add(Integer.parseInt(number));
        }
        ValidatorOfView.isValidateWinningNumber(winningNumbers);

        return winningNumbers.stream().toList();
    }

    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
