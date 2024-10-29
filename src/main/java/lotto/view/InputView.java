package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.TreeSet;

public class InputView {
    public TreeSet<Integer> inputLottoNumber() {
        TreeSet<Integer> inputLottoNumbers = new TreeSet<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();

        String[] LottoNumbers = numbers.split(",");

        for (String number : LottoNumbers) {
            inputLottoNumbers.add(Integer.valueOf(number.trim()));
        }

        return inputLottoNumbers;

    }

}
