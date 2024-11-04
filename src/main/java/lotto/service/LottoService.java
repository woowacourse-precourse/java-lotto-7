package lotto.service;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.wrapper.Amount;
import lotto.wrapper.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.LottoNumberGenerator;
import lotto.util.Parse;

public class LottoService {

    public Lottos createLottos(Amount amount) {
        int lottoCount = getLottoCount(amount);

        return new Lottos(IntStream.range(0, lottoCount)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList()));
    }

    private Lotto createLotto() {
        return new Lotto(LottoNumberGenerator.generate()
                .stream()
                .sorted()
                .collect(Collectors.toList())
        );
    }

    private int getLottoCount(Amount amount) {
        return amount.getAmount() / 1000;
    }

    public Lotto parseWinningNumberForLotto(String winningNumber) {
        String[] numbers = winningNumber.split(",");

        return new Lotto(Arrays.stream(numbers)
                .map(String::trim)
                .map(Parse::stringToInt)
                .peek(this::validateRange)
                .collect(Collectors.toList()));
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public BonusNumber createBonusNumber(String inputBonusNumber, Lotto winningNumber) {
        int parsedBonusNumber = Parse.stringToInt(inputBonusNumber);
        validateDuplicateWith(parsedBonusNumber, winningNumber);

        return BonusNumber.of(parsedBonusNumber);
    }

    private void validateDuplicateWith(int bonusNumber, Lotto winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되는 보너스 번호는 입력할 수 없습니다.");
        }
    }

}
