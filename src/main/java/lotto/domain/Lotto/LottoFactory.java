package lotto.domain.Lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto.Lotto;
import lotto.domain.Number;
import lotto.util.InputParser;

public class LottoFactory {
    private LottoFactory() {
    }

    public static Lotto createAutoLotto() {
        return new Lotto(createLottoNumber());
    }

    public static Lotto createManualLotto(String input) {
        List<Number> parsedNumbers = parseStringInput(input);
        return new Lotto(parsedNumbers);
    }

    private static List<Number> createLottoNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private static List<Number> parseStringInput(String input) {
        List<Integer> rawWinningLotto = InputParser.convertStringToList(input);
        return rawWinningLotto.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
