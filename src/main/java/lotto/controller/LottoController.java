package lotto.controller;


import lotto.view.InputView;

import java.util.List;

public class LottoController {
    public void play() {
        List<Integer> winningNumber = getWinningNumber();
    }
    
    private List<Integer> getWinningNumber() {
        try {
            return InputView.getWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }



}
