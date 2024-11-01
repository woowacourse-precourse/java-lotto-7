package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int lottoCount = purchaseAmount / 1000;
        
        System.out.println(lottoCount + "개를 구매했습니다.");
        
        // TODO: 프로그램 구현
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
}
