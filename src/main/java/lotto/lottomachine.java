import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    public static List<Integer> drawNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static int drawBonusNumber(List<Integer> mainNumbers) {
        int bonusNumber;
        do {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        } while (mainNumbers.contains(bonusNumber));
        return bonusNumber;
    }
}