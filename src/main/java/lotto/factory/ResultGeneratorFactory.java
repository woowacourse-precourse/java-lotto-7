package lotto.factory;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.service.ResultGenerator;

public class ResultGeneratorFactory {

    public static ResultGenerator create(List<Lotto> lottoTicket, Lotto winning, Bonus bonus) {
        return new ResultGenerator(lottoTicket, winning, bonus);
    }
}
