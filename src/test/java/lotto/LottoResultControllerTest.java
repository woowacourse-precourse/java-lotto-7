package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import lottoController.LottoResultController;


public class LottoResultControllerTest {
    private LottoResultController lottoResultController;

    @BeforeEach
    void setUp() {
        lottoResultController = new LottoResultController();
    }

    @Test
    public void saveWinningNumberTest_올바른_값() {
        String inputWinningNumber = "1,2,3,4,5,6";
        List<Integer> inputLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        lottoResultController.saveWinningNumber(inputWinningNumber);

        assertThat(lottoResultController.getWinningNumber().getNumbers()).isEqualTo(inputLottoNumber);
    }

    @Test
    public void saveWinningNumberTest_숫자가_아닌_값() {
        String inputWinningNumber = "1,2,3,4,5,q";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        lottoResultController.saveWinningNumber(inputWinningNumber);
        String outputString = outputStream.toString().trim();

        assertThat(outputString).contains("[ERORR]");
    }

    @Test
    public void saveBonusNumber_올바른_값() {
        String inputBonusNumber = "20";
        lottoResultController.saveWinningNumber("1,2,3,4,5,6");

        lottoResultController.saveBonusNumber(inputBonusNumber);
        assertThat(20).isEqualTo(lottoResultController.getBonusNumber());
    }

    @Test
    public void saveBonusNumber_중복된_번호() {
        String inputBonusNumber = "5";
        lottoResultController.saveWinningNumber("1,2,3,4,5,6");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        lottoResultController.saveBonusNumber(inputBonusNumber);

        String outputString = outputStream.toString().trim();
        assertThat(outputString).contains("[ERROR]");
    }

    @Test
    public void saveBonusNumber_범위_외_입력() {
        String inputBonusNumber = "46";
        lottoResultController.saveWinningNumber("1,2,3,4,5,6");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        lottoResultController.saveBonusNumber(inputBonusNumber);

        String outputString = outputStream.toString().trim();
        assertThat(outputString).contains("[ERROR]");
    }

    @Test
    public void saveBonusNumber_문자_입력() {
        String inputBonusNumber = "qwe";
        lottoResultController.saveWinningNumber("1,2,3,4,5,6");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        lottoResultController.saveBonusNumber(inputBonusNumber);

        String outputString = outputStream.toString().trim();
        assertThat(outputString).contains("[ERROR]");
    }

    @Test
    public void decideRank_3개_일치() {
        lottoResultController.saveWinningNumber("1,2,3,4,5,6");

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(4).isEqualTo(lottoResultController.decideRank(lotto));
    }

    @Test
    public void decideRank_4개_일치() {
        lottoResultController.saveWinningNumber("1,2,3,4,5,6");

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
        assertThat(3).isEqualTo(lottoResultController.decideRank(lotto));
    }

    @Test
    public void decideRank_5개_일치_보너스넘버_불일치() {
        lottoResultController.saveWinningNumber("1,2,3,4,5,6");
        lottoResultController.saveBonusNumber("7");

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
        assertThat(2).isEqualTo(lottoResultController.decideRank(lotto));
    }

    @Test
    public void decideRank_5개_일치_보너스넘버_일치() {
        lottoResultController.saveWinningNumber("1,2,3,4,5,6");
        lottoResultController.saveBonusNumber("7");

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(1).isEqualTo(lottoResultController.decideRank(lotto));
    }

    @Test
    public void decideRank_6개_일치() {
        lottoResultController.saveWinningNumber("1,2,3,4,5,6");

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(0).isEqualTo(lottoResultController.decideRank(lotto));
    }

    @Test
    public void testGetRankProfit() {
        assertThat(5000).isEqualTo(lottoResultController.getRankProfit(4));
        assertThat(50000).isEqualTo(lottoResultController.getRankProfit(3));
        assertThat(1500000).isEqualTo(lottoResultController.getRankProfit(2));
        assertThat(30000000).isEqualTo(lottoResultController.getRankProfit(1));
        assertThat(2000000000).isEqualTo(lottoResultController.getRankProfit(0));
    }


}
