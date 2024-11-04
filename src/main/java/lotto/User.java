package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final long ONE_LOTTO_FEE = 1000;
    private final long money;
    private final long lottoCount;

    private final List<Lotto> lottos = new ArrayList<>();
    private List<Price> prices = new ArrayList<>();
    private double returns;

    public User(String userMoney) throws IllegalArgumentException {
        validateUserMoney(userMoney);
        this.money = Long.parseLong(userMoney);
        this.lottoCount = money / ONE_LOTTO_FEE;
    }

    private static void validateUserMoney(String userMoneyInput) throws IllegalArgumentException {
        if (!(userMoneyInput.chars().allMatch(Character::isDigit))) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로만 입력해야 합니다.");
        }
        if (Long.parseLong(userMoneyInput) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public void buyLotto(RandomIntegersGenerator randomGenerator) {
        OutputHandler.printLottoCount(this.lottoCount);
        for (int i = 0; i < this.lottoCount; i++) {
            lottos.add(LottoMachine.releaseLotto(randomGenerator));
            OutputHandler.printLotto(lottos.get(i));
        }
    }

    public void calculateFinalPrice(LottoMachine lottoMachine) {
        for (Lotto lotto : lottos) {
            prices.add(lottoMachine.calculatePrice(lotto));
        }
        calculateReturns();
    }

    private void calculateReturns() {
        long priceSum = prices.stream().mapToLong(Price::getPriceMoney).sum();
        this.returns = ((float)priceSum/money) * 100.0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public long getLottoCount() {
        return lottoCount;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public double getReturns() {
        return returns;
    }
}
