package lotto.service;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.domain.LottoConstants.LOTTO_PRICE;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoSeller;

public class LottoService {
    public LottoRetailer getLottoRetailer() {
        return createLottoRetailer();
    }

    private LottoRetailer createLottoRetailer() {
        return new LottoRetailer(createLottoSeller());
    }

    private LottoSeller createLottoSeller() {
        return new LottoSeller(LOTTO_PRICE, createLottoMachine());
    }

    private LottoMachine createLottoMachine() {
        return new LottoMachine(createLottoNumberGenerator());
    }

    private LottoNumberGenerator createLottoNumberGenerator() {
        return new LottoNumberGenerator(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_OF_LOTTO_NUMBERS);
    }
}
