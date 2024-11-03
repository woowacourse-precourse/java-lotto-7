package lotto.view;

import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoView {
    private final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmount() {
        System.out.println("로또 구입 금액을 입력하세요:");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력하세요 (쉼표로 구분):");
        String[] input = scanner.nextLine().split(",");
        return Arrays.stream(input)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력하세요:");
        return Integer.parseInt(scanner.nextLine());
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResults(Map<String, Integer> results) {
        // 출력 순서 정의
        String[] order = {
                "3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)"
        };

        System.out.println("당첨 통계");
        System.out.println("---");
        // 각 조건에 따라 결과를 출력
        for (String key : order) {
            System.out.println(key + " - " + results.get(key) + "개");
        }
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
