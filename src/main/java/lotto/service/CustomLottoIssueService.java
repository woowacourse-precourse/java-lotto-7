package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.model.db.Buyer;
import lotto.model.db.UserRepository;
import lotto.exception.BusinessException;
import lotto.util.ConsoleInput;

public class CustomLottoIssueService implements LottoIssueService {

    protected final UserRepository userRepository = UserRepository.getInstance();

    @Override
    public List<Lotto> issue(String prompt, int lottoCnt) {
        List<Lotto> lotties = IntStream.range(0, lottoCnt)
                .mapToObj(lotto -> issue(prompt))
                .toList();
        userRepository.save(Buyer.from(lotties));
        return lotties;
    }

    @Override
    public Lotto issue(String prompt) {
        Lotto lotto = null;
        while (lotto == null) {
            lotto = getCustomLotto(prompt);
        }
        return lotto;
    }

    protected Lotto getCustomLotto(String prompt) {
        Lotto lotto = null;
        try {
            String inputNums = ConsoleInput.getStringWithQuestion(prompt);
            List<Integer> numbers = parseLottoNums(inputNums);
            validateLottoNumRange(numbers);
            lotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return lotto;
    }

    protected void validateLottoNumRange(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumRange);
    }

    protected void validateLottoNumRange(int num) {
        if (num < 1 || num > 45) {
            throw new BusinessException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static List<Integer> parseLottoNums(String inputNums) {
        return Arrays.stream(inputNums.split(","))
                .mapToInt(Integer::parseInt).boxed().toList();
    }
}
