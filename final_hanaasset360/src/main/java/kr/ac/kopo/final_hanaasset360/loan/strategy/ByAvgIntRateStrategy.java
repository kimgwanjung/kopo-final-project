package kr.ac.kopo.final_hanaasset360.loan.strategy;

import kr.ac.kopo.final_hanaasset360.loan.dao.LoanDAO;
import kr.ac.kopo.final_hanaasset360.loan.vo.LoanProductVO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ByAvgIntRateStrategy implements LoanProductStrategy {
    private LoanDAO loanDAO;

    public ByAvgIntRateStrategy(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    @Override
    public List<LoanProductVO> execute() {
        List<LoanProductVO> products = loanDAO.fetchLoanProducts();
        Collections.sort(products, Comparator.comparing(LoanProductVO::getAvgIntRate));
        return products;
    }
}
