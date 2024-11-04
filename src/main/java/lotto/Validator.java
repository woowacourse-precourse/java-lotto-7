package lotto;

public class Validator {
    private final CommonFormula commonFormula = new CommonFormula();
    private final PaymentFormula paymentFormula = new PaymentFormula();
    private final WinningNumberFormula winningNumberFormula = new WinningNumberFormula();
    private final BonusNumberFormula bonusNumberFormula = new BonusNumberFormula();
    private String winningNumber;

    public void payment(String payment) {
        commonFormula.isInputEmpty(payment);
        commonFormula.isContainsWhitespace(payment);
        paymentFormula.isLong(payment);
        paymentFormula.isPositive(payment);
        paymentFormula.isDivisible(payment);
    }

    public void winningNumber(String writeNumber) {
        commonFormula.isInputEmpty(writeNumber);
        commonFormula.isContainsWhitespace(writeNumber);
        winningNumberFormula.isContainsNotInteger(writeNumber);
        winningNumberFormula.isWrongForm(writeNumber);

        this.winningNumber = writeNumber;
    }

    public void bonusNumber(String bonusNumber) {
        commonFormula.isInputEmpty(bonusNumber);
        commonFormula.isContainsWhitespace(bonusNumber);
        bonusNumberFormula.isInteger(bonusNumber);
        bonusNumberFormula.isRightRange(bonusNumber);
        bonusNumberFormula.isDuplicate(bonusNumber, winningNumber);
    }
}
