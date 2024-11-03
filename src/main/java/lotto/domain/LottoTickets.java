package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.Validator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final Validator validator;

    private List<Lotto> lottos;
    private int amount;
    private int money;

    public LottoTickets(String money) {
        this.validator = new Validator();

        this.money = validator.validateMoney(money);
        this.amount = getLottoQuantity(this.money);
        this.lottos = issueLottos(this.amount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getAmount() {
        return amount;
    }

    public int getMoney() {
        return money;
    }

    private List<Lotto> issueLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    private int getLottoQuantity(int money) {
        return money / 1000;
    }

}
