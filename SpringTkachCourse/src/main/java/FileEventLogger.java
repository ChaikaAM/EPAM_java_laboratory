import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Chaika Aleksei on 31.08.2016.
 */
public class FileEventLogger implements EventLogger{
    private String filePath;
    private final Charset encoding = Charset.forName("utf-8");
    private File file;

    public FileEventLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void logEvent(Event event){
        try {
            FileUtils.writeStringToFile(file,event.toString()+System.lineSeparator(),encoding, true);
        } catch (IOException e) {
            System.out.println("Exception in writing string to file catched");
        }
    }

    private void init() throws Exception{
        file=new File(filePath);
        if (!file.exists()){
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
    }
}
