package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.ErrorMessage.*;

public class CustomLotto extends Lotto{
    private Integer bonus;

    public CustomLotto(List<Integer> numbers, Integer bonus) {
        super(numbers);
        this.bonus= bonus;
        isDuplicateLottoAndBonus();
    }
    public Integer getBonus(){
        return bonus;
    }
    private void isDuplicateLottoAndBonus(){
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(this.getNumbers());
        numbers.add(bonus);
        List<Integer> numbersPlusBonus = numbers.stream().distinct().toList();

        if(numbersPlusBonus.size()!=7){
            throw new IllegalArgumentException(ERROR_PREFIX.getErrorMessage()+DUPLICATE_LOTTO_NUMBER.getErrorMessage());
        }
    }
}
