package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoReaderTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private LottoReader lottoReader = new LottoReader();

    @Test
    void readMoney() {
        assertSimpleTest(() -> {
            run("8000");
            assertThat(lottoReader.readMoney()).isEqualTo(8000);
        });
    }

    @Test
    void readLottoNumbers() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6");
            assertThat(lottoReader.readLottoNumbers()).containsExactly(1,2,3,4,5,6);
        });
    }

    @Test
    void readBonusNumber() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6", "7");
            List<Integer> lottoNumbers = lottoReader.readLottoNumbers();
            System.out.println("lottoNumbers = " + lottoNumbers);
            assertThat(lottoReader.readBonusNumber(lottoNumbers)).isEqualTo(7);
        });
    }

    @DisplayName("기능_테스트_readMoney_에러_발생_후_계속_입력")
    @Test
    void 기능_테스트_readMoney_에러_발생_후_계속_입력() {
        assertSimpleTest(() -> {
            run(invalidMoneyInputs(), "7000");
            assertThat(lottoReader.readMoney()).isEqualTo(7000);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    private String invalidMoneyInputs() {
        List<String> invalidInputs = new ArrayList<>();
        invalidInputs.add("1000j");
        invalidInputs.add("a1b2c3");
        invalidInputs.add("");
        invalidInputs.add("    1234    ");
        invalidInputs.add("12.34");
        invalidInputs.add("999");

        return String.join("\n", invalidInputs);
    }

    @DisplayName("기능_테스트_readLottoNumbers_에러_발생_후_계속_입력")
    @Test
    void 기능_테스트_readLottoNumbers_에러_발생_후_계속_입력() {
        assertSimpleTest(() -> {
            run(invalidLottoNumberInputs(), "1,2,3,4,5,6");
            assertThat(lottoReader.readLottoNumbers()).contains(1,2,3,4,5,6);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    private String invalidLottoNumberInputs() {
        List<String> invalidInputs = new ArrayList<>();
        invalidInputs.add("1,2,3,4,5");
        invalidInputs.add("1,2,3,4,5,6,7");
        invalidInputs.add("");
        invalidInputs.add("1.2,3,4,5,6");
        invalidInputs.add("asdf,2,3,4,5,6");
        invalidInputs.add("0,2,3,4,5,6");
        invalidInputs.add("1,2,3,4,5,46");
        invalidInputs.add("1,1,3,4,5,6");

        return String.join("\n",invalidInputs);
    }

    @DisplayName("기능_테스트_readBonusNumber_에러_발생_후_계속_입력")
    @Test
    void 기능_테스트_readBonusNumber_에러_발생_후_계속_입력() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6", invalidBonusNumberInputs(), "7");
            List<Integer> lottoNumbers = lottoReader.readLottoNumbers();
            System.out.println("lottoNumbers = " + lottoNumbers);
            assertThat(lottoReader.readBonusNumber(lottoNumbers)).isEqualTo(7);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    private String invalidBonusNumberInputs() {
        List<String> invalidInputs = new ArrayList<>();
        invalidInputs.add("1.2");
        invalidInputs.add("asdf");
        invalidInputs.add("");
        invalidInputs.add("   7   ");
        invalidInputs.add("0");
        invalidInputs.add("46");
        invalidInputs.add("1");

        return String.join("\n", invalidInputs);
    }

    @Override
    protected void runMain() {

    }
}