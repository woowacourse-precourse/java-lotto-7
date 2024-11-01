package lotto.model;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Validator.DELIMITER;

public class LottoManager {
    public Lotto generateLottoNumbers(){
        return new Lotto(pickUniqueNumbersInRange(1,45,6));
    }

    public Lotto parseWinningNumbersToLotto(String winningNumbers){
        List<Integer> numberList = Arrays.stream(winningNumbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numberList);
    }

}
