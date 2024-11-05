package lotto.domain;

import static lotto.validator.WinningLottoValidator.MAX_VALUE;
import static lotto.validator.WinningLottoValidator.MIN_VALUE;
import static lotto.validator.WinningLottoValidator.SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.NumberGenerator;
import lotto.validator.PurchaseAmountValidator;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> issueLottoes(int purchaseAmount) {
        List<Lotto> lottoes = new ArrayList<>();
        int quantity = calculatePurchaseQuantity(purchaseAmount);

        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = new ArrayList<>(numberGenerator.getNumber(MIN_VALUE, MAX_VALUE, SIZE));
            Collections.sort(numbers);
            lottoes.add(issueLotto(numbers));
        }

        return lottoes;
    }

    public Lotto issueLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private int calculatePurchaseQuantity(int purchaseAmount) {
        return purchaseAmount / PurchaseAmountValidator.UNIT;
    }
}
