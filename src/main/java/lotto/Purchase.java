package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Purchase {
    private final int PURCHASE_AMOUNT;
    private final List<Lotto> lottoNumbers = new ArrayList<>();

    public Purchase(int PURCHASE_AMOUNT) {
        validate(PURCHASE_AMOUNT);
        this.PURCHASE_AMOUNT = PURCHASE_AMOUNT;
        makeLottoNumbers();
    }

    // 정수가 아닐 때도 예외사항 처리해주기
    private void validate(int PURCHASE_AMOUNT) {
        if (PURCHASE_AMOUNT % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위로 입력해야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void makeLottoNumbers() {
        int LOTTO_NUMBER = PURCHASE_AMOUNT / 1000;
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumber);
            lottoNumbers.add(new Lotto(lottoNumber));
        }
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
}
