package RandomLottoNumber;

import WinningCaculator.Caculator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NewLottoNumber {
    Caculator caculator = new Caculator();
    public void Random(List<Integer> userNumber, int buyLottoAmount, int bonus) {
        List<List<Integer>> RandomLottoNumber = new ArrayList<>();
        // 랜덤한 로또 번호 출력
        for(int i = 0; i < buyLottoAmount; i++) {
            List<Integer> PrintLottoNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
            RandomLottoNumber.add(PrintLottoNumber);
            System.out.println(PrintLottoNumber);
            }
        //로또 결과 계산
        caculator.LottoGenerateNumber(userNumber, RandomLottoNumber, bonus, buyLottoAmount);
        }
    }
