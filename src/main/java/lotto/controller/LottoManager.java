package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusLotto;
import lotto.model.Lotto;
import lotto.model.NumberParser;
import lotto.model.Price;
import lotto.view.InputView;

public class LottoManager {

    public LottoManager() {
        startLotto();
    }

    public void startLotto() {
        InputView inputView = new InputView();

        int price = NumberParser.stringToInt(inputView.price()); //구입금액 입력 받기
        new Price(price); //검사 후 저장

        List<Integer> lottoNumbers = new ArrayList<>();
        String[] winningNum = inputView.winningNumber().split(","); //당첨번호 입력 받기
        for (String num : winningNum) {
            lottoNumbers.add(NumberParser.stringToInt(num)); //정수로 변환 후 List로 전달
        }
        Lotto lotto = new Lotto(lottoNumbers); //당첨번호 검사 후 저장
        
    }
}
