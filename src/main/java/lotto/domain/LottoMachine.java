package lotto.domain;

import static lotto.validator.LottoAmountValidator.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(int purchaseAmount, LottoNumberGenerator lottoNumberGenerator) {
        this.purchaseAmount = purchaseAmount;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> buyLottos() {
        int lottoAmount = calculateLottoAmount();
        return issueLottos(lottoAmount);
    }

    private int calculateLottoAmount() {
        validate(purchaseAmount, LOTTO_PRICE);
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> issueLottos(int lottoAmount) {
        return Stream.generate(() -> new Lotto(lottoNumberGenerator.generate()))
                .limit(lottoAmount)
                .collect(Collectors.toList());
    }
}
