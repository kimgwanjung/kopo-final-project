package kr.ac.kopo.final_hanaasset360.service;

import kr.ac.kopo.final_hanaasset360.dao.LoanApplyDAO;
import kr.ac.kopo.final_hanaasset360.repository.LoanApplyRepository;
import kr.ac.kopo.final_hanaasset360.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@Service
public class LoanApplyServiceImpl implements LoanApplyService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LoanApplyDAO loanApplyDAO;

    @Autowired
    private LoanApplyRepository loanApplyRepository;
    @Override
    public List<LoanApply> getAllLoans() {
        return loanApplyDAO.getAllLoans();
    }

    public LoanApplyDetail findLoanById(Long id) {
        return loanApplyRepository.findById(id).orElse(null);
    }

    @Override
    public LoanExisting findLoanExistingById(Long loanId) {
        return loanApplyDAO.findLoanExistingById(loanId);
    }

    public LoanExisting findAPILoanExistingById(Long loanId, String bank){
        Long loanRecordId = loanApplyDAO.getLoanRecordIdById(loanId);
        if (loanRecordId == null) {
            throw new RuntimeException("No matching loanRecordId found for loanId: " + loanId);
        }

        // 2. 외부 API로 요청하기
        String apiUrl = "http://16.171.189.30:8080/gwanjung/loan-existing";

        RestTemplate restTemplate = new RestTemplate();

        // loanRecordId와 bank를 파라미터로 추가
        String fullUrl = apiUrl + "?loanRecordId=" + loanRecordId + "&bank=" + bank;

        LoanExisting result = restTemplate.getForObject(fullUrl, LoanExisting.class);

        return result;
    }


    @Override
    public ApplyUserVO findUserById(String userId) {
        return loanApplyDAO.findUserById(userId);
    }

    @Override
    public UserCreditState findCreditById(String userId) {
        return loanApplyDAO.findCreditById(userId);
    }
}
