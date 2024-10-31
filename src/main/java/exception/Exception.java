package exception;

public class Exception {

}
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