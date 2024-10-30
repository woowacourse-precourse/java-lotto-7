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
        int purchaseAmount = 0;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputAmount = Console.readLine();
                purchaseAmount = Integer.parseInt(inputAmount);
                if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                break; // 유효한 입력이 들어오면 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int lottoCount = purchaseAmount / 1000;

        // 로또 번호 생성 및 출력
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            while (true) {
                try {
                    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    Collections.sort(numbers);
                    Lotto lotto = new Lotto(numbers);
                    lottos.add(lotto);
                    System.out.println(lotto.getNumbers());
                    break; // 로또 생성이 성공하면 루프 종료
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    // 로또 생성 실패 시 다시 시도
                }
            }
        }

        // 당첨 번호 입력 받기
        Set<Integer> winningNumbers = new HashSet<>();
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputWinningNumbers = Console.readLine();
                String[] splitWinningNumbers = inputWinningNumbers.split(",");
                if (splitWinningNumbers.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                }
                for (String numStr : splitWinningNumbers) {
                    int num = Integer.parseInt(numStr.trim());
                    if (num < 1 || num > 45) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    if (!winningNumbers.add(num)) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
                    }
                }
                break; // 유효한 당첨 번호가 입력되면 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
                winningNumbers.clear(); // 잘못된 입력 시 집합 초기화
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumbers.clear(); // 잘못된 입력 시 집합 초기화
            }
        }

        // 보너스 번호 입력 받기
        int bonusNumber = 0;
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                bonusNumber = Integer.parseInt(inputBonusNumber.trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                break; // 유효한 보너스 번호가 입력되면 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 당첨 결과 계산
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
                    matchCount++;
                }
            }
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            // 당첨 등수 판단
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
        }

        // 당첨 통계 출력
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        long totalPrize = 0;
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            System.out.println(key + " - " + count + "개");
            long prize = Long.parseLong(key.replaceAll("[^0-9]", ""));
            totalPrize += prize * count;
        }

        // 수익률 계산 및 출력
        double rateOfReturn = (double) totalPrize / purchaseAmount * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
