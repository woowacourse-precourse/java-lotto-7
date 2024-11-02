package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;
import lotto.global.ErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {

    int money;
    int count;
    Lotto winLotto = null;
    ArrayList<List<Integer>> lotto = new ArrayList<>();

    public void buyMoney() {
        int m = -1;
        System.out.println("구입금액을 입력해 주세요.");
        try {
            m = Integer.parseInt(Console.readLine());
            if (m <= 0) {
                throw new InputException(ErrorCode.MINUS_NUMBER_ERROR);
            }
            if (m % 1000 != 0) {
                throw new InputException(ErrorCode.DIVISION_ERROR);
            }
        } catch (InputException e) {
            buyMoney();
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력 해 주세요");
            buyMoney();
        }
        this.money = m;
        this.count = m / 1000;
    }

    public Lotto winNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
        List<Integer> numbers = new ArrayList<>();
        try {
            while (st.hasMoreTokens()) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }
            winLotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winNumber();
        }

        return winLotto;
    }

    public int bonus() {
        int number = -1;
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            number = Integer.parseInt(Console.readLine());
            winLotto.setBonusNumber(number);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            bonus();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonus();
        }

        return number;
    }
}
