package lotto.user.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoAnswer;
import lotto.lotto.domain.LottoResult;

public class User {
    private final List<Lotto> lottos = new ArrayList<>();
    private int money;

    User(int money) {
        validate(money);

        this.money = money;
    }

    private void validate(int money) {
        if (!UserValidator.OVER_THAN_ZERO.check(money)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 음수일 수 없습니다.");
        }

        if (!UserValidator.MULTIPLE_OF_THOUSAND.check(money)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static User of(int money) {
        return new User(money);
    }

    public void buy(Lotto lotto) {
        if (!canBuyLotto()) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매할 수 없습니다.");
        }

        money -= Lotto.PRICE;
        lottos.add(lotto);
    }

    public boolean canBuyLotto() {
        return money >= Lotto.PRICE;
    }

    public List<LottoResult> match(LottoAnswer answer) {
        return lottos.stream()
                .map(lotto -> lotto.match(answer))
                .toList();
    }

    public BigDecimal calculateRatio(int totalPrize) {
        return BigDecimal.valueOf(totalPrize).divide(BigDecimal.valueOf(money), 1, RoundingMode.HALF_UP);
    }

    public boolean hasLotto(Lotto lotto) {
        return lottos.contains(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
