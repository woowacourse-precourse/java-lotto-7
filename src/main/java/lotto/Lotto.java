package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.*;

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

    //로또 구입 금액 입력
    public int buy_lotto(){
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }
}
