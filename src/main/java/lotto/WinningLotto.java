package lotto;

public class LottoService {

    private final Lotto winnigNumber;
    private final int bonusNumber;

    public LottoService(Lotto winnigNumber, int bonusNumber) {
        this.winnigNumber = winnigNumber;
        this.bonusNumber = bonusNumber;
    }
}
