package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.repository.LottoRepository;
import lotto.validation.InputValidation;
import lotto.validation.PurchasePriceValidation;

public class LottoService {

    private final InputValidation inputValidation;
    private final PurchasePriceValidation purchasePriceValidation;
    private final LottoRepository lottoRepository;

    public LottoService() {
        this.inputValidation = new InputValidation();
        this.purchasePriceValidation = new PurchasePriceValidation();
        this.lottoRepository = new LottoRepository();
    }

    public int validatePurchasePrice(String purchasePriceInput) throws IllegalArgumentException {
        inputValidation.checkNotNullAndNotBlank(purchasePriceInput);
        purchasePriceValidation.checkIsInteger(purchasePriceInput);

        int purchasePrice = Integer.parseInt(purchasePriceInput);

        purchasePriceValidation.checkRange(purchasePrice);
        purchasePriceValidation.validateDivisibleByThousand(purchasePrice);

        return purchasePrice / 1000;
    }

    public void generateLottoNumbers(int purchaseAmount) {
        while (purchaseAmount > 0) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottoRepository.insertNumbers(randomNumbers);
            purchaseAmount--;
        }
    }

}
