package com.enviro.assessment.grad001.siphosibanda.Service;

import com.enviro.assessment.grad001.siphosibanda.Models.Product;
import com.enviro.assessment.grad001.siphosibanda.Models.WithdrawalNotice;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class WithdrawalService {
    @Autowired
    private final WithdrawalRepository noticeRepository;
    private final ProductRepository productRepository;
    public WithdrawalService(WithdrawalRepository noticeRepository, ProductRepository productRepository) {
        this.noticeRepository = noticeRepository;

        this.productRepository = productRepository;
    }
    public List<WithdrawalNotice> getAllNotices() {
        return noticeRepository.findAll();
    }
    @Transactional
    public WithdrawalNotice addNotice(WithdrawalNotice notice) {
        Product product = notice.getProduct();
        Long productId=product.getId();

        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId));
        if (checkBalance(existingProduct,notice)) {
            throw new IllegalArgumentException("Invalid withdrawal,withdrawal is greater than actual balance");
        }

        return noticeRepository.save(notice);
    }
    public boolean checkBalance(Product product,WithdrawalNotice notice){
        BigDecimal productBalance=product.getBalance();
        BigDecimal withdrawal=notice.getWithdrawalAmount();

        return (withdrawal.compareTo(productBalance)==1);
    }
    public void exportToCsv(List<WithdrawalNotice> notices) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("notices.csv"))) {
            // Write the CSV header
            String[] header = { "ID", "productId", "Withdrawal" };
            writer.writeNext(header);

            // Write each item to the CSV file
            for (WithdrawalNotice notice : notices) {
                String[] row = {
                        notice.getId().toString(),
                        notice.getProduct().getId().toString(),
                        notice.getWithdrawalAmount().toString()
                };
                writer.writeNext(row);
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
