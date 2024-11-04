package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lotto.domain.RandomLottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.util.LottoMaker;
import lotto.util.Parser;
import lotto.util.TicketMaker;

public class LottoService {

    public RandomLottos createRandomLottos(int count) {
        List<Lotto> randomLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            randomLottos.add(new Lotto(LottoMaker.make()));
        }

        return new RandomLottos(randomLottos);
    }

    public int changeToTicket(String priceInput) {
        int price = Parser.parseToInt(priceInput);

        return TicketMaker.make(price);
    }

    public Lotto createWinningLottoNumbers(String numbersInput) {
        List<LottoNumber> numbers = Arrays.stream(Parser.splitWithDelimiter(numbersInput))
                .map(Parser::parseToInt)
                .map(LottoNumber::new)
                .toList();

        return new Lotto(numbers);
    }

    public WinningResult calculateResult(RandomLottos randomLottos, WinningLotto winningLotto) {
        WinningResult winningResult = WinningResult.create();

        for (Lotto radnomLotto : randomLottos.lottos()) {
            List<LottoNumber> mergedLotto = merge(winningLotto, radnomLotto);

            int matchingCount = countMatching(mergedLotto);
            boolean hasNumber = radnomLotto.hasNumber(winningLotto.getBonus());
        }

        return winningResult;
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
