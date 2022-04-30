import java.io.*;

public abstract class FileDatabaseConverter {
    public static final String DATA_DIVIDER = "_";

    public void FileToDatabase(String fileToRead, DatabaseCountable databaseToWrite){
        throw new ActionNotAllowedException("This converter doesn't support this method");
    }

    public void DatabaseToFile(DatabaseCountable database, String fileToWrite){
        throw new ActionNotAllowedException("This converter doesn't support this method");
    }

    public boolean writeFile(String fileName, String fileData){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println(fileData);
            writer.flush();
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public BufferedReader openFile(String fileName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fileName));
    }

}
