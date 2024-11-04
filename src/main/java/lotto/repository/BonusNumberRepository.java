package lotto.repository;

import lotto.domain.BonusNumber;

public class BonusNumberRepository {
    private static final BonusNumberRepository bonusNumberRepository = new BonusNumberRepository();

    private int value;

    public static BonusNumberRepository getInstance() {
        return bonusNumberRepository;
    }

    public void save(BonusNumber bonusNumber) {
        this.value = bonusNumber.getValue();
    }

    public BonusNumber find() {
        return new BonusNumber(value);
    }
}
