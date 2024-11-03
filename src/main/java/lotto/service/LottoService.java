package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.RandomLottos;
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
}
