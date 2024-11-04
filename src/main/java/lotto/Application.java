package lotto;

import java.util.*;

public class Application { // 클래스 정의

    public static void main(String[] args) { // main 메소드 정의
        // TODO: 프로그램 구현
        // 1. 구입 금액 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("구입금액을 입력해 주세요: ");
        int purchaseAmount = scanner.nextInt();

        if (purchaseAmount < 1000) { // 1000원 미만 입력 시 오류 처리
            System.out.println("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
            return; // 프로그램 종료
        }

        int ticketCount = purchaseAmount / 1000; // 1000원 당 1개의 로또

        System.out.printf("%d개를 구매했습니다.%n", ticketCount);

        List<Lotto> lottoTickets = generateLottoTickets(ticketCount);

        // 만들어진 로또 번호를 출력
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }

        // 2. 당첨 번호 입력받기
        System.out.print("당첨 번호를 입력해 주세요: ");
        scanner.nextLine(); // 개행 문자 처리
        String winningNumbersInput = scanner.nextLine();
        List<Integer> winningNumbers = parseNumbers(winningNumbersInput);

        // 3. 보너스 번호를 입력받는다.
        System.out.print("보너스 번호를 입력해 주세요: ");
        int bonusNumber = scanner.nextInt();

        // 4. 당첨 통계를 출력한다.
        printWinningStatistics(lottoTickets, winningNumbers, bonusNumber);
    }

    private static List<Lotto> generateLottoTickets(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // 로또 번호를 랜덤으로 생성하는 로직
            List<Integer> numbers = generateRandomLottoNumbers();
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }

    private static List<Integer> parseNumbers(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            numbers.add(Integer.parseInt(part.trim()));
        }
        return numbers;
    }

    private static void printWinningStatistics(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        // 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");

        // 일치하는 수 통계
        int threeMatchCount = 0;
        int fourMatchCount = 0;
        int fiveMatchCount = 0;
        int fiveBonusMatchCount = 0;
        int fiveNoBonusMatchCount = 0;
        int sixMatchCount = 0;

        // 각 로또의 일치하는 숫자 개수 세기
        for (Lotto lotto : lottoTickets) {
            int matchCount = lotto.matchCount(winningNumbers); // 일치하는 번호의 개수

            // 3개 일치
            if (matchCount == 3) {
                threeMatchCount++;
                continue; // 다음 반복으로 넘어감
            }

            // 4개 일치
            if (matchCount == 4) {
                fourMatchCount++;
                continue; // 다음 반복으로 넘어감
            }

            // 5개 일치
            if (matchCount == 5) {
                fiveMatchCount++;
                if (lotto.contains(bonusNumber)) {
                    fiveBonusMatchCount++;
                } else {
                    fiveNoBonusMatchCount++; // 보너스 번호와 일치하지 않는 경우
                }
                continue; // 다음 반복으로 넘어감
            }

            // 6개 일치
            if (matchCount == 6) {
                sixMatchCount++;
            }
        }

        // 결과 출력
        System.out.printf("3개 일치 (5,000원) - %d개%n", threeMatchCount);
        System.out.printf("4개 일치 (50,000원) - %d개%n", fourMatchCount);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", fiveMatchCount);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", fiveBonusMatchCount);
        System.out.printf("5개 일치, 보너스 볼 불일치 (X원) - %d개%n", fiveNoBonusMatchCount); // 보너스 불일치 결과 출력
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", sixMatchCount);

        // 수익률 계산
        int totalPurchaseAmount = lottoTickets.size() * 1000; // 각 로또 티켓 가격 1000원
        int totalPrizeMoney = (threeMatchCount * 5000) + (fourMatchCount * 50000) +
                (fiveMatchCount * 1500000) + (fiveBonusMatchCount * 30000000) +
                (sixMatchCount * 2000000000);

        double profitRate = totalPrizeMoney / (double) totalPurchaseAmount * 100; // 수익률 계산
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static List<Integer> generateRandomLottoNumbers() {
        Random random = new Random();
        Set<Integer> lottoNumbers = new HashSet<>();

        // 6개의 랜덤한 로또 번호 생성
        while (lottoNumbers.size() < 6) {
            int number = random.nextInt(45) + 1; // 1부터 45까지의 숫자 생성
            lottoNumbers.add(number); // 중복이 없도록 Set에 추가
        }

        // Set을 List로 변환하여 반환
        List<Integer> lottoList = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoList); // 번호를 정렬하여 반환
        return lottoList;
    }
}
