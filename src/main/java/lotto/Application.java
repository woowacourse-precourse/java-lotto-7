package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        System.out.println();
        String moneyRegex = "[1-9][0-9]*000";

        if(!inputMoney.matches(moneyRegex)) {
            throw new IllegalArgumentException("구매입력이 맞지 않습니다.");
        }

        long money = Long.parseLong(inputMoney);

        long count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");

        //해당 개수에 맞는 로또 생성하기
        List<Lotto> lottos = new ArrayList<>();
        for(long i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        lottos.forEach(Lotto::printNumber);


        //당첨 번호 입력하기
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        System.out.println();
        String regexLottoNumber = "[1-9]|[1-3][0-9]|4[0-5]";
        String regexWinningNumber = "([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5])){5}";

        if(!winningNumber.matches(regexWinningNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        List<Integer> winnings = Arrays.stream(winningNumber.split(",")).mapToInt(Integer::valueOf).boxed().toList();
        if(new HashSet<>(winnings).size() < 6) {
            throw new IllegalArgumentException("중복된 숫자가 없어야 합니다.");
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        System.out.println();

        if(!bonus.matches(regexLottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (Lotto lotto : lottos) {
            int rank = lotto.getWinningNumber(winnings, Integer.parseInt(bonus));

            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }

        int[] prizeMoney = new int[]{2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000};

        int sum = 0;
        for(int i = 0; i < prizeMoney.length; i++) {
            sum += map.getOrDefault(i + 1, 0) * prizeMoney[i];
        }
        double ratio = ((double) sum / money) * 100;
        String[] result = {
                "3개 일치 (5,000원) - ",
                "4개 일치 (50,000원) - ",
                "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                "6개 일치 (2,000,000,000원) - ",
        };
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i] + map.getOrDefault(result.length - i, 0) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f", ratio) +"%입니다.");
    }
}
