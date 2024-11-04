package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GetEntries {
    public static List<Integer> enterLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        for (String number : splitInput) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        lottoNumbers.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(lottoNumbers);
        return lottoNumbers;
    }

    public static int enterBonusNumber(List<Integer> enterLottoNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        boolean containNumber = enterLottoNumbers.contains(bonusNumber);
        if (containNumber) {
            throw new IllegalArgumentException("당첨 번호와 중복된 숫자입니다");
        }
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("보너스 숫자는 1 이상, 45 이하입니다.");
        }
        return bonusNumber;
    }
}
