package lotto.dto;

import java.util.List;

public class LottoDto {
    private List<Integer> numbers;
    private int bonus;
    public LottoDto(List<Integer> numbers, int bonus){
        this.numbers = numbers;
        this.bonus = bonus;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
    public int getBonus(){
        return bonus;
    }
}
