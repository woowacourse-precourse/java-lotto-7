package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.global.string.ErrorConstants;
import lotto.global.string.QuestionConstants;
import lotto.service.LottoService;

public class LottoController {
    private LottoService lottoService = new LottoService();

    public void getAmount() {
        System.out.println(QuestionConstants.INPUT_MONEY);
        String inputText = Console.readLine().trim();
        try {
            int money = Integer.parseInt(inputText);
            lottoService.getAmount(money);
        } catch (NumberFormatException e) {
            System.out.println(ErrorConstants.CHECK_STRING_TO_INT);
        }
    }

    public void generateLottoNumbers() {
        lottoService.generateLottoNumbers();
    }

    public void saveLottoNumber() {
        List<Integer> numbers = Arrays.stream(Console.readLine().trim().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lottoService.saveLottoNumber(numbers);
    }

    public void saveBonusNumber() {
        int bonusNum = Integer.parseInt(Console.readLine().trim());

        lottoService.saveBonusNumber(bonusNum);
    }

    public void getResult() {
        lottoService.getResult();
    }
}
