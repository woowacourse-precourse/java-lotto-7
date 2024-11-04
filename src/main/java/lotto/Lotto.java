package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    public int CorrectLottoCount(Lotto winningNumbers){
        return (int)numbers.stream().filter(winningNumbers::containNumber).count();
    }

    public boolean containNumber(int number){
        return numbers.contains(number);
    }

    public void PrintInfo(List<Integer> lottoNumber) {
        for (Integer number : lottoNumber) {
            System.out.println(number);
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
