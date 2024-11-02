package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 로또 구입 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        int inputCash = Integer.parseInt(Console.readLine());
        // 1000 단위, 숫자 여부 검증 필요
        int lottoCount = inputCash / 1000;

        // 로또 생성 과정
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        // 발행한 로또 수량 및 번호 출력
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String lottoFormat = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoFormat);
        }

        // 당첨 번호 입력 받기
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(inputNumbers.split(",", -1))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 보너스 번호 입력 받기
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.parseInt(Console.readLine());
            // 유효성 검증 필요

        // 당첨 여부 확인
        int[] winningCounts = new int[7];
        Set<Integer> set1 = new HashSet<>(winningNumbers);
        for (Lotto lotto : lottos) {
            Set<Integer> set2 = new HashSet<>(lotto.getNumbers());
            set1.retainAll(set2);
            winningCounts[set1.size()]++;
            set1.addAll(winningNumbers);
        }

        // 당첨 내역 출력
        System.out.println("당첨 통계\n---");
        for (int i = 0; i < 7; i++) {
            System.out.println(i + "개 일치 (5,000원) - " + winningCounts[i] + "개");
        }
    }
}
