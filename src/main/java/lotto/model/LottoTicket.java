package lotto.model;

import java.util.List;
import lotto.Lotto;
import lotto.util.Validator;

public class LottoTicket {

    private static final int MAX_BUY_PRICE = 100_000;

    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket makeLottoTicket(String puchaseMoney) {
        validateInput(puchaseMoney);
        return null;
    }

    private static void validateInput(String puchaseMoney) {
        Validator.isEmptyInput(puchaseMoney);
        Validator.isDigitString(puchaseMoney);
        Validator.isNumberWithinRange(Integer.parseInt(puchaseMoney), LOTTO_PRICE, MAX_BUY_PRICE);
    }
}
