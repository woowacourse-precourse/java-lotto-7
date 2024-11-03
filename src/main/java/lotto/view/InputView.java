package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class InputView {
    public static int readInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 번호는 숫자만 입력할 수 있습니다.");
            return readInputMoney();
        }
    }

    public static List<Integer> readAndSplitNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();

        for (String splitString : Console.readLine().split(",")) {
            try {
                int number = Integer.parseInt(splitString.trim());

                if (number < 1 && number > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (numbers.contains(number)) {
                    throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다.");
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 번호는 숫자만 입력할 수 있습니다.");
            }
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 정확히 6개를 입력해야 합니다.");
        }

        return Collections.unmodifiableList(numbers);
    }

    public static int readBonusNumber(Lotto LottoNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자만 입력 할 수 있습니다.");
        }

        if (LottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력하신 보너스 번호는 이미 당첨 번호에 존재합니다.");
        }
        if (bonusNumber < 1 && bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }
}
