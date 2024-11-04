package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers;
        Integer specNum;
        Map<Rank, Integer> resultCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            resultCount.put(rank, 0);
        }
        Double ROI = 0d;

        System.out.println("구입금액을 입력해 주세요");
        Integer amount = Integer.valueOf(Console.readLine());

        System.out.println(amount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotto.printNumbers();
            lottos.add(lotto);
        }

        System.out.println();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                numbers = Arrays.stream(Console.readLine().split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                validate(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                specNum = Integer.valueOf(Console.readLine());
                validateOne(specNum);
                duplicateTest(numbers, specNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        for (Lotto lotto : lottos) {
            lotto.checkForWinning(numbers, specNum);
            resultCount.merge(lotto.getRank(), 1, Integer::sum);
        }

        System.out.println(
                "\n"
                        + "당청 통계\n"
                        + "---\n"
        );
        List<Map.Entry<Rank, Integer>> entries = new ArrayList<>(resultCount.entrySet());
        for (int i = 0; i < resultCount.size() - 1; i++) {
            Map.Entry<Rank, Integer> entry = entries.get(i);
            System.out.println(entry.getKey().getDescription() + " "
                    + "(" + NumberFormat.getNumberInstance().format(entry.getKey().getPrize())
                    + "원) - " + entry.getValue() + "개");
            if(entry.getValue()!=0){
                ROI += entry.getKey().getPrize();
            }
        }
        ROI = ROI/(amount*1000) * 100;
        String formattedValue = String.format("%.2f", ROI);
        System.out.println("총 수익률은"+formattedValue+"%입니다.");
    }

    static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (Integer number : numbers) {
            validateOne(number);
        }
    }

    static void duplicateTest(List<Integer> numbers, Integer number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
        }
    }

    static void validateOne(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
