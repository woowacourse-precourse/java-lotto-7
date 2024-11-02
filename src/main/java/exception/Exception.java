package exception;

public class Exception extends Throwable {

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
        if (buyPrice == 0) {
            throwException("1000원부터 구매 가능합니다.");
        }
        if (buyPrice % 1000 != 0) {
            throwException("1000단위로 입력해주세요(숫자로만 입력해주세요)");
        }
        return buyPrice;
    }

    public int verifyBonusNumber(String bonusNumber) {
        long buyPrice = changeInputStrToNumber(bonusNumber);
        if (buyPrice < 1 || buyPrice > 45) {
            throwException("보너스번호는 1~45 이내 숫자 중 1개만 입력해주세요");
        }
        return (int) buyPrice;
    }

}
