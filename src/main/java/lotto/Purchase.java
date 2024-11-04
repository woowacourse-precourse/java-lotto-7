package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Purchase {
    private final int PURCHASE_AMOUNT;
    private final List<Lotto> lottoNumbers = new ArrayList<>();

    public Purchase(String purchaseAmount) {
        validateNull(purchaseAmount);
        validateSpace(purchaseAmount);
        validateNotNumber(purchaseAmount);
        int PURCHASE_AMOUNT = Integer.parseInt(purchaseAmount);
        validateMinus(PURCHASE_AMOUNT);
        validateCanDivideWith1000(PURCHASE_AMOUNT);
        this.PURCHASE_AMOUNT = PURCHASE_AMOUNT;
        makeLottoNumbers();
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

    private void validateNull(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이 아닌 보너스 번호를 입력해 주세요.");
        }
    }

    private void validateSpace(String purchaseAmount) {
        if (purchaseAmount.equals(" ")) {
            throw new IllegalArgumentException("[ERROR] 스페이스 값이 아닌 보너스 번호를 입력해 주세요.");
        }
    }

    private void validateNotNumber(String purchaseAmount) {
        try{
            Integer.parseInt(purchaseAmount);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateMinus(int PURCHASE_AMOUNT) {
        if (PURCHASE_AMOUNT <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수여야 합니다.");
        }
    }

    private void validateCanDivideWith1000(int PURCHASE_AMOUNT) {
        if (PURCHASE_AMOUNT % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위로 입력해야 합니다.");
        }
    }
}
