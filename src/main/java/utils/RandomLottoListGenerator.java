package utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import validator.Validator;
import view.OutputView;

public class RandomLottoListGenerator {
    public static List<Integer> generate() {
        try {
            List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Validator.validateLottoNumbers(pickNumbers);
            pickNumbers.sort(Comparator.naturalOrder());
            return pickNumbers;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return generate();
    }
}
