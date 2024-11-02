package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {
    public static String readInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    /**
     * 사용자의 입력을 받아서 6개의 숫자를 입력받을거야.
     * 사용자는 ,로 구분해서 숫자를 입력할거고
     * 나는  ,로 숫자를 분리해서 List<Integer>에 담을거야
     * 근데 이때 중복된 숫자가 입력되면 중복됐따고 에러를 발생할거야.
     * 그리고 숫자가 6개가 넘어가도 에러가 발생할거야
     * @return
     */
    public static List<Integer> readAndSplitWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();

        for (String splitString : Console.readLine().split(",")) {
            try {
                int number = Integer.parseInt(splitString.trim());
                if (numbers.contains(number)) {
                    throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다.");
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또번호는 1~45까지의 숫자만 입력할 수 있습니다.");
            }
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 정확히 6개를 입력해야 합니다.");
        }

        return Collections.unmodifiableList(numbers);
    }
}
