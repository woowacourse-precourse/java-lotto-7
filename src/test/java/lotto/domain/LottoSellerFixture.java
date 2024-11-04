package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_PRICE;

public class LottoSellerFixture {
    public static LottoSeller createLottoSeller() {
        return new LottoSeller(LOTTO_PRICE, LottoMachineFixture.createLottoMachine());
    }
}
