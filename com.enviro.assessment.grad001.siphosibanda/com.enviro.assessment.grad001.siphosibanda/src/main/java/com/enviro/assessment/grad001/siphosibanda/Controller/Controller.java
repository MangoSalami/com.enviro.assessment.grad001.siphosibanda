package com.enviro.assessment.grad001.siphosibanda.Controller;

import com.enviro.assessment.grad001.siphosibanda.Models.Investor;
import com.enviro.assessment.grad001.siphosibanda.Models.Product;
import com.enviro.assessment.grad001.siphosibanda.Models.WithdrawalNotice;
import com.enviro.assessment.grad001.siphosibanda.Service.InvestorService;
import com.enviro.assessment.grad001.siphosibanda.Service.ProductService;
import com.enviro.assessment.grad001.siphosibanda.Service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/investors")
public class Controller {
    private final InvestorService investorService;
    private final ProductService productService;
    private final WithdrawalService noticeService;

    @Autowired
    public Controller(InvestorService investorService, ProductService productService, WithdrawalService noticeService) {
        this.investorService = investorService;
        this.productService = productService;
        this.noticeService = noticeService;
    }

    @GetMapping
    public List<Investor> getAllInvestors() {
        return investorService.getAllInvestors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long id) {
        Optional<Investor> optionalInvestor = Optional.ofNullable(investorService.getInvestorById(id));
        return optionalInvestor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/addInvestor")
    public ResponseEntity<Investor> addInvestor(@RequestBody Investor investor) {
        Investor savedInvestor = investorService.addInvestor(investor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInvestor);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
    @PostMapping("/createNotice")
    public ResponseEntity<WithdrawalNotice> createNotice(@RequestBody WithdrawalNotice notice) {
        WithdrawalNotice savedNotice = noticeService.addNotice(notice);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNotice);
    }
    @GetMapping("/download/notices.csv")
    public ResponseEntity<FileSystemResource> downloadCsv() throws IOException {
        List<WithdrawalNotice> notices = noticeService.getAllNotices();
        noticeService.exportToCsv(notices);
        File file = new File("notices.csv");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "notices.csv");
        headers.setContentLength(file.length());
        return new ResponseEntity<>(new FileSystemResource(file), headers, HttpStatus.OK);
    }

}
