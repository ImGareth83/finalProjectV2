package sg.com.mices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sg.com.mices.entity.Item;
import sg.com.mices.service.ItemService;

@Controller
@RequestMapping("/files")
public class ItemController {

    private ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/list")
    public String findAll(Model m) {
        m.addAttribute("items", itemService.findAll());
        m.addAttribute("newItem", new Item());
        return "index";
    }
}
