package lotto.io;

public class UserInput {

    public final int LOTTO_AMOUNT_UNIT = 1000;
    public final String LOTTO_NUMBER_SEPARATOR = ",";
    public final int LOTTO_NUMBER_MINIMUM_VALUE = 1;
    public final int LOTTO_NUMBER_MAXIMUM_VALUE = 45;
    public final int NUMBER_OF_LOTTO_WINNING_NUMBERS = 6;

    public long getLottoPurchaseAmount(String lottoPurchaseAmountInput) {

        try {
            long lottoPurchaseAmount = Long.parseLong(lottoPurchaseAmountInput);
            validateLottoPurchaseAmountInput(lottoPurchaseAmount);

            return lottoPurchaseAmount;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자입니다.");
        }
    }

    private void validateLottoPurchaseAmountInput(long lottoPurchaseAmount) {
        if (lottoPurchaseAmount % LOTTO_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + LOTTO_AMOUNT_UNIT + "원 단위입니다.");
        }
    }

    public int[] getLottoWinningNumbers(String lottoWinningNumbersInput) {

        try {
            String[] numbersSplit = lottoWinningNumbersInput.split(LOTTO_NUMBER_SEPARATOR);

            validateNumberOfWinningNumbers(numbersSplit.length);

            int[] winningNumbers = new int[NUMBER_OF_LOTTO_WINNING_NUMBERS];

            for (int winningNumberId = 0; winningNumberId < winningNumbers.length; winningNumberId++) {
                winningNumbers[winningNumberId] = Integer.parseInt(numbersSplit[winningNumberId]);
                validateLottoNumber(winningNumbers[winningNumberId]);
            }

            return winningNumbers;

        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 숫자여야 합니다.");
        }

    }

    private void validateNumberOfWinningNumbers(int numberOfWinningNumbers) {
        if (numberOfWinningNumbers != NUMBER_OF_LOTTO_WINNING_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호의 개수는 " + NUMBER_OF_LOTTO_WINNING_NUMBERS + "개 입니다.");
        }
    }

    private void validateLottoNumber(int winningNumberId) {

        if (!(LOTTO_NUMBER_MINIMUM_VALUE <= winningNumberId && winningNumberId <= LOTTO_NUMBER_MAXIMUM_VALUE)) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 " + LOTTO_NUMBER_MINIMUM_VALUE + "~" + LOTTO_NUMBER_MAXIMUM_VALUE + "까지 입니다.");
        }

    }

    public int getLottoWinningBonusNumber(String winningBonusNumberInput) {
        try {
            int winningBonusNumber = Integer.parseInt(winningBonusNumberInput);
            validateLottoNumber(winningBonusNumber);

            return winningBonusNumber;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 보너스 번호는 숫자입니다.");
        }
    }

}
