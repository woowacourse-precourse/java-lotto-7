package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {
    @Test
    void getValidatedWinningNumbers_형식에_맞는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings = { "1", "2", "3", "4", "5", "6" };

        ArrayList<Integer> validatedWinningNumbers = lottoNumbers.getValidatedWinningNumbers(strings);

        assertThat(validatedWinningNumbers).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void getValidatedWinningNumbers_개수가_맞지_않는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings1 = { "1", "2", "3", "4", "5" };
        String[] strings2 = { "1", "2", "3", "4", "5", "6", "7" };

        assertThatThrownBy(() -> lottoNumbers.getValidatedWinningNumbers(strings1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoNumbers.getValidatedWinningNumbers(strings2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getValidatedWinningNumbers_정수로_변환_불가능한_문자열이_포함된_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings = { "1", "2", "3", "d", "5", "6"};

        assertThatThrownBy(() -> lottoNumbers.getValidatedWinningNumbers(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getValidatedWinningNumbers_범위를_벗어나는_값이_포함된_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings = { "1", "200", "3", "4", "5", "6"};

        assertThatThrownBy(() -> lottoNumbers.getValidatedWinningNumbers(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getValidatedWinningNumbers_중복되는_값이_포함된_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings = { "1", "2", "3", "4", "5", "2"};

        assertThatThrownBy(() -> lottoNumbers.getValidatedWinningNumbers(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumbers_형식에_맞는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings = { "1", "2", "3", "4", "5", "6" };

        assertThatNoException().isThrownBy(() -> lottoNumbers.validateWinningNumbers(strings));
    }

    @Test
    void validateWinningNumbers_개수가_맞지_않는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings1 = { "1", "2", "3", "4", "5" };
        String[] strings2 = { "1", "2", "3", "4", "5", "6", "7" };

        assertThatThrownBy(() -> lottoNumbers.validateWinningNumbers(strings1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoNumbers.validateWinningNumbers(strings2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumbers_정수로_변환_불가능한_문자열이_포함된_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings = { "1", "2", "3", "d", "5", "6"};

        assertThatThrownBy(() -> lottoNumbers.validateWinningNumbers(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumbers_범위를_벗어나는_값이_포함된_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings = { "1", "200", "3", "4", "5", "6"};

        assertThatThrownBy(() -> lottoNumbers.validateWinningNumbers(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumbers_중복되는_값이_포함된_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings = { "1", "2", "3", "4", "5", "2"};

        assertThatThrownBy(() -> lottoNumbers.validateWinningNumbers(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseIntWinningNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        String[] strings = { "1", "2", "3", "4", "5", "6"};

        ArrayList<Integer> winningNumbers = lottoNumbers.parseIntWinningNumbers(strings);

        assertThat(winningNumbers).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void getValidatedBonusNumber_형식에_맞는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String string = "10";

        int bonusNumber = lottoNumbers.getValidatedBonusNumber(winningNumbers, string);

        assertThat(bonusNumber).isEqualTo(10);
    }

    @Test
    void getValidatedBonusNumber_정수로_변환_불가능한_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String string = "abc";

        assertThatThrownBy(() -> lottoNumbers.getValidatedBonusNumber(winningNumbers, string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getValidatedBonusNumber_범위를_벗어나는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String string1 = "-1";
        String string2 = "55";

        assertThatThrownBy(() -> lottoNumbers.getValidatedBonusNumber(winningNumbers, string1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoNumbers.getValidatedBonusNumber(winningNumbers, string2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getValidatedBonusNumber_당첨_번호와_중복되는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String string = "4";

        assertThatThrownBy(() -> lottoNumbers.getValidatedBonusNumber(winningNumbers, string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumber_형식에_맞는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String string = "10";

        assertThatNoException().isThrownBy(() -> lottoNumbers.validateBonusNumber(winningNumbers, string));
    }

    @Test
    void validateBonusNumber_정수로_변환_불가능한_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String string = "abc";

        assertThatThrownBy(() -> lottoNumbers.validateBonusNumber(winningNumbers, string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumber_범위를_벗어나는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String string1 = "-1";
        String string2 = "55";

        assertThatThrownBy(() -> lottoNumbers.validateBonusNumber(winningNumbers, string1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoNumbers.validateBonusNumber(winningNumbers, string2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumber_당첨_번호와_중복되는_입력() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String string = "4";

        assertThatThrownBy(() -> lottoNumbers.validateBonusNumber(winningNumbers, string))
                .isInstanceOf(IllegalArgumentException.class);
    }
}