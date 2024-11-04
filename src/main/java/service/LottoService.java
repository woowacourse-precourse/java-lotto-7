package service;


import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;


public class LottoService {
    private Lotto getLotto(String input) {
        String[] list = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            numbers.add(Integer.parseInt(s));
        }
        return new Lotto(numbers);
    }
}
