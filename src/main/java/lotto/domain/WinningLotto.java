package lotto.domain;

import java.util.List;

public class WinningLotto {

    Lotto winningLotto;
    int bonusNumber;

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto(List<Integer> numbers) {
        winningLotto = new Lotto(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String inputValue) {
        int num = parseBonusNumber(inputValue);
        validateBonusNumber(num);
        bonusNumber = num;
    }

    private int parseBonusNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하였습니다.");
        }
    }

    private void validateBonusNumber(int number) {
        validateRange(number);
        checkForDuplicate(number);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private void checkForDuplicate(int number) {
        if (winningLotto.getNumbers().contains(number))
            throw new IllegalArgumentException("[ERROR] 중복되는 로또 번호가 존재합니다.");
    }
}
