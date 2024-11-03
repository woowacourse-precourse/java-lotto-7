package utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import validator.Validator;
import view.OutputView;

public class LottoNumbersGenerator {
    public static List<Integer> generate() {
        try {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Validator.validateLottoNumbers(lottoNumbers);
            lottoNumbers = lottoNumbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            return lottoNumbers;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return generate();
    }
}
