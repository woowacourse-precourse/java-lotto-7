package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.DuplicationNumberException;
import lotto.exception.InvalidDelimiterException;
import lotto.exception.InvalidNumberRangeException;
import lotto.exception.InvalidNumberSizeException;

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

        while (true) {
            try {
                userLottoNumbers.clear();
                String userInput = Console.readLine();

                String[] userLotto = lastIndexValidation(userInput).split(",");

                for (String lotto : userLotto) {
                    int lottoNumber = Integer.parseInt(lotto);
                    userLottoNumbers.add(lottoNumber);
                }
                System.out.println(userLottoNumbers);

                return new Lotto(userLottoNumbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (InvalidDelimiterException |
                     InvalidNumberRangeException |
                     InvalidNumberSizeException |
                     DuplicationNumberException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public int inputBonusNumber() {
        int bonus;

        System.out.println("보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                bonus = Integer.parseInt(Console.readLine());
                numberRangeValidation(bonus);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (InvalidNumberRangeException e) {
                System.out.println(e.getMessage());
            }
        }
        Console.close();

        return bonus;
    }


    private void costValidation(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void numberRangeValidation(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new InvalidNumberRangeException("[ERROR] 1에서 45사이의 숫자를 입력해주세요.");
        }
    }

    public String lastIndexValidation(String userInput) {
        if (userInput.endsWith(",")) {
            throw new InvalidDelimiterException("[ERROR] 구분자가 문자열의 마지막에 위치해있습니다.");
        }
        return userInput;
    }
}
