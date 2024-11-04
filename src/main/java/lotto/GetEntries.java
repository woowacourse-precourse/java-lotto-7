package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GetEntries {
    public static String[] splitInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다.");
        }
        String[] splitInput = input.split(",");
        return splitInput;
    }

    public static List<Integer> enterLottoNumbers(String[] splitInput) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : splitInput) {
            try {
                lottoNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }
        lottoNumbers.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(lottoNumbers);
        return lottoNumbers;
    }

    public static int enterBonusNumber(List<Integer> enterLottoNumbers) {
        int bonusNumber = 0;
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine().trim();
        if (bonusNumberInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다.");
        }
        try {
            bonusNumber += Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하셨습니다");
        }
        BonusNumber bonusNumberValidate = new BonusNumber(bonusNumber, enterLottoNumbers);
        return bonusNumber;
    }
}
