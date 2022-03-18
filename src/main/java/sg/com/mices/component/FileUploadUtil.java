package sg.com.mices.component;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

    public static void saveFile(String dir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path path = Paths.get(dir);

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = path.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IOException("Could not save image file: " + fileName + " Check your file write access", ioe);
        }
    }
}
