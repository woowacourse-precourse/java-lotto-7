package lotto.controller;

import lotto.domain.*;
import lotto.service.*;
import lotto.view.*;
import lotto.util.*;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        try {
            int purcaseAmount = readPurchaseAmount();
        }

    }

    private int readPurchaseAmount() {
        String input = InputView.inputPurchaseAmount();
        return Integer.parseInt(input);
    }

}
