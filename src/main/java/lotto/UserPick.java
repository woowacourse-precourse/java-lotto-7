package lotto;

import java.util.List;

public class UserPick extends Lotto {
    private final int bonus;

    public UserPick(List<Integer> numbers, int bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    public int getBonus() { return bonus; }
}