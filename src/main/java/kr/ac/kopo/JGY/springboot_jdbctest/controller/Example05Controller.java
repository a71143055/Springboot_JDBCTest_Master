package kr.ac.kopo.JGY.springboot_jdbctest.controller;

import kr.ac.kopo.JGY.springboot_jdbctest.domain.Detail;
import kr.ac.kopo.JGY.springboot_jdbctest.domain.Product;
import kr.ac.kopo.JGY.springboot_jdbctest.repository.DetailRepository;
import kr.ac.kopo.JGY.springboot_jdbctest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam05")
public class Example05Controller {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DetailRepository detailRepository;
    @GetMapping
    public String requestInsert(Model model){
        Product product = new Product();
        product.setName("갤럭시 24+");
        product.setPrice(999);
        Detail detail = new Detail();
        detail.setDescription("삼성 안드로이드폰");
        detail.setWeight(196f);
        detail.setHeight(158.5f);
        detail.setWidth(75.9f);
        product.setDetail(detail);
        productRepository.save(product);
        Iterable<Product> products = productRepository.findAll();
        Iterable<Detail> detailList = detailRepository.findAll();
        model.addAttribute("products",products);
        model.addAttribute("detailList",detailList);
        return "viewPage05";
    }
}
