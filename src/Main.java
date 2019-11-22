import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

    private static long weigth;
    private static int kilobyte = 1024;
    private static int megabyte = 1024 * 1024;
    private static int gigabyte = 1024 * 1024 * 1024;

    public static void main(String[] args)
    {
        for(;;){
            System.out.println("Введите путь файла. Пример: home/user/Рабочий стол ");
            try {
                Scanner scanner = new Scanner(System.in);
                String path = scanner.nextLine();
                File folder = new File(path);
                if(folder.exists()){
                    openFolder(folder);
                }else {
                    throw new FileNotFoundException("Файл не найден, повторите попытку");
                }

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                continue;
            }

            System.out.println("Байт - " + weigth);
            System.out.println("Килобайт - " + weigth / kilobyte);
            System.out.println("Мегабайт - " + weigth / megabyte);
            System.out.println("Гигабайт - " + weigth / gigabyte);
            weigth = 0;
        }
    }

    public static void countBytesOfFile(File file){
        weigth += file.length();
    }

    public static void openFolder(File folder){
        File[] files = folder.listFiles();
        for(File file : files){
            if(file.isFile())
            {
                countBytesOfFile(file);
            }
            else {
                openFolder(file);
            }
        }
    }
}

