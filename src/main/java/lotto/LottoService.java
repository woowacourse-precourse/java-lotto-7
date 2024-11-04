package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.List;
import java.util.ArrayList;

public class LottoService {

    private Lotto lotto_nums;

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

    //당첨 번호 입력
    public Lotto win_number(String numbers) {
        while (true) {
            try {
                String[] numberStrings = numbers.split(",");
                List<Integer> numberList = new ArrayList<>();

                for (String numberString : numberStrings) {
                    numberList.add(Integer.parseInt(numberString.trim()));
                }

                lotto_nums = new Lotto(numberList);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto_nums;
    }

}
