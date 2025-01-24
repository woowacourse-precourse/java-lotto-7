package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.util.ErrorUtil;
import lotto.util.NumberUtil;

public class LottoStore {
    private static final String NUMBER_REGEX_PATTERN = "\\d+";
    private static final String WINNING_NUMBER_SEPARATOR = ",";
    private static final String WINNING_NUMBER_BLANK = " ";
    private static final int BONUS_NUMBER_MAX = 45;
    private static final int BONUS_NUMBER_MINIMUM = 1;

    private final int money;
    private int tickets;
    private List<Integer> winningLotto = new ArrayList<>();

    public LottoStore(String money) {
        this.money = Integer.parseInt(money);
    }

    public List<Integer> getLottoNumbers(String winningNumbers) {
        winningLotto = getWinningNumber(winningNumbers);
        return winningLotto;
    }

    public int getMoney() {
        return money;
    }

    private void changeTickets() {
        this.tickets = money/ NumberUtil.LOTTO_PER_PURCHASE_UNIT;
    }

    public int getTickets() {
        changeTickets();
        return tickets;
    }



    private void validateNumber(String winningNumber) {
        if (Pattern.matches(NUMBER_REGEX_PATTERN, winningNumber)) {
            ErrorUtil.WINNING_LOTTO_NOT_NUMBER_ERROR_MESSAGE.errorException();
        }
    }

    public List<Integer> getWinningNumber(String winningNumber) {
        validateNumber(winningNumber);
        checkEmpty(winningNumber);
        Lotto lotto = new Lotto(checkWrongSeparator(winningNumber));
        return checkWrongSeparator(winningNumber);
    }

    private List<Integer> checkWrongSeparator(String winningNumber){
        try {
            return Arrays.stream(winningNumber.split(WINNING_NUMBER_SEPARATOR)).map(Integer::parseInt).toList();
        }catch (NumberFormatException e) {
            ErrorUtil.WINNING_LOTTO_COMA_ERROR_MESSAGE.errorException();
        }
        return List.of();
    }

    private void checkEmpty(String winningNumber) {
        if (winningNumber.contains(WINNING_NUMBER_BLANK)) {
            ErrorUtil.WINNING_LOTTO_EMPTY_ERROR_MESSAGE.errorException();
        }
    }

    public int getBonusNumber(String bonusNumber) {
            validateBonusNumber(bonusNumber);
            checkSameNumberInWinningNumber(winningLotto,bonusNumber);
            validateNumberRange(bonusNumber);
            return Integer.parseInt(bonusNumber);

    }

    private void validateBonusNumber(String bonusNumber) {
        if (!Pattern.matches(NUMBER_REGEX_PATTERN, bonusNumber)) {
            ErrorUtil.BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE.errorException();
        }
    }

    public void checkSameNumberInWinningNumber(List<Integer> winningNumber,String bonusNumber) {
        System.out.println(winningLotto);
        if (winningNumber.contains(Integer.parseInt(bonusNumber))) {
            ErrorUtil.BONUS_NUMBER_REPEAT_ERROR_MESSAGE.errorException();
        }
    }

    private void validateNumberRange(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) > BONUS_NUMBER_MAX || Integer.parseInt(bonusNumber) < BONUS_NUMBER_MINIMUM) {
            ErrorUtil.BONUS_NUMBER_RANGE_ERROR_MESSAGE.errorException();
        }
    }


}
