import java.io.*;
import java.util.ArrayList;

public class WriteFile<F> {
    public void WriteFile(ArrayList<F> list, File file){
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream ops = new ObjectOutputStream(fos);
            ops.writeObject(list);
            fos.close();
            ops.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
