package sg.com.mices.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sg.com.mices.entity.Item;
import sg.com.mices.entity.ItemRepository;

import java.util.List;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase
public class ItemServiceTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TestEntityManager entityManager;

    private ItemService itemService;

    private Item newI;

    @BeforeAll
    public void setUp() {
        Assertions.assertNotNull(itemRepository);
        itemService = new ItemService(itemRepository);

    }

    @ParameterizedTest
    @DisplayName("Test should pass when id is valid")
    @CsvFileSource(resources = "/add.csv", numLinesToSkip = 1)
    public void shouldFindById(String name, String description, String imageUrl, String style, double price) {
        Item i = new Item();
        i.setName(name);
        i.setDescription(description);
        i.setImageUrl(imageUrl);
        i.setStyle(style);
        i.setPrice(price);
        int id = entityManager.persist(i).getId();

        Item result = itemService.findById(id);
        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(id, result.getId());
    }

    @Test
    @DisplayName("Test should pass when id is invalid")
    public void shouldFailedFindById() {
        int id = 0;
        Item result = itemService.findById(id);
        Assertions.assertNull(result.getId());
    }

    @DisplayName("Test should pass and returns a list of items")
    @ParameterizedTest
    @CsvFileSource(resources = "/add.csv", numLinesToSkip = 1)
    public void shouldFindAll(String name, String description, String imageUrl, String style, double price) {
        Item i = new Item();
        i.setName(name);
        i.setDescription(description);
        i.setImageUrl(imageUrl);
        i.setStyle(style);
        i.setPrice(price);
        entityManager.persist(i);

        List<Item> result = itemService.findAll();
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        result.forEach(System.out::println);
    }

    @DisplayName("Test should pass and return Item when item is add")
    @ParameterizedTest
    @CsvFileSource(resources = "/add.csv", numLinesToSkip = 1)
    public void shouldAddItem(String name, String description, String imageUrl, String style, double price) {
        Item i = new Item();
        i.setName(name);
        i.setDescription(description);
        i.setImageUrl(imageUrl);
        i.setStyle(style);
        i.setPrice(price);

        newI = itemService.save(i);
    }

    @Test
    @DisplayName("Test should pass and return Item when item is deleted")
    public void shouldDeleteItem() {
        itemService.delete(newI);
        Item result = itemService.findById(newI.getId());
        Assertions.assertNull(result.getId());

    }
}