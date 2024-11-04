package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService{
    private final List<Lotto> lottoList;
    private final int ticketPrice = 1000;

    public LottoServiceImpl(){
        this.lottoList = new ArrayList<>();
    }

    @Override
    public void buyLotto(int amount) {
        validateAmount(amount);
        int count = amount / ticketPrice;
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    @Override
    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private void validateAmount(int amount) {
        if (amount % ticketPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
