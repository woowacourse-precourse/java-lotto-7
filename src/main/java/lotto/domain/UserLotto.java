package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserLotto {
    private Lotto Winning_Lotto;
    private int bonus_Number;

    public UserLotto(Lotto Winning_Lotto, int bonus_Number) {
        this.Winning_Lotto = Winning_Lotto;
        this.bonus_Number = bonus_Number;
    }

    public Lotto getWinning_Lotto() {
        return Winning_Lotto;
    }
    public int getBonus_Number() {
        return bonus_Number;
    }

    private void check_Size_validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    private void check_Overlap_validate(List<Integer> numbers) {
            Set<Integer> lotto_numbers = new HashSet<>();
            for (int number : numbers) {
                if (!lotto_numbers.add(number)) throw new IllegalArgumentException("[ERROR] 로또에 중복된 숫자가 없어야 합니다.");
            }
    }

}
