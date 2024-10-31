package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

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
        validatePriceOnlyInteger(priceInput);
        int price = Integer.parseInt(priceInput);
        validatePriceScope(price);
        validatePriceUnit(price);
        return price / 1000;
    }

    private void validatePriceOnlyInteger(String priceInput) {
        if (!priceInput.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 금액은 정수만 입력 가능합니다.");
        }
    }

    private void validatePriceScope(Integer price) {
        if (price < 1000 || 100000 < price) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 이상, 100,000원 이하만 가능합니다");
        }
    }

    private void validatePriceUnit(Integer price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위만 가능합니다.");
        }
    }

}
