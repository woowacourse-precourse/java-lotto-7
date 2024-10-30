package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = Integer.parseInt(input);

        // 구입 횟수 만큼 로또 구매
        int count = amount / 1000;
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");

        List<Integer> numbers = null;
        for (int i = 0; i < count; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            System.out.println(lotto.getNumbers());
        }

        // 당첨 번호 입력 받기
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input2 = Console.readLine();
        String[] inputs = input.split(",");
        Set<Integer> winningNumbers = new HashSet<>(); // 중복 없게 하려고 Set 사용
        for (String number : inputs) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                // 예외 던지자
            }
            winningNumbers.add(num);
        }

        // 보너스 번호 입력 받기
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input3 = Console.readLine();
        int bonusNumber = Integer.parseInt(input.trim());

        // 당첨, 보너스 번호와 구입한 로또 번호 비교 (당첨 여부 확인)
        Map<String, Integer> results = new LinkedHashMap<>();
        results.put("3개 일치 (5,000원)", 0);
        results.put("4개 일치 (50,000원)", 0);
        results.put("5개 일치 (1,500,000원)", 0);
        results.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        results.put("6개 일치 (2,000,000,000원)", 0);


    }
}
