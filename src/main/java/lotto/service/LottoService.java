package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constants.NumberConstants.LOTTO_END_NUM;
import static lotto.constants.NumberConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.NumberConstants.LOTTO_PRICE;
import static lotto.constants.NumberConstants.LOTTO_START_NUM;
import static lotto.constants.NumberConstants.ZERO;
import static lotto.constants.StringConstants.COMMA;
import static lotto.validator.Validator.validateBonusNumberRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningProcessor;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import lotto.exception.IllegalNumberFormatException;

public class LottoService {

    public UserLotto getValidUserLotto(long buyAmount) {
        int lottoCount = getLottoCount(buyAmount);
        List<Lotto> lottos = generateLotto(lottoCount);

        return new UserLotto(lottoCount, lottos);
    }

    private int getLottoCount(long buyAmount) {
        return (int) (buyAmount / LOTTO_PRICE);
    }

    private List<Lotto> generateLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = ZERO; count < lottoCount; count++) {
            List<Integer> numbers = pickUniqueNumbersInRange(LOTTO_START_NUM, LOTTO_END_NUM, LOTTO_NUMBER_COUNT);
            numbers = sortNumbers(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public WinningLotto convertWinningNumbers(String inputWinningNumbers) {
        try {
            List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(COMMA))
                    .map(number -> Integer.parseInt(number.trim()))
                    .toList();

            return new WinningLotto(new Lotto(winningNumbers));
        } catch (NumberFormatException e) {
            throw new IllegalNumberFormatException();
        }
    }

    public int validateBonusNumber(int bonusNumber, WinningLotto winningLotto) {
        validateBonusNumberRange(bonusNumber);
        winningLotto.validateDuplicateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public WinningResult calculateWinningResult(UserLotto userLotto,
                                                long buyAmount,
                                                WinningLotto winningLotto,
                                                int bonusNumber) {

        return new WinningProcessor(userLotto, winningLotto, bonusNumber).calculate(buyAmount);
    }

}
