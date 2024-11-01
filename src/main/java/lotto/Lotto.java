package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.answer.Answer;

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

    public void printLottoNumbers() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int checkLottoResult(Answer answer) {
        List<Integer> answerLotto = answer.getAnswerLotto().getNumbers();
        numbers.retainAll(answerLotto);
        return numbers.size();
    }

    public boolean hasBonusLotto(Answer answer) {
        return numbers.contains(answer.getBonusLotto());
    }
}
