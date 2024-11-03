package Input;

import java.util.ArrayList;
import java.util.List;

import RandomLottoNumber.NewLottoNumber;
import camp.nextstep.edu.missionutils.Console;
import lotto.BonusLotto;
import lotto.Lotto;

public class InputLottoNumber {
    NewLottoNumber newLottoNumber = new NewLottoNumber();

    public void LottoNumber(int buyLottoAmount) {
        //사용자 당첨번호 저장
        List<Integer> userLottoNumbers = new ArrayList<>();

        //사용자의 당첨 번호 입력
        // System.out.println("로또 번호를 입력하세요");
        String UserLottoNumber = Console.readLine();
        //사용자의 당첨번호를 쉼표 기준으로 나눔
        for (String num : UserLottoNumber.split(",")) {
            userLottoNumbers.add(Integer.parseInt(num.trim()));
        }
        // 사용자 당첨번호 검증
        Lotto validate = new Lotto(userLottoNumbers);
        // 사용자 보너스 번호 입력
        // System.out.println("보너스 번호를 입력하세요");
        int UserBonusNumber = Integer.parseInt(Console.readLine());
        // 사용자 보너스 번호 검증
        BonusLotto bonusNumberValidate = new BonusLotto(UserBonusNumber, userLottoNumbers);
        //중복값 찾기
        newLottoNumber.Random(userLottoNumbers, buyLottoAmount, UserBonusNumber);
    }
}