package exception;

import lotto.LottoValidator;

public class Exception {

    public void throwException(String errorMessage) {
        throw new IllegalArgumentException("[ERROR] " + errorMessage);
    }

    public long changeInputStrToNumber(String number) {
        if (!number.matches("\\d+")) {
            throwException("숫자만 입력해주세요");
        }
        long buyPrice = 0;
        try {
            buyPrice = Long.parseLong(number);
        } catch (NumberFormatException e) {
            throwException("숫자가 너무 큽니다.");
        }
        return buyPrice;
    }

    public long verifyBuyPrice(String buyPriceInput) {
        long buyPrice = changeInputStrToNumber(buyPriceInput);
        if (buyPrice % 1000 != 0 || buyPrice == 0) {
            throwException("1000단위로 입력해주세요(숫자로만 입력해주세요)");
        }
        return buyPrice;
    }

    public void verifyWiningNumber(String winingNumber) {
        LottoValidator lottoValidator = new LottoValidator();
        boolean normalLotto = lottoValidator.isValidLotto(winingNumber);
        if (!normalLotto) {
            throwException("로또당첨번호가 정상적으로 입력되지 않았습니다");
        }
    }

    public int verifyBonusNumber(String bonusNumber) {
        long buyPrice = changeInputStrToNumber(bonusNumber);
        if (buyPrice > 45) {
            throwException("보너스번호는 1~45 이내 숫자 중 1개만 입력해주세요(숫자만 입력하세요)");
        }
        return (int) buyPrice;
    }

}
