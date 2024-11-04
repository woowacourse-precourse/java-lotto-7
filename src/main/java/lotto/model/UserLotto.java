package lotto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public class UserLotto {

    private int price;
    private List<Lotto> lotto;

    public UserLotto(int price) {
//        validate(price);
        this.price = price;
        lotto = new ArrayList<>();
    }


    public List<Lotto> getLotto() {
        return lotto;
    }
    public int getPrice() {
        return price;
    }
    public List<Lotto> generateLotto() {

        for (int i = 0; i < price / 1000; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .toList();
            lotto.add(new Lotto(lottoNumbers));
        }

        return lotto;
    }

}
