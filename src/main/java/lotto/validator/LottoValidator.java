package lotto.validator;

import java.util.List;
import java.util.regex.Pattern;
import lotto.constant.LottoConstant;

public class LottoValidator {

    private static final Pattern POSITIVE_INTEGER = Pattern.compile("^[1-9]\\d*$");

    public void validateMoney(String money) {
        if (money.isBlank()) {
            // Todo: ErrorCode 사용
            throw new IllegalArgumentException("구입 금액을 입력해 주세요.");
        }
        if (!POSITIVE_INTEGER.matcher(money).matches()) {
            throw new IllegalArgumentException("구입 금액은 양수여야 합니다.");
        }
        if (Integer.parseInt(money) < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로 가능합니다.");
        }
        if (Integer.parseInt(money) > 100000) {
            throw new IllegalArgumentException("구입 금액은 100000원 이하이어야 합니다.");
        }
    }

    public void validateGeneratedLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public void validateWinnerLottoNumbers(String winnerNumbers) {
        if (winnerNumbers.isBlank()) {
            throw new IllegalArgumentException("당첨 번호를 입력해 주세요.");
        }
    }

    public void validateBonusNumber(String bonusNumber) {
        if (bonusNumber.isBlank()) {
            throw new IllegalArgumentException("보너스 번호를 입력해 주세요.");
        }
        if (bonusNumber.length() != 1) {
            throw new IllegalArgumentException("보너스 번호는 1자리여야 합니다.");
        }
    }
}
