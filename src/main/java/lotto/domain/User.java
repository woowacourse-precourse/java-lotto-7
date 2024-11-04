package lotto.domain;

import java.util.List;

public class User {
    private final long payment;  // 지불한 금액
    private final long lottoNumbers; // 로또의 개수
    private final List<List<Integer>> lottoPapers;
    final long WON = 1000L;

    public User(long payment) {
        validateWonUnit(payment);
        this.payment = payment;
        this.lottoNumbers = calculateLottoNumbers(payment);
        this.lottoPapers = LottoStore.saleLotto(lottoNumbers);
    }
    private void validateWonUnit(long money) {
        String WON_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위만 가능합니다.";

        if (money % WON != 0 || money == 0) {
            throw new IllegalArgumentException(WON_UNIT_ERROR_MESSAGE);
        }
    }
    private long calculateLottoNumbers(long payment) {
        return payment / WON;
    }

    public long getLottoNumbers() {
        return lottoNumbers;
    }
    public long getPayment(){
        return payment;
    }
    public List<List<Integer>> getLottoPapers(){
        return lottoPapers;
    }
}
