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
        int purchaseAmount = Integer.parseInt(input);

        // 구입 횟수 만큼 로또 구매
        int count = purchaseAmount / 1000;
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
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

        for (Lotto lotto : lottos) {
            int matchCount = 0;
            for (int number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    matchCount += 1;
                }
            }
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                results.put("6개 일치 (2,000,000,000원)", results.get("6개 일치 (2,000,000,000원)") + 1);
                continue;
            }
            if (matchCount == 5 && bonusMatch) {
                results.put("5개 일치, 보너스 볼 일치 (30,000,000원)", results.get("5개 일치, 보너스 볼 일치 (30,000,000원)") + 1);
                continue;
            }
            if (matchCount == 5) {
                results.put("5개 일치 (1,500,000원)", results.get("5개 일치 (1,500,000원)") + 1);
                continue;
            }
            if (matchCount == 4) {
                results.put("4개 일치 (50,000원)", results.get("4개 일치 (50,000원)") + 1);
                continue;
            }
            if (matchCount == 3) {
                results.put("3개 일치 (5,000원)", results.get("3개 일치 (5,000원)") + 1);
                continue;
            }
            // 2개 이하 일치 시 아무 처리하지 않음
        }

        // 당첨 통계 출력
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        long totalPrize = 0;
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            String key = entry.getKey();
            int count3 = entry.getValue();
            System.out.println(key + " - " + count3 + "개");
            long prize = Long.parseLong(key.replaceAll("[^0-9]", ""));
            totalPrize += prize * count3;
        }

        // 수익률 계산 및 출력
        double rateOfReturn = (double) totalPrize / purchaseAmount * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");

    }
}
