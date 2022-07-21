import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        readData("marsh.mp3");
        writeData("marsh2.mp3");
        long endTime = System.currentTimeMillis();
        System.out.println("The process has continued " + (endTime - startTime) / 1000 + "ms second.");
    }


    private static ArrayList<Integer> backUpData = new ArrayList<>();
    public static void readData(String fileName)
    {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            int readBytes;

            while ((readBytes = fileInputStream.read()) != -1)
            {
                backUpData.add(readBytes);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void writeData(String fileName)
    {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            for (int data : backUpData) {
                fileOutputStream.write(data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
