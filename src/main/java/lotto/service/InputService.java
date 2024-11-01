package lotto.service;

import lotto.util.InputParser;
import lotto.view.InputView;

import java.util.Set;

public class InputService {
    private final InputView inputView;
    private final InputParser inputParser = new InputParser();

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public int getValidBuyInput() {
        while (true) {
            try {
                String buy = inputView.getBuy();
                return inputParser.parseBuy(buy); // 검증 및 파싱된 결과 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Set<String> getValidWinningNumInput() {
        while (true) {
            try {
                String winningNum = inputView.getWinningNum();
                return inputParser.parseWinningNumbers(winningNum); // 검증 및 파싱된 결과 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}