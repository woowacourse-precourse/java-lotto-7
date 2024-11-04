package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    private List<Lotto> purchasedLottos;
    private Lotto userlotto;
    private Map<Prize, Integer> results = new HashMap<>();
    public int validatePurchaseAmount(String input) {
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }
    public void purchaseLottos(int amount) {
        int count = amount / 1000;
        purchasedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottos.add(new Lotto(numbers));
        }
        System.out.println(count + "개를 구매했습니다.");
    }
    public void printLottos() {
        for (Lotto lotto : purchasedLottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers()); // 수정 가능한 리스트로 복사
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }
    public Lotto validateUserNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(value -> {
                    if (!value.matches("[+-]?\\d*(\\.\\d+)?")) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
                    }
                })
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        userlotto = new Lotto(numbers);
        return userlotto;
    }
    public int validateBonusNumber(String input) {
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        int bonus = Integer.parseInt(input);
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        for(int number : userlotto.getNumbers()){
            if(number == bonus) throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        return bonus;
    }
    public void calculateResults(Lotto userlotto, int bonusNumber) {
        for (Lotto ticket : purchasedLottos) {
            int matchCount = (int) ticket.getNumbers().stream().filter(userlotto.getNumbers()::contains).count();
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
            updateResults(matchCount, bonusMatch);
        }
    }
    public void updateResults(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) {
            results.put(Prize.FIRST, results.getOrDefault(Prize.FIRST, 0) + 1);
        } else if (matchCount == 4) {
            results.put(Prize.SECOND, results.getOrDefault(Prize.SECOND, 0) + 1);
        } else if (matchCount == 5) {
            results.put(Prize.THIRD, results.getOrDefault(Prize.THIRD, 0) + 1);
        } else if (matchCount == 5 && bonusMatch) {
            results.put(Prize.FOURTH, results.getOrDefault(Prize.FOURTH, 0) + 1);
        } else if (matchCount == 6) {
            results.put(Prize.FIFTH, results.getOrDefault(Prize.FIFTH, 0) + 1);
        }
    }
    public void printResults(int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        for (Prize prize : Prize.values()) {
            if (prize == Prize.FOURTH) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", prize.getMatchCount(), numberFormat.format(prize.getReward()), results.getOrDefault(prize, 0));
            }
            if (prize != Prize.FOURTH){
                System.out.printf("%d개 일치 (%s원) - %d개%n", prize.getMatchCount(), numberFormat.format(prize.getReward()), results.getOrDefault(prize, 0));
            }        }
        double totalReward = results.entrySet().stream().mapToDouble(e -> e.getKey().getReward() * e.getValue()).sum();
        double totalEarnings = (totalReward / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", totalEarnings);
    }
}
