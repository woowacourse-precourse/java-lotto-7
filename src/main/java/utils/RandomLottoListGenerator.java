package utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import validator.Validator;
import view.OutputView;

public class RandomLottoListGenerator {
    public List<Integer> generate() {
        try {
            List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Validator.validateLottoNumbers(pickNumbers);
            return pickNumbers;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return generate();
    }
}
