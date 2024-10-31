package lotto;

import constants.Constants;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoInput {
    public int purchaseInput() {
        System.out.println("구입금액을 " + Constants.LOTTO_PRICE + " 원 단위로 입력해 주세요.");

        try {
            int purchasePrice = Integer.parseInt(Console.readLine());
            if (purchasePrice % Constants.LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + Constants.LOTTO_PRICE + " 원 단위로 입력해 주세요.");
            }
            if(purchasePrice < Constants.LOTTO_PRICE) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + Constants.LOTTO_PRICE + " 원 이상이어야 합니다.");
            }
            return purchasePrice;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해 주세요.");
            return purchaseInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseInput();
        }
    }

    public Lotto mainNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요 (예: 1,2,3,4,5,6):");

        try {
            String input = Console.readLine();
            List<Integer> mainNumbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (mainNumbers.size() != Constants.LOTTO_MAIN_COUNT) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + Constants.LOTTO_MAIN_COUNT + "개여야 합니다.");
            }
            Set<Integer> uniqueNumbers = new HashSet<>(mainNumbers);
            if (uniqueNumbers.size() != mainNumbers.size()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
            }
            for (int number : mainNumbers) {
                if (number < Constants.LOTTO_MIN_NUMBER || number > Constants.LOTTO_MAX_NUMBER) {
                    throw new IllegalArgumentException("[ERROR] 유효한 범위 내의 로또 번호를 입력하여야 합니다.");
                }
            }

            return new Lotto(mainNumbers);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해 주세요.");
            return mainNumbersInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return mainNumbersInput();
        }
    }

    public int bonusNumberInput(List<Integer> mainNumbers) {
        System.out.println("보너스 번호를 입력해 주세요:");

        try {
            int bonusNumber = Integer.parseInt(Console.readLine());

            if (bonusNumber < Constants.LOTTO_MIN_NUMBER || bonusNumber > Constants.LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 유효한 범위 내의 로또 번호를 입력하여야 합니다.");
            }
            if (mainNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해 주세요.");
            return bonusNumberInput(mainNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumberInput(mainNumbers);
        }
    }
}
