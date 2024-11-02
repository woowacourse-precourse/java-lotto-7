package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Prize.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        String input_pay = readLine();
        Integer pay = Integer.valueOf(input_pay);
        Integer number_of_times = pay / 1000;
        System.out.println("\n" + number_of_times + "개를 구매했습니다.");
        List<Lotto> all_lottos = new ArrayList<>();
        for (int i = 0; i < number_of_times; i++) {
            List<Integer> marked_numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            marked_numbers.sort(Comparator.naturalOrder());
            all_lottos.add(new Lotto(marked_numbers));
            String output_one = marked_numbers.stream()
                                              .map(String::valueOf)
                                              .collect(Collectors.joining(","));
            System.out.println("[" + output_one + "]");
        }
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input_numbers = readLine();
        List<Integer> golden_numbers = Arrays.stream(input_numbers.split(","))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input_bonus = readLine();
        Integer bonus_number = Integer.getInteger(input_bonus);
        System.out.println("\n당첨 통계\n---");
        List<Integer> match_count = new ArrayList<>(Collections.nCopies(7,0));
        Integer bonus_match = 0;
        for (Lotto lotto: all_lottos) {
            Integer match = (int) golden_numbers.stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();
            match_count.set(match, match_count.get(match) + 1);
            if (match == 5 && lotto.getNumbers().contains(bonus_number)) {
                bonus_match += 1;
            }
        }

        System.out.println("3개 일치 (" + fifth.prize + "원) - " + match_count.get(3) +"개");
        System.out.println("4개 일치 (" + forth.prize + "원) - " + match_count.get(4) +"개");
        System.out.println("5개 일치 (" + third.prize + "원) - " + (match_count.get(5) - bonus_match) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + second.prize + "원) - " + bonus_match +"개");
        System.out.println("6개 일치 (" + first.prize + "원) - " + match_count.get(6) +"개");
        Double sum_prize = (double)(fifth.prize * match_count.get(3)
                        + forth.prize * match_count.get(4)
                        + third.prize * (match_count.get(5) - bonus_match)
                        + second.prize * bonus_match
                        + first.prize * match_count.get(6));
        System.out.println("총 수익률은 "+ String.format("%.1f", sum_prize / pay * 100) +"%입니다.");
    }
}
