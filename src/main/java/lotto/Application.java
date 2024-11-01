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
        
        // TODO: 프로그램 구현
        List<Integer> winningNumbers = inputWinningNumbers(); // 당첨 번호 입력 받기
        int bonusNumber = inputBonusNumber(winningNumbers); // 보너스 번호 입력 받기
    }
    
    /**
     * 사용자로부터 로또 구입 금액을 입력받고 유효성 검사 후 반환
     * @return 유효한 로또 구입 금액 (1,000원 단위)
     */
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
     /**
     * 당첨 번호 입력 메서드
     * 사용자에게 6개의 중복 없는 당첨 번호를 입력받아 리스트로 반환
     * @return 유효한 6개의 당첨 번호 리스트
     */
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

    /**
     * 보너스 번호 입력 메서드
     * 사용자에게 1개의 보너스 번호를 입력받고, 유효성 검사 후 반환
     * @param winningNumbers 당첨 번호 리스트 (보너스 번호와 중복 검사에 사용)
     * @return 유효한 보너스 번호
     */
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
}
