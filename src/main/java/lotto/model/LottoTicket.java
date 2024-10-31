package lotto.model;

import java.util.List;
import lotto.Lotto;
import lotto.util.Validator;

public class LottoTicket {

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
    }
}
