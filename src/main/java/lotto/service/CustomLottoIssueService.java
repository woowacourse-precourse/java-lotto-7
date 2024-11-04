package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.exception.BusinessException;
import lotto.exception.ErrorMessage;
import lotto.model.db.Buyer;
import lotto.model.db.Lotto;
import lotto.model.db.UserRepository;
import lotto.util.ConsoleInput;

public class CustomLottoIssueService implements LottoIssueService {

    public static final String LOTTO_NUM_DELIMITERS = ",";

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
            lotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return lotto;
    }

    private List<Integer> parseLottoNums(String inputNums) {
        return Arrays.stream(inputNums.split(LOTTO_NUM_DELIMITERS))
                .map(this::parseLottoNum)
                .collect(Collectors.toList());
    }

    protected int parseLottoNum(String num) {
        int lottoNum;
        try {
            lottoNum = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new BusinessException(ErrorMessage.INVALID_LOTTO_NUM_FORMAT);
        }
        validateLottoNumRange(lottoNum);
        return lottoNum;
    }

    protected void validateLottoNumRange(int num) {
        if (num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM) {
            throw new BusinessException(ErrorMessage.INVALID_LOTTO_NUM_RANGE);
        }
    }
}
