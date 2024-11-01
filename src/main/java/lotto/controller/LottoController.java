package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.RandomLotto;
import lotto.utils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoController {
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final RandomLotto randomLotto = new RandomLotto();
    private static List<Integer> numbers;

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        // Amount 설정
        int amount = inputAmount();
        OutputView.printAmount(amount);

        // 갯수만큼의 랜덤 복권 생성
        setLottoNumbers(amount);
        OutputView.printLottoNumbers(lottos);

        // WinningNumbers 입력
        Lotto winningNumbers = inputWinningNum();
        OutputView.printLottoNumber(winningNumbers);
    }

    private int inputAmount() {
        try {
            LottoAmount lottoAmount = new LottoAmount(InputView.inputAmount());
            return lottoAmount.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }

    private void setLottoNumbers(int amount) {
        for (int i = 0; i < amount; i++) {
            numbers = randomLotto.setRandNumbers();
            lottos.add(new Lotto(numbers));
        }
    }

    private Lotto inputWinningNum() {
        try {
            String str = InputView.inputWinningNum();
            numbers = utils.StringToList(str);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNum();
        }
    }
}