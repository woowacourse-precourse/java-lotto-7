package lotto.lottery.service;

import static lotto.global.util.LottoConst.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.global.util.Parser;
import lotto.lottery.domain.Lotto;
import lotto.lottery.domain.LottoValidator;
import lotto.lottery.service.port.RandomHolder;

public class LottoService {

    private final RandomHolder randomHolder;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoService(RandomHolder randomHolder) {
        this.randomHolder = randomHolder;
    }

    public List<Lotto> purchaseLottos(String amountInput) {
        int quantity = getQuantity(amountInput);
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(randomHolder.getNumbers()));
        }
        return lottos;
    }

    private int getQuantity(String amountInput) {
        int amount = Parser.parseToInt(amountInput);
        LottoValidator.validate(amount);
        return amount / LOTTO_PRICE;
    }

}
