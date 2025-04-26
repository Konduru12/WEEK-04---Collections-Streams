import java.io.*;
public class FileHandling{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void creatingSourceFile() {
        try (FileWriter fw = new FileWriter("source.txt")) {
            fw.write("Java is a programming language. Many industries are opting java over so many other programming languages. It is a platform independent language. It is known as both Compiler language as well as Interpreted language.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void copyFile(String sourcePath, String destPath) {
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        if (!sourceFile.exists()) {
            System.out.println(" Source file does not exist: " + sourcePath);
            return;
        }
        try (
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destFile)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully to: " + destPath);
        } catch (IOException e) {
            System.out.println(" Error during file copy: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        creatingSourceFile();
        copyFile("source.txt", "copy.txt");
    }
}
