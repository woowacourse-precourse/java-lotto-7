package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int inputMoney() {
        while (true) {
            try {
                return getValidMoney();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.\n");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = Integer.parseInt(input);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액은 1000원 단위여야 합니다.\n");
        }

        return money;  // 반환값: 구매할 수 있는 로또 티켓의 개수
    }

    public Lotto LottoNumber() {
        while (true) {
            try {
                return createLottoFromInput();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.\n");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    private Lotto createLottoFromInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> nums = new ArrayList<>();
        String[] input = Console.readLine().split(",");

        for (String num : input) {
            int parsedNum = Integer.parseInt(num.trim());
            validateNumber(parsedNum);
            nums.add(parsedNum);
        }

        return new Lotto(nums);
    }

    public int bonusNum(Lotto lotto) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                return getValidBonusNumber(lotto);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.\n");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(Lotto lotto) {
        String input = Console.readLine();
        int num = Integer.parseInt(input);
        validateNumber(num);
        checkDuplicate(lotto.getNumbers(), num);
        return num;
    }

    private void validateNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplicate(List<Integer> nums, int num) {
        if(nums.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 이미 있는 숫자입니다.");
        }
    }

}
