package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoManager {
    private final List<Lotto> lotties = new ArrayList<>();
    private Integer money;
    private List<Integer> winLottiesNumber; //Enum 에 대응되는 당첨 로또 개수

    public LottoManager(Integer money) {
        this.money = money;
        for (int i = 0; i<(money/1000);i++){
            this.lotties.add(this.issueLotto());
        }
    }

    public Lotto issueLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    public List<Integer> getWinLottiesNumber() {
        return winLottiesNumber;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


}
