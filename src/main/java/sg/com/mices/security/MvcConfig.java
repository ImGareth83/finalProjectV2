package sg.com.mices.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    @Value("${image.folder}")
    private String imageFolder; //now imageFolder variable the value = productimages


    public void addViewControllers(ViewControllerRegistry registry) {
        //Map the browser's URL to a specific View (HTML) inside resources/templates directory
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/aboutus").setViewName("abtus");
        registry.addViewController("/product").setViewName("product");
        registry.addViewController("/upload").setViewName("uploadForm");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);
    }

    //expose the productimages folder to allow external client to access the files from the server
    Path uploadDir = Paths.get(imageFolder);
    String uploadPath = uploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/" + imageFolder + "/**").addResourceLocations("file:" + uploadPath + "/").setCachePeriod(0);



}
