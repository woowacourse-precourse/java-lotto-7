package utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import validator.Validator;
import view.OutputView;

public class RandomLottoListGenerator {
    public static List<Integer> generate() {
        try {
            List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Validator.validateLottoNumbers(pickNumbers);
            pickNumbers = pickNumbers.stream().sorted().collect(Collectors.toList());
            return pickNumbers;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return generate();
    }
}
