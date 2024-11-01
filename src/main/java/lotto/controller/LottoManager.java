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

    }
}
