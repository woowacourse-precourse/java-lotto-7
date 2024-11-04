package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortNumber();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    public void sortNumber(){ Collections.sort( this.numbers ); }
    public int checkWinNumsCount( List<Integer> winNumbers, int bonusNumber ){
        int correctCount = 0;
        for( Integer myNumber : this.numbers ){
            if( winNumbers.contains( myNumber ) ) correctCount++;
        }
        if( correctCount == 5 && this.numbers.contains( bonusNumber ) ) correctCount = correctCount * 2;
        return correctCount;
    }
    public Constants.LottoGrade getGrade( List<Integer> winNumbers, int bonusNumber ){
        int correctCount = checkWinNumsCount( winNumbers, bonusNumber );
        if( correctCount > 6 ) return Constants.LottoGrade.SECOND_PRIZE;
        switch( correctCount ){
            case 6:
                return Constants.LottoGrade.FIRST_PRIZE;
            case 5:
                return Constants.LottoGrade.THIRD_PRIZE;
            case 4:
                return Constants.LottoGrade.FOURTH_PRIZE;
            case 3:
                return Constants.LottoGrade.FIFTH_PRIZE;
        }
        return Constants.LottoGrade.FAILED;
    }
    public List<Integer> getNumbers() { return this.numbers; }
}
