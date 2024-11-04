package controller;

import domain.Lotto;
import domain.LottoGenerator;
import domain.User;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Controller {
    User user;
    Lotto lotto;
    LottoGenerator generator = new LottoGenerator();
    List<List<Integer>> lottoLists = new ArrayList<>();//로또 발행 번호
    List<Integer> lottoNumbers;
    private static int bonusNumber; //보너스 번호



    public void run() {
        buying();
        quantity();
        generator();
        getLottoNumbers();
        getBonusNumber();
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

    private void getLottoNumbers() {
        OutputView.outLottoNumbers();
        List<Integer> numbers;
        try {
            numbers = LottoNumbers();
            lotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 숫자를 입력해주세요.");
            getLottoNumbers();
        }
    }

    private List<Integer> LottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        String inputLottoNumbers = InputView.inputLottoNumbers(); //입력 받음
        String[] splitedNumbers = inputLottoNumbers.split(",");
        checkExceptionNumbers(splitedNumbers, numbers);
        return numbers;
    }

    private void checkExceptionNumbers(String[] splitedNumbers, List<Integer> numbers) {
        for (String splitedNumber : splitedNumbers) {
            int number;
            try {
                number = Integer.parseInt(splitedNumber);
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException();
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void getBonusNumber() {
        OutputView.outBonusNumber();
        String bonus = InputView.inputBonusNumber();
        lottoNumbers = lotto.getLottoNumbers();
        try {
            checkExceptionBonusNumber(bonus, lottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 보너스 번호를 입력해주세요.");
            getBonusNumber();
        }
    }

    private void checkExceptionBonusNumber(String bonus, List<Integer> lottoNumbers) {
        try {
            bonusNumber = Integer.parseInt(bonus);
            numberRange();
            duplicateNumber(lottoNumbers);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바른 보너스 번호를 입력해주세요.");
            getBonusNumber();
        }
    }

    private void duplicateNumber(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            if (lottoNumber == bonusNumber) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void numberRange() {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }


}
