package com.ezen.store.FrontController;

import com.ezen.store.DTO.StoreDTO;
import com.ezen.store.Entity.StoreEntity;
import com.ezen.store.Service.StoreService;
import com.ezen.store.VO.StoreVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

@Controller
@Slf4j
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/input")
    public String input() {
        return "input";
    }

    @PostMapping("/inputSave")
    public String inputSave(@Valid StoreDTO dto, Errors errors, Model mo) {
        if (errors.hasErrors()) {
            mo.addAttribute("dto", dto);
            Map<String, String> validatorResult = StoreErrors.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                mo.addAttribute(key, validatorResult.get(key));
            }
            return "input";
        }
        StoreEntity entity = dto.toEntity();
        log.info(dto.getName() + "이름" + dto.getEa() + "수량 " + dto.getPrice() + "단가");
        storeService.save(entity);
        return "redirect:/main";
    }

    @GetMapping("/output")
    public String output(Model mo) {
        ArrayList<StoreVO> list = new ArrayList();
        ArrayList<StoreEntity> list2 = storeService.findAll();
        int total = 0;
        for (int i = 0; i < list2.size(); i++) {
            StoreVO vo = new StoreVO();
            long id = list2.get(i).getId();
            String name = list2.get(i).getName();
            int ea = list2.get(i).getEa();
            int price = list2.get(i).getPrice();
            total = ea * price;
            vo.setId(id);
            vo.setName(name);
            vo.setEa(ea);
            vo.setPrice(price);
            vo.setTotal(total);
            list.add(vo);
        }
        mo.addAttribute("list", list);
        return "output";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        StoreEntity entity = storeService.findById(id);
        if (entity != null) {
            storeService.delete(entity);
        }
        return "redirect:/main";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") long id, Model mo) {
        StoreEntity entity = storeService.findById(id);
        log.info(String.valueOf(id));
        if (entity != null) {
            mo.addAttribute("list", entity);
        }
        return "update";
    }
    @PostMapping("/updateSave")
    public String updateSave(StoreDTO dto) {
        StoreEntity entity = dto.toEntity();
        storeService.save(entity);
        return "redirect:/main";
    }

}

