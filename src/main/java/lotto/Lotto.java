package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // 로또 구입 금액을 입력받고 로또 개수를 계산
        int purchaseAmount = getPurchaseAmount();
        int lottoCount = calculateLottoCount(purchaseAmount);

        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
        
        List<Lotto> userTickets = generateRandomTickets(lottoCount); // 랜덤 로또 번호 생성
        printTickets(userTickets); // 생성된 로또 번호 출력
    
        System.out.println();
        List<Integer> winningNumbers = inputWinningNumbers(); // 당첨 번호 입력 받기
        System.out.println();
        int bonusNumber = inputBonusNumber(winningNumbers); // 보너스 번호 입력 받기

        System.out.println(); // 한 줄 공백 추가
        System.out.println("당첨 통계"); // 당첨 통계 제목 출력
        System.out.println("---"); // 구분선 출력

        calculateResults(userTickets, winningNumbers, bonusNumber, purchaseAmount); // 당첨 결과 계산
    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.print("구입금액을 입력해 주세요: ");
                int amount = Integer.parseInt(Console.readLine());
                validateAmount(amount); // 유효성 검사
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자로 입력해 주세요."); // 숫자가 아닐 경우
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 유효성 검사 실패 시
            }
        }
    }

    // 구입 금액이 1,000원 단위인지 확인
    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 구입 금액에 따라 로또 개수를 계산
    private static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / 1000; // 로또 개수 계산
    }

    // 당첨 번호를 입력받는 메서드
    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분):");
        String input = Console.readLine();
        return parseWinningNumbers(input); // 입력 번호로 당첨번호 리스트 반환
    }

    // 입력된 당첨 번호로 유효성 검사
    private static List<Integer> parseWinningNumbers(String input) {
        String[] splitInput = input.split(","); // 쉼표로 분리
        validateWinningNumbers(splitInput); // 유효성 검사
    
        List<Integer> winningNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>(); // 중복 체크를 위한 Set
    
        for (String numberStr : splitInput) { // 각 번호별 유효성 검사
            int number = Integer.parseInt(numberStr.trim()); // 공백 제거 후 정수로 변환
            validateNumberRange(number); // 번호 범위 검사
            checkDuplicate(uniqueNumbers, number); // 중복 체크 메서드 호출
            winningNumbers.add(number); // 유효 번호 추가
        }
        return winningNumbers;
    }
    
    // 중복 번호 체크
    private static void checkDuplicate(Set<Integer> uniqueNumbers, int number) {
        if (!uniqueNumbers.add(number)) { // Set 추가 불가 시 중복
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호가 있습니다."); // 3단계
        }
    }

    // 당첨 번호의 개수 확인
    private static void validateWinningNumbers(String[] splitInput) {
        if (splitInput.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    // 당첨 번호의 범위 확인
    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 보너스 번호를 입력받음
    private static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요:");
        try {
            int bonusNumber = readAndParseNumber(); // 번호 읽기
            validateBonusNumber(bonusNumber, winningNumbers); // 보너스 번호 유효성 검사
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수값이어야 합니다.");
        }
    }
    
    // 사용자로부터 번호를 읽어 파싱
    private static int readAndParseNumber() throws NumberFormatException {
        String input = Console.readLine().trim(); // 공백 제거
        return Integer.parseInt(input);
    }
    
    // 보너스 번호 유효성 검사
    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateNumberRange(bonusNumber); // 범위 검사
        if (winningNumbers.contains(bonusNumber)) { // 당첨 번호와 중복 검사
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
    
    // 랜덤 로또 번호 생성
    private static List<Lotto> generateRandomTickets(int count) {
        List<Lotto> userTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            userTickets.add(new Lotto()); // 생성자에서 랜덤 번호 생성
        }
        return userTickets;
    }

    // 생성 로또 번호 출력
    private static void printTickets(List<Lotto> userTickets) {
        for (Lotto ticket : userTickets) {
            System.out.println(ticket.getNumbers()); // 생성된 로또 번호 출력
        }
    }

    // 당첨 결과 계산 후 출력
    private static void calculateResults(List<Lotto> userTickets, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        int[] matchCount = calculateMatchCounts(userTickets, winningNumbers, bonusNumber); // 일치하는 번호 수 계산
        printResults(matchCount); // 결과 출력
        double yield = calculateYield(matchCount, purchaseAmount); // 수익률 계산
        System.out.printf("총 수익률은 %.2f%%입니다.\n", yield); // 수익률 출력
    }

    // 사용자의 로또와 당첨 번호의 일치 수를 계산하는 메서드
    private static int[] calculateMatchCounts(List<Lotto> userTickets, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCount = new int[LottoRank.values().length]; // 각 등수별 일치 수
        for (Lotto ticket : userTickets) {
            LottoRank rank = calculateRank(ticket, winningNumbers, bonusNumber); // 등수 계산
            if (rank != null) {
                matchCount[rank.ordinal()]++; // 해당 등수 일치 수 증가
            }
        }
        return matchCount;
    }

    // 사용자의 로또와 당첨 번호 및 보너스 번호를 비교하여 등수를 계산
    private static LottoRank calculateRank(Lotto ticket, List<Integer> winningNumbers, int bonusNumber) {
        int match = countMatches(ticket, winningNumbers); // 일치하는 번호 수 계산
        boolean bonusMatch = ticket.getNumbers().contains(bonusNumber); // 보너스 번호 일치 여부
        return LottoRank.valueOf(match, bonusMatch); // 등수 반환
    }

    // 일치하는 번호 수를 계산하는 메서드
    private static int countMatches(Lotto ticket, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : ticket.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++; // 번호가 당첨 번호에 포함되면 일치 수 증가
            }
        }
        return matchCount;
    }

    // 각 등수별 결과를 출력하는 메서드
    private static void printResults(int[] matchCount) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NO_RANK) {
                System.out.println(rank.getDescription() + " - " + matchCount[rank.ordinal()] + "개"); // 등수와 일치 수 출력
            }
        }
    }

    // 수익률을 계산하는 메서드
    private static double calculateYield(int[] matchCount, int purchaseAmount) {
        int totalPrize = 0; // 총 당첨 금액 초기화
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += matchCount[rank.ordinal()] * rank.getPrize(); // 각 등수별 당첨 금액 누적
        }
        return ((double) totalPrize / purchaseAmount) * 100; // 수익률 계산 (퍼센트로 변환)
    }
}

// 로또 등수를 나타내는 열거형
enum LottoRank {
    NO_RANK(0, 0, ""),
    THREE_MATCH(3, 5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS_MATCH(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final int prize;
    private final String description;

     // 생성자
    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    // 당첨 금액 반환
    public int getPrize() {
        return prize;
    }

    // 등수 설명 반환
    public String getDescription() {
        return description;
    }

    // 일치하는 번호 개수와 보너스 번호 일치 여부에 따라 등수를 결정하는 메서드
    public static LottoRank valueOf(int match, boolean bonusMatch) {
        if (match == 6) return SIX_MATCH;
        if (match == 5 && bonusMatch) return FIVE_BONUS_MATCH;
        if (match == 5) return FIVE_MATCH;
        if (match == 4) return FOUR_MATCH;
        if (match == 3) return THREE_MATCH;
        return NO_RANK;
    }
}
