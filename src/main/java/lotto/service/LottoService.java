package lotto.service;

import java.util.List;
import lotto.common.LottoConstants;
import lotto.domain.Lotto;
import lotto.util.LottoNumberGenerator;
import lotto.util.Parser;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final Parser parser;

    public LottoService(LottoNumberGenerator lottoNumberGenerator, Parser parser) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.parser = parser;
    }

    public int parsePayment(String input) {
        return parser.parsePayment(input);
    }

    public List<Integer> parseWinningNumbers(String input) {
        return parser.parseWinningNumbers(input);
    }

    public int parseBonus(String input) {
        return parser.parseBonus(input);
    }

    public List<Lotto> issueLottos(int payment) {
        int count = payment / LottoConstants.PRICE;
        return lottoNumberGenerator.generateLottos(count);
    }
}
