package lotto.service.domain.lotto;

import java.util.List;
import lotto.service.domain.money.Money;

public class LottoBuyer implements LottoValueProvider{
    /**
     * 로또 리스트는 인터페이스를 통하지 않는다. 로또 리스트가 다른 구현체가 필요해진다면 이미 로또 게임을 벗어나기 때문.
     * 하지만 돈 클래스는 그냥 일반 돈이 아니라, 로또를 살 수 있는 1000원 단위라는 특수 조건이 있다.
     * 이는 추후 조건이 없어질 수 있고 새로운 조건이 추가될 수도 있기 때문에 인터페이스로 한다.
     */
    private List<Lotto> purchasedLotto;
    private Money budget;

    public LottoBuyer(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    @Override
    public void makePurchasedLotto() {

    }

    @Override
    public void makeWinningStatistics() {

    }

}
