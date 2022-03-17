package sg.com.mices.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sg.com.mices.component.FileUploadUtil;
import sg.com.mices.entity.Item;
import sg.com.mices.controller.dto.ItemDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping("/list")
    public String findAll(Model m) {
        m.addAttribute("items", itemService.findAll());
        m.addAttribute("newItem", new Item());
        return "index";
    }

    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Item> getItems()
    {
        return itemService.findAll();
    }

    @CrossOrigin
    @GetMapping( "/{id}" )
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findById( id );
    }

    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

    // to-edit-later
    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="name", required = true) String name,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="imageUrl", required = true) String imageUrl,
                       @RequestParam(name="price", required = true) double price,
                       @RequestParam(name="sold", required = true) int sold,
                       @RequestParam(name="quantity", required = true) int quantity,
                       @RequestParam("imagefile") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        String fullPath = imageFolder + '/' + imageUrl;
        ItemDTO itemDto = new ItemDTO(name, description, fullPath, price, sold, quantity);
        itemService.save(new Item(itemDto));
    }




}
