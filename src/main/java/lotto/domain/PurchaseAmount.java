package lotto.domain;

public class PurchaseAmount {
    private static final int UNIT = 1000;
    private final int amountNum;
    private static final String ERROR_MESSAGE = "[ERROR]";
    public PurchaseAmount(String amountStr){
        int amount=checkText(amountStr);
        validate(amount);
        this.amountNum=amount;
    }
    private void validate(int amount) {
        checkNegative(amount);
        checkUnit(amount);
    }
    private static int checkText(String amountStr) {
        amountStr=amountStr.trim();
        if (amountStr.isBlank()) {
            throw new IllegalArgumentException();
        }
        try {
            return Integer.parseInt(amountStr.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("문자는 안돼요");
        }
    }
    private void checkNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
    }
    private void checkUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }
    public int calculateLottoCount(){
        return amountNum/UNIT;
    }
    public int getAmountNum() {
        return amountNum;
    }
}
