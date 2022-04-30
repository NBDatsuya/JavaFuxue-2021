import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class StudentFileDatabaseConverter extends FileDatabaseConverter{
    @Override
    public void FileToDatabase(String fileToRead, DatabaseCountable databaseToWrite) {
        if(!(databaseToWrite instanceof StudentDatabase)){
            return;
        }
        try{
            BufferedReader reader = this.openFile(fileToRead);

            String line = reader.readLine();

            while(line != null){
                StringTokenizer tokenizer = new StringTokenizer(line, StudentFileDatabaseConverter.DATA_DIVIDER);
                ((StudentDatabase) databaseToWrite).addStudent(new Student(Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken(), tokenizer.nextToken()));
                line = reader.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void DatabaseToFile(DatabaseCountable database, String fileToWrite) {
        if(!(database instanceof StudentDatabase)){
            return;
        }
        String data = "";
        for (Student student : ((StudentDatabase) database)){
            data += student.getId() + "_" + student.getName() + "_" + student.getMajor() + "\n";
        }
        writeFile(fileToWrite, data);
    }
}
