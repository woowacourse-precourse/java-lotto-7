package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.PriceRule.*;

public class Consumer {
    private List<Lotto> lottoTicket;

    public Consumer(String priceInput){
        int count = getCount(priceInput);
        for (int i = 0; i < count; i++){
            setLotto(Randoms.pickUniqueNumbersInRange(1,45,6));
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
            validatePriceOnlyInteger(priceInput);
            int price = Integer.parseInt(priceInput);
            validatePriceScope(price);
            validatePriceUnit(price);
            return price / CompareInteger.PRICE_LOTTO.getNumber();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            // 사용자로부터 priceInput을 다시 입력 받는다.
            return getCount(readLine());
        }
    }

    private void validatePriceOnlyInteger(String priceInput) throws IllegalArgumentException {
        if (!priceInput.matches(MATCH_NUMBER.getMessage())) {
            throw new IllegalArgumentException(ONLY_INTEGER.getMessage());
        }
    }

    private void validatePriceScope(Integer price) throws IllegalArgumentException{
        if (price < CompareInteger.PRICE_MINIMUM.getNumber() || CompareInteger.PRICE_MAXIMUM.getNumber() < price) {
            throw new IllegalArgumentException(SCOPE.getMessage());
        }
    }

    private void validatePriceUnit(Integer price) throws IllegalArgumentException {
        if (price % CompareInteger.PRICE_LOTTO.getNumber() != CompareInteger.ZERO.getNumber()) {
            throw new IllegalArgumentException(PRICE_UNIT.getMessage());
        }
    }

}
