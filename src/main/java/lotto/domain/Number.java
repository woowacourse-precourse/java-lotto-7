package lotto.domain;

public interface Number {

    void validateBlank(String number, String message);

    void validateNumber(String money, String message);

    boolean hasContent(String number);

    boolean isPositive(String number);

    void validateRange(Integer number, String message);

    boolean isInRange(Integer number);


}
