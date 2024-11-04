package lotto.service;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.validator.LottoValidator;
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
                .peek(LottoValidator::validateRange)
                .collect(Collectors.toList()));
    }

    public BonusNumber createBonusNumber(String inputBonusNumber, Lotto winningNumber) {
        int parsedBonusNumber = Parse.stringToInt(inputBonusNumber);
        LottoValidator.validateDuplicateWith(parsedBonusNumber, winningNumber);

        return BonusNumber.of(parsedBonusNumber);
    }

}
