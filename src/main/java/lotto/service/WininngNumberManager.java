package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.valuate.Valuate;

public class WininngNumberManager {
    private List<String> list;
    private List<Integer> list_num;
    Valuate valuate = new Valuate();
    LottoRepository lottoRepository;
    private Lotto lotto;

    public void createWinningNumber() {
        lotto = new Lotto(list_num);
        lottoRepository.saveWinningNumbers(lotto);
    }

    private void parsingWinningInput() {
        list_num = list.stream()
                .map(String::trim)
                .map(this::evaluateWinningNumber)
                .collect(Collectors.toList());
    }

    private int evaluateWinningNumber(String s) {
        valuate.isNum(s);
        return Integer.parseInt(s);
    }

    public WininngNumberManager(String s, LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
        list = Arrays.asList(s.split(","));
        parsingWinningInput();
    }

}
