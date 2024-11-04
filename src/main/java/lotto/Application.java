package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

public class Application {
    private static final int BUDGET_UNIT = 1000;

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        int budgets = inputBudgets();
    }

    private static void throwError(String message) {
        throw new IllegalArgumentException("[ERROR] " + message);
    }

    private static int inputBudgets() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return validateBudgets(Console.readLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBudgets();
        }
    }
    /** */
    private static int validateBudgets(String inputs) {
        int budgets;
        try{
            budgets = Integer.parseInt(inputs);
            if (budgets < 0) {
                throwError("구입 금액은 0 이상의 숫자여야 합니다.");
            }
            if (budgets % BUDGET_UNIT != 0) {
                throwError("구입 금액은 " + BUDGET_UNIT + " 단위여야 합니다.");
            }
            return budgets;
        } catch (NullPointerException | NoSuchElementException e) {
            throwError("구입 금액이 입력되지 않았습니다.");
        } catch (NumberFormatException e) {
            throwError("구입 금액은 2,147,483,647 이하의 숫자여야 합니다.");
        }
        return 0;
    }
}
