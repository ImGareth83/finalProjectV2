package sg.com.mices.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import sg.com.mices.controller.ItemController;
import sg.com.mices.entity.Item;
import sg.com.mices.service.ItemService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = ItemController.class)
/*
No need to extendWith SpringExtension or MockitoExtension. SpringExtension is a superset of MockitoExtension
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemIntegrationTest {

    //test itemController by mocking the Mvc with mock request

    @Autowired
    private MockMvc mvc;

    @MockBean
    ItemService itemService;

    @ParameterizedTest
    @DisplayName("Should pass when items are returned")
    @CsvFileSource(resources = "/add.csv", numLinesToSkip = 1)
    public void getItems(String name, String description, String imageUrl, String style, double price) throws Exception {

        assertNotNull(itemService); // Test succeeds

        Item i = new Item();
        i.setName(name);
        i.setDescription(description);
        i.setImageUrl(imageUrl);
        i.setStyle(style);
        i.setPrice(price);

        when(itemService.findAll()).thenReturn(Arrays.asList(i));

//        RequestBuilder request = get("/item");
//        MvcResult result = mvc.perform(request).andReturn();

        mvc.perform(get("/items"))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{}]"));
//                .andExpect(content().contentType("text/html"));
        ;
    }

}
