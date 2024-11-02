package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int lottoCount = purchaseAmount / 1000;
        
        System.out.println(lottoCount + "개를 구매했습니다.");
        
        // 당첨 번호와 보너스 번호 입력
        List<Integer> winningNumbers = inputWinningNumbers(); // 당첨 번호 입력 받기
        int bonusNumber = inputBonusNumber(winningNumbers); // 보너스 번호 입력 받기

        // 구매한 로또 티켓 입력받기
        List<Lotto> userTickets = inputUserTickets(lottoCount); // 로또 번호 생성
        calculateResults(userTickets, winningNumbers, bonusNumber); // 당첨 결과 계산
    }
    
    private static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.print("구입금액을 입력해 주세요: ");
                int amount = Integer.parseInt(Console.readLine());
                
                // 1,000원 단위로 나누어 떨어지지 않으면 예외 발생
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                
                return amount; // 유효한 금액 반환
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자로 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력 후 재입력
            }
        }
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분):");
        String input = Console.readLine();
        String[] splitInput = input.split(",");

        if (splitInput.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        List<Integer> winningNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>(); // 중복 체크용

        for (String numberStr : splitInput) {
            int number = Integer.parseInt(numberStr.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!uniqueNumbers.add(number)) { // 중복된 번호 확인
                throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호가 있습니다.");
            }
            winningNumbers.add(number);
        }

        return winningNumbers;
    }

    private static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요:");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        return bonusNumber;
    }

    private static List<Lotto> inputUserTickets(int count) {
        List<Lotto> userTickets = new ArrayList<>();

        System.out.println("구매한 로또 번호를 입력해 주세요 (쉼표로 구분하여 6개):");
        for (int i = 0; i < count; i++) {
            String input = Console.readLine();
            String[] splitInput = input.split(",");
            List<Integer> numbers = new ArrayList<>();

            if (splitInput.length != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }

            Set<Integer> uniqueNumbers = new HashSet<>();

            for (String numberStr : splitInput) {
                int number = Integer.parseInt(numberStr.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (!uniqueNumbers.add(number)) {
                    throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
                }
                numbers.add(number);
            }

            userTickets.add(new Lotto(numbers));
        }

        return userTickets;
    }

    private static void calculateResults(List<Lotto> userTickets, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCount = new int[6]; // 각 등수별 일치 개수 저장 (3~6개 일치)

        for (Lotto ticket : userTickets) {
            int match = countMatches(ticket, winningNumbers);
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);

            if (match == 6) {
                matchCount[5]++;
            } else if (match == 5 && bonusMatch) {
                matchCount[4]++;
            } else if (match == 5) {
                matchCount[3]++;
            } else if (match == 4) {
                matchCount[2]++;
            } else if (match == 3) {
                matchCount[1]++;
            }
        }

        printResults(matchCount);
    }

    private static int countMatches(Lotto ticket, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : ticket.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static void printResults(int[] matchCount) {
        System.out.println("당첨 결과:");
        System.out.println("3개 일치 (5,000원) - " + matchCount[1] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCount[2] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCount[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCount[4] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCount[5] + "개");
    }
}
