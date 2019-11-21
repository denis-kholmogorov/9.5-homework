import java.io.File;

public class Main
{

    public static long weigth;

    public static void main(String[] args)
    {

        String path = "/home/denis/IdeaProjects";
        try {
            File folder = new File(path);
            isFolder(folder);
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Байт - " + weigth);
        System.out.println("Килобайт - " + weigth/1024);
        System.out.println("Мегабайт - " + weigth/1024/1024);
        System.out.println("Гигабайт - " + weigth/1024/1024/1024);

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
