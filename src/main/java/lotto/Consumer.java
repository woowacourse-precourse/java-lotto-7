package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.CompareInteger.*;
import static lotto.PriceRule.*;
import static lotto.validator.NumberValidator.validateOnlyInteger;
import static lotto.validator.PriceValidator.validatePriceUnit;

public class Consumer {
    private List<Lotto> lottoTicket;

    public Consumer(String priceInput) {
        int count = getCount(priceInput);
        for (int i = 0; i < count; i++) {
            setLotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    private void setLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        this.lottoTicket.add(lotto);
    }

    public List<Lotto> getLotto() {
        return this.lottoTicket;
    }

    private int getCount(String priceInput) {
        try {
            validateOnlyInteger(priceInput, ONLY_INTEGER.getMessage());
            int price = Integer.parseInt(priceInput);
            lotto.validator.NumberValidator.validateScope(PRICE_MINIMUM.getNumber(), PRICE_MAXIMUM.getNumber(), price, SCOPE.getMessage());
            validatePriceUnit(price);
            return price / CompareInteger.PRICE_LOTTO.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // 사용자로부터 priceInput을 다시 입력 받는다.
            return getCount(readLine());
        }
    }

}
