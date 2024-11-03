package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
    public static void run(){
        System.out.println("구입금액을 입력해 주세요.");
        inputPrice();
        List<Integer> lottos = Randoms.pickUniqueNumbersInRange(1,45,6);


        System.out.println("당첨 번호를 입력해 주세요.");

        //출력
    }

    public static int inputPrice(){
        final int price = Integer.parseInt(Console.readLine());
        if (price%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
        Console.close();
        return price;
    }

    public static List<String> splitNums(String nums){
        return List.of(nums.split(","));
    }
}
