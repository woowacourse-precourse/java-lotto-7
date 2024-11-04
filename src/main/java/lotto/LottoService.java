package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.List;
import java.util.ArrayList;

public class LottoService {

    private Lotto lotto_nums;

    public LottoService(Lotto lotto_nums) {
        this.lotto_nums = lotto_nums;
    }

    public LottoService() {
    }

    //로또 구입 금액 입력
    public int buy_lotto() {
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
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto_nums;
    }

    public boolean checkDuplicate(int number) {
        return lotto_nums.contains(number);
    }

    public int bonus(String number) {
        if (!(number != null && number.matches("\\d+"))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자입니다.");
        }
        int bonus_num = Integer.parseInt(number.trim());
        if (bonus_num < 1 || bonus_num >45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 값이어야 합니다.");
        }
        LottoService lottoService = new LottoService(lotto_nums);
        if (lottoService.checkDuplicate(bonus_num)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 로또 번호입니다.");
        }
        return bonus_num;
    }

}
