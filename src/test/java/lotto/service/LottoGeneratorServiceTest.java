package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoGeneratorServiceTest {
    private LottoGeneratorService lottoGeneratorService;

    @BeforeEach
    void setUp() {
        this.lottoGeneratorService = new LottoGeneratorService();
    }

    @Test
    void 범위_안의_6개의_숫자리스트_반환() {
        List<Integer> list = lottoGeneratorService.generateSixNumbers();
        assertEquals(6, list.size());
        for (Integer number : list) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @Test
    void 여섯개의_숫자_정렬(){
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(3);
        list = lottoGeneratorService.sortNumbers(list);
        for(Integer number : list){
            System.out.println(number);
        }
    }

    @Test
    public void 여덟개_로또번호_생성_테스트(){
        List<Lotto> lotos = lottoGeneratorService.generateLotto(8);
        for(Lotto lotto : lotos){
            lotto.printNumbers();
        }
    }
}