package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Application {
    public static void main(String[] args) {
        // #1 티켓 구매
        int ticketCount = promptTicketCount("구입금액을 입력해 주세요.");
        System.out.println("\n" + ticketCount + "개를 구매했습니다.");
        // #2 구매 로또 번호 생성 및 당첨,보너스 번호 입력
        List<List<Integer>> allLottoNumbers = printLottoNumbers(ticketCount);
        Lotto winnerNumbers = Lotto.inputWinnerLotto("\n당첨 번호를 입력해 주세요.");
        int bonusNumber = promptBonusNumber("보너스 번호를 입력해 주세요.",winnerNumbers.getNumbers());
        // #3 당첨통계
        int[] prizeCount = calculatePrizeCount(allLottoNumbers, winnerNumbers.getNumbers(), bonusNumber);
        printPrizeStatistics(prizeCount);
        // #4 수익률
        double rateOfReturn = calculateRateOfReturn(prizeCount, ticketCount);
        System.out.println("총 수익률은 " + roundToTwoDecimalPlaces(rateOfReturn) + "%입니다.");
    }

    // 티켓 금액 필터링 메소드
    private static int promptTicketCount(String message) {
        String cashInput;
        while (true) {
            try {
                System.out.println(message);
                cashInput = Console.readLine(); // 구매입력 콘솔로 입력받음
                cashInputCheck(cashInput); // 정수 유효성 검사 메소드
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력 후 재입력
            }
        }
        return Integer.parseInt(cashInput) / 1000; // cashInput을 정수로 변환 후 장수 변환
    }

    // 티켓 금액 정수 유효성 검사
    private static void cashInputCheck(String cahsInput) {
        for (char cI : cahsInput.toCharArray()) {
            if (!Character.isDigit(cI)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 다른 숫자여야 합니다.");
            }
        }
    }

    // 로또 번호 생성 및 출력 메소드
    private static List<List<Integer>> printLottoNumbers(int ticketCount) {
        List<List<Integer>> allLottoNumbers = new ArrayList<>(); // 모든 로또 번호 저장
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 랜덤으로 로또 넘버 생성
            allLottoNumbers.add(lottoNumbers); // 각 티켓을 저장
            System.out.println(lottoNumbers); // 로또 번호 출력
        }
        return allLottoNumbers;
    }

    // 보너스 번호 입력 메소드
    private static int promptBonusNumber(String message, List<Integer> winnerNumbers) {
        int bonusNumber;

        while (true) {
            try {
                System.out.println(message);
                String lottoBonusNumberInput = Console.readLine(); // 보너스 번호 입력
                bonusNumber = Integer.parseInt(lottoBonusNumberInput);
                bonusNumberCheck(bonusNumber, winnerNumbers); // 유효성 검사 메소드
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력 후 재입력
            }
        }
        return bonusNumber;
    }

    // 보너스 번호 유효성 검사
    private static void bonusNumberCheck(int bonusNumber, List<Integer> winnerNumbers) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 다른 숫자여야 합니다.");
        }
    }


    // 당첨 여부 확인 가능한 메소드
    private static int[] countWinnerNumber(List<Integer> winnerNumbers, List<Integer> lottoNumbers, int bonusNumber) {
        int count = 0;
        int bonusCheck = 0;

        for (Integer winnerNumber : winnerNumbers) { // winnerNumbers의 각 숫자를 순회
            if (lottoNumbers.contains(winnerNumber)) { // lottoNumbers에 해당 숫자가 포함되어 있는지 확인
                count++; // 포함되어 있으면 카운트 증가
            }
        }
        if (count == 5 && lottoNumbers.contains(bonusNumber)) { // 보너스넘버가 있는지도 확인
            bonusCheck = 1;
        }
        return new int[]{count, bonusCheck}; // 일치하는 숫자 및 보너스의 개수 반환
    }

    // 당첨 통계 저장을 위한 메소드
    private static int[] calculatePrizeCount(List<List<Integer>> allLottoNumbers, List<Integer> winnerNumbers, int bonusNumber) {
        int[] prizeCount = new int[8]; // 0~6개 일치 카운트 / 7번 인덱스는 보너스카운트
        int bonusCount = 0;

        for (List<Integer> lottoNumbers : allLottoNumbers) {
            int[] matchingCountArray = countWinnerNumber(winnerNumbers, lottoNumbers, bonusNumber);
            int matchingCount = matchingCountArray[0]; // count
            prizeCount[matchingCount]++; // 일치하는 개수에 따라 카운트 증가
            if (matchingCount == 5 && matchingCountArray[1] == 1) {
                bonusCount++;
                prizeCount[5]--; // 5개+보너스 일치할 시 5개 카운트 감소
            }
        }
        prizeCount[7] = bonusCount;
        return prizeCount; // 최종 통계 배열 반환
    }

    // 통계 출력부분 메소드
    private static void printPrizeStatistics(int[] prizeCount) {
        System.out.println("\n당첨 통계\n" + "---" );  // #5 당첨 통계
        System.out.println("3개 일치 (5,000원) - " + prizeCount[3] + "개");  // 통계 출력
        System.out.println("4개 일치 (50,000원) - " + prizeCount[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount[7] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount[6] + "개");
    }

    // 소수점 둘째 자리 반올림 메소드
    private static double roundToTwoDecimalPlaces(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    // 금액 계산 메소드
    private static double calculateRateOfReturn(int[] prizeCount, int ticketCount) {
        double prizeSum = (
                5000 * prizeCount[3]
                        + 50000 * prizeCount[4]
                        + 1500000 * prizeCount[5]
                        + 30000000 * prizeCount[7]
                        + 2000000000 * prizeCount[6]);
        double rateOfReturn = (prizeSum / ticketCount) / 10;
        return rateOfReturn;
    }
}
