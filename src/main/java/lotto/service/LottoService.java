package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.dto.RandomLottos;
import lotto.dto.WinningLotto;
import lotto.exception.LottoNumberException;
import lotto.exception.message.Error;
import lotto.util.LottoMaker;
import lotto.util.Parser;

public class LottoService {

    public RandomLottos createRandomLottos(int count) {
        List<Lotto> randomLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            randomLottos.add(new Lotto(LottoMaker.make()));
        }

        return new RandomLottos(randomLottos);
    }

    public Lotto createWinningLottoNumbers(String numbersInput) {
        List<LottoNumber> numbers = Arrays.stream(Parser.splitWithDelimiter(numbersInput))
                .map(input -> Parser.parseToInt(input.strip()))
                .map(LottoNumber::new)
                .toList();

        return new Lotto(numbers);
    }

    public WinningLotto createWinningLotto(Lotto winningNumbers, LottoNumber bonus) {
        validateDuplication(winningNumbers, bonus);

        return new WinningLotto(winningNumbers, bonus);
    }

    private void validateDuplication(Lotto winningNumbers, LottoNumber bonus) {
        if (winningNumbers.getNumbers().contains(bonus)) {
            throw new LottoNumberException(Error.BONUS_DUPLICATED);
        }
    }

    public PrizeResult calculateResult(RandomLottos randomLottos, WinningLotto winningLotto) {
        PrizeResult prizeResult = PrizeResult.create();

        for (Lotto radnomLotto : randomLottos.lottos()) {
            List<LottoNumber> mergedLotto = merge(winningLotto, radnomLotto);

            int matchingCount = countMatching(mergedLotto);
            boolean hasNumber = radnomLotto.hasNumber(winningLotto.getBonus());

            Prize foundPrize = Prize.findPrize(matchingCount, hasNumber);
            prizeResult.increaseCountOf(foundPrize);
        }
        prizeResult.removeNoPrize();

        return prizeResult;
    }

    private List<LottoNumber> merge(WinningLotto winningLotto, Lotto randomLotto) {
        return Stream.of(winningLotto.getNumbers(), randomLotto.getNumbers())
                .flatMap(lottoNumber -> lottoNumber.stream())
                .toList();
    }

    private int countMatching(List<LottoNumber> lottNumbers) {
        Set<LottoNumber> removalDuplicatedNumber = new HashSet<>(lottNumbers);

        return lottNumbers.size() - removalDuplicatedNumber.size();
    }
}
