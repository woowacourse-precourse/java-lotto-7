package lotto.model;

import static lotto.Lotto.LOTTO_NUMBER_MAXIMUM;
import static lotto.Lotto.LOTTO_NUMBER_MINIMUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.util.Validator;

public class LottoStore {

    public static final int MAX_BUY_PRICE = 100_000;

    public static final int LOTTO_PRICE = 1000;

    public static LottoTicket makeLottoTicket(String purchaseMoney) {
        validateInput(purchaseMoney);

        int lottoTicketCount = Integer.parseInt(purchaseMoney) / LOTTO_PRICE;
        List<Lotto> lottos = makeLottos(lottoTicketCount);

        return new LottoTicket(lottos);
    }

    private static List<Lotto> makeLottos(int lottoTicketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoTicketCount; count++) {
            lottos.add(new Lotto(makeRandomNumber()));
        }
        return lottos;
    }

    private static void validateInput(String purchaseMoney) {
        Validator.isEmptyInput(purchaseMoney);
        Validator.isDigitString(purchaseMoney);
        int number = Validator.isInteger(purchaseMoney);
        Validator.isNumberWithinRange(number, LOTTO_PRICE, MAX_BUY_PRICE);
        Validator.isDivisibleBy(number, LOTTO_PRICE);
    }

    private static List<Integer> makeRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM, 6));
        Collections.sort(randomNumber);
        return randomNumber;
    }
}
