package lotto;

import java.util.List;

public class Application {
    public static final int one_ticket = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public void validate_division(int amount){
        if(amount % one_ticket != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다. ");
        }
    }

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
    }
}

