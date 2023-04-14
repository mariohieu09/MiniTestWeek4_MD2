import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFile<F> {
    public ArrayList<F> ReadFile(File file){
        ArrayList<F> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            if(fis.available() == 0){
                return list;
            }else {
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (ArrayList<F>) ois.readObject();
                ois.close();
            }
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
