package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Prize;
import lotto.exception.ExceptionMessage;
import lotto.service.LottoService;
import lotto.util.Separator;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<Lotto> purchaseLotto(String purchasePrice) {
        validateStringToInteger(purchasePrice);

        return lottoService.purchaseLotto(Long.valueOf(purchasePrice));
    }

    public LottoMachine registerWinningNumber(String winningNumbers, String bonusNumber) {
        List<String> stringNumbers = Separator.separateLottoNumbers(winningNumbers);
        validateStringsToIntegers(stringNumbers);
        validateStringToInteger(bonusNumber);

        List<Integer> numbers = stringNumbers.stream().map(Integer::valueOf).toList();
        Integer parsedBonusNumber = Integer.valueOf(bonusNumber);

        return lottoService.generateLottoMachine(numbers, parsedBonusNumber);
    }

    public Map<Prize, Integer> getWinningResults(LottoMachine lottoMachine, List<Lotto> lottos) {
        validateNotNull(lottoMachine);
        validateNotNull(lottos);

        return lottoService.getWinningResults(lottoMachine, lottos);
    }

    public Double getRateOfReturn(Map<Prize, Integer> results, String purchasePrice) {
        validateNotNull(results);
        validateNotNull(purchasePrice);

        return lottoService.getRateOfReturn(results, Long.valueOf(purchasePrice));
    }

    private static void validateNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_OF_NOT_NULL.getMessage());
        }
    }

    private static void validateStringsToIntegers(List<String> numbers) {
        numbers.forEach(LottoController::validateStringToInteger);
    }

    private static void validateStringToInteger(String number) {
        try {
            Integer.valueOf(number);
        } catch (Exception e) {
            throw new NumberFormatException(ExceptionMessage.NOT_NUMBER_STRING.getMessage());
        }
    }
}
