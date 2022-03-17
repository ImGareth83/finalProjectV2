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
        return itemService.all();
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
                       //@RequestParam(name="style", required = true) String style,
                       @RequestParam(name="price", required = true) double price,
                       @RequestParam(name="sold", required = true) int sold,
                       @RequestParam(name="quantity", required = true) int quantity,
                       @RequestParam("imagefile") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        String fullPath = imageFolder + '/' + imageUrl;
        ItemDTO itemDto = new ItemDTO(name, description, fullPath, style, price);
        itemService.save(new Item(itemDto));
    }




}
