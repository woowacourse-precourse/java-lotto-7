package lotto.controller;

public interface Policy {
    int getAmountPolicy();
    /**
     * @param number input 값
     * @return 양수면 true
     */
    boolean isAmountPositive(int number);
    int getMinNumberLimit();
    int getMaxNumberLimit();
    int getWinningNumberCount();
    String getDelimiter();
    String getIntegerRegex();
    int getZero();


}
