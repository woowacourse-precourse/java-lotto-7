package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    public int inputCost() {
        int cost;

        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                cost = Integer.parseInt(Console.readLine());

                costValidation(cost);

                break;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
            }
        }

        return cost;
    }

    public Lotto inputPurchaseLottos() {
        List<Integer> userLottoNumbers = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");

        String[] userLotto = Console.readLine().split(",");

        for (String lotto : userLotto) {
            userLottoNumbers.add(Integer.parseInt(lotto));
        }

        return new Lotto(userLottoNumbers);
    }

    public int inputBonusNumber() {
        int bonus;

        System.out.println("보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                bonus = Integer.parseInt(Console.readLine());

                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }
        }

        return bonus;
    }


    private void costValidation(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
