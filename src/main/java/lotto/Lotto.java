package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

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

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    public List<Lotto> number_generator(int n) {
        List<Lotto> lottos = new ArrayList<>();
        while (n-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public void number_print() {
        String message = "[";
        for (int n : this.numbers) {
            message += n + ", ";
        }
        message = message.substring(0, message.length() - 2) + "]";
        System.out.println(message);
    }

    public int number_matching(Lotto win_Num) {
        int match;
        Set<Integer> matching_count = new HashSet<>(this.numbers);
        matching_count.retainAll(win_Num.numbers);
        match = matching_count.size();
        return match;
    }

    public boolean bonus_matching(int bonus_Num) {
        boolean match = false;
        for (int n : this.numbers) {
            if(n == bonus_Num) {
                match = true;
            }
        }
        return match;
    }

}
