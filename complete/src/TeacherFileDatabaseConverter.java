import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TeacherFileDatabaseConverter extends FileDatabaseConverter{
    @Override
    public void FileToDatabase(String fileToRead, DatabaseCountable databaseToWrite) {
        if(!(databaseToWrite instanceof TeacherDatabase)){
            return;
        }
        try{
            BufferedReader reader = this.openFile(fileToRead);

            String line = reader.readLine();

            while(line != null){
                StringTokenizer tokenizer = new StringTokenizer(line, StudentFileDatabaseConverter.DATA_DIVIDER);
                ((TeacherDatabase) databaseToWrite).addTeacher(new Teacher(Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken(), tokenizer.nextToken()));
                line = reader.readLine();
            }

            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void DatabaseToFile(DatabaseCountable database, String fileToWrite) {
        if(!(database instanceof TeacherDatabase)){
            return;
        }
        String data = "";
        for (Teacher teacher: ((TeacherDatabase) database)){
            data += teacher.getId() + "_" + teacher.getName() + "_" + teacher.getPhoneNumber() + "\n";
        }
        writeFile(fileToWrite, data);
    }
}
