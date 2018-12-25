package com.business.promotion;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @GetMapping("/{promotionCode}")
    public Map<String, String> findDiscount(@PathVariable String promotionCode) {
        Map<String, String> result = new HashMap<>();

        return result;
    }

}