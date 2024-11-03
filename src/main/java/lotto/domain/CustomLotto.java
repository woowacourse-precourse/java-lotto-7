package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.ErrorMessage.*;

public class CustomLotto extends Lotto{
    private Integer bonus;

    public CustomLotto(List<Integer> numbers, Integer bonus) {
        super(numbers);
        this.bonus= bonus;
        LottoValidator.isDuplicateLottoAndBonus(this);
    }
    public Integer getBonus(){
        return bonus;
    }

}
