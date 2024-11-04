package lotto;

import java.util.List;
import java.util.Scanner;

public class Lotto {
    private final List<Integer> numbers;
    private static final String GET_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

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

    // 구입 금액 입력받기
    public Integer inputPrice(){
        System.out.println(GET_PRICE_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        Integer price = scanner.nextInt();

        return price;
    }
}
