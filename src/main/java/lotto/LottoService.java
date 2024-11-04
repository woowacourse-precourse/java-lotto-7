package lotto;

import camp.nextstep.edu.missionutils.*;

public class LottoService {


    //로또 구입 금액 입력
    public int buy_lotto(){
        int amount = 0;
        // 에러 메시지를 출력 후 그 부분부터 다시 입력.
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                amount = Integer.parseInt(Console.readLine());
                validateAmount(amount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
            }
        }
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }

    void validateAmountForTest(int amount) {
        validateAmount(amount);
    }
}
