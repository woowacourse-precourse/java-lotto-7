package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private final Integer price;
    private final Integer count;
    private final List<Lotto> lottos;

    public LottoMachine(Integer price){
        validateLottoPrice(price);
        this.price = price;
        this.count = countLotto(price);
        this.lottos = new ArrayList<>();
    }

    private void validateLottoPrice(Integer price){
        if (price % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.");
    }

    private Integer countLotto(Integer price){
        return price / 1000;
    }

    private List<Lotto> generateLotto(Integer count){
        for (int i = 0; i < count; i++){
            lottos.add(createRandomLotto());
        }
        return this.lottos;
    }

    private Lotto createRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
