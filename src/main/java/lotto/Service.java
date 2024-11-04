package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Service {
    private List<Lotto> buyedLotto;
    private Lotto userLotto;
    private Map<Winning, Integer> result = new HashMap<>();
    public int isValid(String input) {
        int money = Integer.parseInt(input);
        if(money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }

        return money;
    }

    public void buyLotto(int money) {
        int count = money / 1000;
        buyedLotto = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            buyedLotto.add(new Lotto(numbers));
        }
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLotto() {
        for(Lotto lotto : buyedLotto) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());

            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public Lotto validNum(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(value -> {
                    if(!value.matches("[+-]?\\d*(\\.\\d+)?")) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
                    }
                })
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        userLotto = new Lotto(numbers);
        return userLotto;
    }

    public int validBonusNum(String input) {
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        int bonusNum = Integer.parseInt(input);
        if(bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        for(int number : userLotto.getNumbers()) {
            if(number == bonusNum) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
        }

        return bonusNum;
    }

    public void calculate(Lotto userLotto, int bonusNum) {
        for(Lotto ticket : buyedLotto) {
            int count = (int)ticket.getNumbers().stream()
                    .filter(userLotto.getNumbers()::contains).count();

            boolean bonusMatch = ticket.getNumbers().contains(bonusNum);

            lottoResult(count, bonusMatch);
        }
    }

    public void lottoResult(int count, boolean bonusMatch) {
        if(count == 3) {
            result.put(Winning.FIRST, result.getOrDefault(Winning.FIRST, 0) + 1);
        }
        if(count == 4) {
            result.put(Winning.SECOND, result.getOrDefault(Winning.SECOND, 0) + 1);
        }
        if(count == 5) {
            result.put(Winning.THIRD, result.getOrDefault(Winning.THIRD, 0) + 1);
        }
        if(count == 5 && bonusMatch) {
            result.put(Winning.FOURTH, result.getOrDefault(Winning.FOURTH, 0) + 1);
        }
        if(count == 6) {
            result.put(Winning.FIFTH, result.getOrDefault(Winning.FIFTH, 0) + 1);
        }
    }

    public void printResult(int money) {
        System.out.println("당첨 통계\n---");
        NumberFormat  numberFormat = NumberFormat.getInstance(Locale.KOREA);

        for(Winning winning : Winning.values()) {
            if (winning == winning.FOURTH) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", winning.getCount(), numberFormat.format(winning.getReward()), result.getOrDefault(winning, 0));
            }

            if(winning != winning.FOURTH) {
                System.out.printf("%d개 일치 (%s원) - %d개%n", winning.getCount(), numberFormat.format(winning.getReward()), result.getOrDefault(winning, 0));
            }
        }

        double totalReward = result.entrySet().stream()
                .mapToDouble(e -> e.getKey().getReward() * e.getValue()).sum();
        double earningRate = (totalReward / money) * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);
    }
}
