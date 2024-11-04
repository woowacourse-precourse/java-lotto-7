package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    // 통계 변수 선언
    private static int[] rankCounts = new int[LottoRank.values().length]; // 각 등수 카운트
    private static int totalSpent = 0; // 총 지출액
    private static int totalEarnings = 0; // 총 수익

    public static void main(String[] args) {
        int tickets = purchaseTickets();
        totalSpent = tickets * 1000; // 총 지출액

        List<Lotto> lottoNumbers = getLotto(tickets);
        printLottoNumber(lottoNumbers);

        List<Integer> inputNumber = numberOfLotto();
        int bonusNumber = inputBonusNumber(inputNumber);

        checkResults(inputNumber, lottoNumbers, bonusNumber);
        printStatistics();
    }

    // 로또 구매
    private static int purchaseTickets() {
        while (true) { // 무한 루프를 사용하여 유효한 입력을 받을 때까지 반복
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int tickets = Integer.parseInt(Console.readLine());
                if (tickets % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매해야 합니다.");
                }
                return tickets / 1000; // 유효한 입력인 경우 반복 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요."); // 숫자가 아닌 입력 처리
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 사용자 정의 예외 메시지 출력
            }
        }
    }



    private static void validateTicketAmount(int tickets) {
        if (tickets % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매해야 합니다.");
        }
    }

    // 로또 번호 입력
    private static List<Integer> numberOfLotto() {
        while (true) { // 무한 루프를 사용하여 유효한 입력을 받을 때까지 반복
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                validateLottoNumbers(numbers); // 중복 및 범위 검사

                return numbers; // 유효한 입력인 경우 반환
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요."); // 숫자가 아닌 입력 처리
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 사용자 정의 예외 메시지 출력
            }
        }
    }

    // 로또 번호 유효성 검사
    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 번호는 1과 45 사이여야 합니다.");
            }
        }
    }


    // 구매한 로또 번호
    private static List<Lotto> getLotto(int count) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(new Lotto(numbers));
        }
        return lottoNumbers;
    }

    // 구매한 로또 번호 출력
    private static void printLottoNumber(List<Lotto> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    // 보너스 번호 입력
    private static int inputBonusNumber(List<Integer> mainNumbers) {
        int bonusNumber;
        while (true) { // 무한 루프를 사용하여 유효한 입력이 들어올 때까지 반복
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이여야 합니다.");
                }
                if (mainNumbers.contains(bonusNumber)) { // 중복 체크
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                break; // 모든 검사를 통과하면 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }


    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이여야 합니다.");
        }
    }

    // 로또 번호 비교 및 결과 확인
    private static void checkResults(List<Integer> inputNumber, List<Lotto> lottoNumbers, int bonusNumber) {
        for (Lotto lotto : lottoNumbers) {
            int matchCount = compareNumber(inputNumber, lotto.getNumbers());
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            updateStatistics(matchCount, hasBonus);
        }
    }

    // 로또 번호 비교
    private static int compareNumber(List<Integer> inputNumber, List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (int number : inputNumber) {
            if (lottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    // 통계 결과 업데이트
    private static void updateStatistics(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            rankCounts[LottoRank.FIRST.ordinal()]++;
            totalEarnings += LottoRank.FIRST.getPrize();
        }
        if (matchCount == 5) {
            rankCounts[hasBonus ? LottoRank.SECOND.ordinal() : LottoRank.THIRD.ordinal()]++;
            totalEarnings += hasBonus ? LottoRank.SECOND.getPrize() : LottoRank.THIRD.getPrize();
        }
        if (matchCount == 4) {
            rankCounts[LottoRank.FOURTH.ordinal()]++;
            totalEarnings += LottoRank.FOURTH.getPrize();
        }
        if (matchCount == 3) {
            rankCounts[LottoRank.FIFTH.ordinal()]++;
            totalEarnings += LottoRank.FIFTH.getPrize();
        }
    }

    // 당첨 통계 출력
    private static void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");

        // 원하는 순서대로 출력
        System.out.printf("3개 일치 (%,d원) - %d개%n", LottoRank.FIFTH.getPrize(), rankCounts[LottoRank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (%,d원) - %d개%n", LottoRank.FOURTH.getPrize(), rankCounts[LottoRank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (%,d원) - %d개%n", LottoRank.THIRD.getPrize(), rankCounts[LottoRank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n", LottoRank.SECOND.getPrize(), rankCounts[LottoRank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (%,d원) - %d개%n", LottoRank.FIRST.getPrize(), rankCounts[LottoRank.FIRST.ordinal()]);

        // 총 수익률 계산 및 출력
        int totalPrize = totalEarnings; // 총 상금
        double profitRate = (double) totalPrize / totalSpent * 100; // 수익률 계산
        System.out.printf("총 수익률은 %.2f%%입니다.%n", profitRate);
    }
}
