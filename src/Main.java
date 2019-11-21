import java.io.File;
import java.util.Scanner;

public class Main
{

    public static long weigth;
    public static int kilobyte = 1024;
    public static int megabyte = 1024 * 1024;
    public static int gigabyte = 1024 * 1024 * 1024;

    public static void main(String[] args)
    {
        for(;;){
            System.out.println("Введите путь файла. Пример: home/user/Рабочий стол ");
            try {
                Scanner scanner = new Scanner(System.in);
                String path = scanner.nextLine();
                File folder = new File(path);
                isFolder(folder);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Байт - " + weigth);
            System.out.println("Килобайт - " + weigth / kilobyte);
            System.out.println("Мегабайт - " + weigth / megabyte);
            System.out.println("Гигабайт - " + weigth / gigabyte);
            weigth = 0;
        }
    }

    public static void isFile(File file){
        weigth += file.length();
    }

    public static void isFolder(File folder){
        File[] files = folder.listFiles();
        for(File file : files){
            if(file.isFile())
            {
                isFile(file);
            }
            else {
                isFolder(file);
            }
        }
    }
}
