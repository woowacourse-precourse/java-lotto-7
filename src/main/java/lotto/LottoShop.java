package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private int count;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoShop(int money) {
        validate(money);
        this.count = money / 1000;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 구입 금액은 1,000원 단위입니다.");
        }
    }

    //개수만큼 로또 발행
    public void issueLotto(){
        for (int i = 0; i < count; i++) {
            List<Integer> issuedLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(issuedLotto));
        }
    }


    public int getCount() {
        return count;
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
