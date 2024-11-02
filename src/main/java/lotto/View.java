package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.Integer.parseInt;

public class View {
    private final String[] instructions = {
            "구입금액을 입력해 주세요.",
            "당첨 번호를 입력해 주세요.",
            "보너스 번호를 입력해 주세요."
    };
    private final String ERROR_TEXT = "[ERROR]";
    private final LottoController lottoController = new LottoController();
    private List<Lotto> lottos;
    private Lotto winningLotto;
    private LottoRankGroups lottoRankGroups;

    public void run() {
        getPurchaseCost();
        lottoController.printLottoStatus(lottos);

        getWinningLotto(); //로또 만들어서 저장
        getBonusNumber(); //보너스 넘버 이용해서 lottoRankGroup 만든다.
        lottoController.printWinningDetails(lottoRankGroups);
        lottoController.printRateOfReturn(lottoRankGroups);

    }


    private <T> T getInput(String instruction, Function<String, T> action) {
        System.out.println(instruction);
        try {
            String input = Console.readLine();
            return action.apply(input);  // 입력값을 전달하여 결과 반환
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_TEXT + e.getMessage());
            return getInput(instruction, action);  // 재귀 호출로 재입력
        }
    }

    public void getPurchaseCost() {
        lottos = getInput(instructions[0], lottoController::purchaseLotto);
    }

    public void getWinningLotto() {
        winningLotto = getInput(instructions[1], lottoController::makeWinningLotto);
    }

    public void getBonusNumber() {
        lottoRankGroups = getInput(instructions[2], input -> lottoController.makeRankGroups(lottos, winningLotto, input));
    }


}
