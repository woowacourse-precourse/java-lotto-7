package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // 로또 구입 금액 입력
            int purchaseAmount = getPurchaseAmount(scanner);
            int lottoCount = purchaseAmount / 1000;

            // 로또 발행
            List<Lotto> purchasedLottos = generateLottos(lottoCount);
            printPurchasedLottos(purchasedLottos);

            // 당첨 번호 및 보너스 번호 입력
            List<Integer> winningNumbers = getWinningNumbers(scanner);
            int bonusNumber = getBonusNumber(scanner);

            // 당첨 내역 확인
            printWinningResults(purchasedLottos, winningNumbers, bonusNumber);
            calculateProfit(purchasedLottos, winningNumbers, bonusNumber, purchaseAmount);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int getPurchaseAmount(Scanner scanner) {
        while (true) {
            System.out.print("구입금액을 입력해 주세요.\n");

            // 사용자가 입력한 값이 정수인지 확인
            if (!scanner.hasNextInt()) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다."); // 에러 메시지 출력
                scanner.next(); // 잘못된 입력을 스킵
                continue; // 다시 입력을 받습니다.
            }

            int amount = scanner.nextInt();

            // 입력된 금액이 1,000원 단위인지 확인
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
            }

            return amount; // 유효한 금액을 반환
        }
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(LottoGenerator.generateUniqueNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> getWinningNumbers(Scanner scanner) {
        while (true) {
            System.out.print("당첨 번호를 입력해 주세요.");
            scanner.nextLine();
            String input = scanner.nextLine(); // 전체 한 줄을 읽어옵니다.

            // 빈 문자열 처리
            if (input.trim().isEmpty()) {
                System.out.println("[ERROR] 제대로 된 당첨 번호를 입력해 주세요."); // 에러 메시지 출력
                continue; // 다시 입력을 받습니다.
            }

            try {
                List<Integer> winningNumbers = LottoGenerator.parseNumbers(input); // 입력된 문자열을 파싱합니다.
                return winningNumbers; // 유효한 번호 리스트를 반환합니다.
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 발생 시 에러 메시지를 출력합니다.
            }
        }
    }

    private static int getBonusNumber(Scanner scanner) {
        while (true) {
            System.out.print("보너스 번호를 입력해 주세요.");
            int bonus = scanner.nextInt();
            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이여야 합니다.");
            }
            return bonus;
        }
    }

    private static void printWinningResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] results = new int[6];
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchCount(winningNumbers);
            if (matchCount == 6) {
                results[5]++;
            } else if (matchCount == 5 && lotto.contains(bonusNumber)) {
                results[4]++;
            } else if (matchCount == 5) {
                results[3]++;
            } else if (matchCount == 4) {
                results[2]++;
            } else if (matchCount == 3) {
                results[1]++;
            } else if (matchCount == 0) {
                results[0]++;
            }
        }

        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", results[1]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", results[2]);
        System.out.printf("5개 일치 (1,500,000원) - %dgae%n", results[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results[4]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results[5]);
    }

    private static void calculateProfit(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        int totalPrize = 0;
        totalPrize += lottos.stream().mapToInt(lotto -> lotto.getPrize(winningNumbers, bonusNumber)).sum();

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
