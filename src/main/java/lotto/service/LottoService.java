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

    private static final String COMMA = ",";

    public Lottos createLottos(Amount amount) {
        int lottoCount = amount.toLottoCount();

        return Lottos.of(IntStream.range(0, lottoCount)
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

    public Lotto createWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(COMMA);

        return new Lotto(Arrays.stream(numbers)
                .map(String::trim)
                .map(Parse::stringToInt)
                .peek(LottoValidator::validateRange)
                .collect(Collectors.toList()));
    }

    public BonusNumber createBonusNumber(String inputBonusNumber, Lotto winningNumbers) {
        int parsedBonusNumber = Parse.stringToInt(inputBonusNumber);
        LottoValidator.validateDuplicateWith(parsedBonusNumber, winningNumbers);

        return BonusNumber.of(parsedBonusNumber);
    }

}
