package lotto.domain;

public class WinningNumbers {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final Lotto mainNumbers;
    private final int bonusNumber;


    public WinningNumbers(Lotto mainNumbers, int bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }






}
