package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    public static final int BUDGET_UNIT = 1000;

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        int budgets = inputBudgets();

        LottoPicker lottoPicker = new LottoPicker(budgets / BUDGET_UNIT);
        lottoPicker.printLottos();

        Lotto winLotto = inputWinLotto();
        int bonusNumber = inputBonusNumber(winLotto);

    }

    private static void throwError(String message) {
        throw new IllegalArgumentException("[ERROR] " + message);
    }

    /** Get input budgets with stdin. If that input is invalid, retry */
    private static int inputBudgets() {
        System.out.println("구입 금액을 입력해 주세요.");

        try {
            return validateBudgets(Console.readLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBudgets();
        }
    }
    private static int validateBudgets(String inputs) {
        try{
            int budgets = Integer.parseInt(inputs);
            if (budgets < 0) {
                throwError("구입 금액은 0 이상 이어야 합니다.");
            }
            if (budgets % BUDGET_UNIT != 0) {
                throwError("구입 금액은 " + BUDGET_UNIT + " 단위여야 합니다.");
            }
            return budgets;
        } catch (NullPointerException | NoSuchElementException e) {
            throwError("구입 금액이 입력되지 않았습니다.");
        } catch (NumberFormatException e) {
            throwError("구입 금액은 2,147,483,647 이하인 숫자여야 합니다.");
        }
        return 0;
    }


    private static Lotto inputWinLotto() {
        System.out.println("당첨 번호를 콤마(,)를 기준으로 입력해 주세요.");

        try {
            List<Integer> winNumbers = Arrays.stream(Console.readLine().split(","))
                    .map(Application::validateLottoNumber)
                    .toList();
            return new Lotto(winNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinLotto();
        }
    }
    private static int inputBonusNumber(Lotto winLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");

        try {
            int bonusNumber = validateLottoNumber(Console.readLine().trim());
            if (winLotto.getNumbers().contains(bonusNumber)) {
                throwError("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
            }
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winLotto);
        }
    }
    private static int validateLottoNumber(String input) {
        try {
            int number = Integer.parseInt(input.trim());
            if (number < 1 || number > 45) {
                throwError("로또 번호는 1에서 45 사이의 정수여야 합니다.");
            }
            return number;
        } catch (NullPointerException | NoSuchElementException e) {
            throwError("번호가 입력되지 않았습니다.");
        } catch (NumberFormatException e) {
            throwError("로또 번호는 45 이하의 숫자여야 합니다.");
        }
        return 0;
    }
}
