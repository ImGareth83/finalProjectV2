package sg.com.mices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sg.com.mices.component.FileUploadUtil;
import sg.com.mices.controller.dto.ItemDTO;
import sg.com.mices.entity.Item;
import sg.com.mices.service.ItemService;

import java.io.IOException;

@Controller
@RequestMapping("/files")
public class ItemController {

    @Value("${image.folder}")
    private String imageFolder;

    private ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/form")
    public String form(Model m) {
        m.addAttribute("newItem", new Item());
        return "form";
    }

    @CrossOrigin
    @GetMapping("/list")
    public String findAll(Model m) {
        m.addAttribute("items", itemService.findAll());
        m.addAttribute("newItem", new Item());
        return "product";
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems() {
        return itemService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id) {
        return itemService.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Item item) {
        itemService.delete(item);
    }

    // to-edit-later
    @CrossOrigin
    @PostMapping("/add")
    public String save(@RequestParam(name = "name", required = true) String name,
                       @RequestParam(name = "description", required = true) String description,
                       @RequestParam(name = "price", required = true) double price,
                       @RequestParam(name = "sold", required = true) int sold,
                       @RequestParam(name = "quantity", required = true) int quantity,
                       @RequestParam(name = "style", required = true) String style,
                       @RequestParam("imagefile") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        String fullPath = imageFolder + '/' + fileName;
        ItemDTO itemDto = new ItemDTO(name, description, fullPath, price, sold, quantity, style);
        itemService.save(new Item(itemDto));

        return "redirect:/files/form";
    }


}
