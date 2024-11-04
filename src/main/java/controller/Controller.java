package controller;

import domain.LottoGenerator;
import domain.User;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Controller {
    User user;
    LottoGenerator generator = new LottoGenerator();
    List<List<Integer>> lottoLists = new ArrayList<>();//로또 발행 번호



    public void run() {
        buying();
        quantity();
        generator();
    }

    private void buying() {
        OutputView.outBuyingPriceView(); //구입 금액을 입력해주세요.
        try {
            user = new User(InputView.inputBuyingPriceView());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 정수만 입력 가능합니다.");
            buying();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000원 단위만 입력 가능합니다.");
            buying();
        }
    }

    private void quantity() {
        OutputView.outBuyingQuantityView(user.getBuyingQuantity());
    }

    private void generator() {
        for (int i = 0; i < user.getBuyingQuantity(); i++) {
            List<Integer> lottoNumbers = generator.generate();
            lottoLists.add(lottoNumbers);
            OutputView.outGenerateNumbersView(lottoNumbers);
        }
    }


}
