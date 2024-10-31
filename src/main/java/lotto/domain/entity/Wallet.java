package lotto.domain.entity;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Stream;

import lotto.domain.vo.PurchaseAmount;

public record Wallet(PurchaseAmount amount, List<Lotto> lottos) {

    public Wallet(PurchaseAmount amount) {
        this(amount, purchaseLotto(amount));
    }

    public Wallet(PurchaseAmount amount, List<Lotto> lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }

    public static Wallet from(PurchaseAmount amount) {
        return new Wallet(amount);
    }

    private static List<Lotto> purchaseLotto(PurchaseAmount amount) {
        return Stream.generate(Lotto::createAutoNumbers)
            .limit(amount.calculateRemainder())
            .toList();
    }
}
