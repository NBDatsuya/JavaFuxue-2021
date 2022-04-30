import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LessonFileDatabaseConverter extends FileDatabaseConverter{

    @Override
    public void FileToDatabase(String fileToRead, DatabaseCountable databaseToWrite) {
        if(!(databaseToWrite instanceof LessonDatabase)){
            return;
        }
        try{
            BufferedReader reader = this.openFile(fileToRead);
            String line = reader.readLine();

            while(line != null){
                StringTokenizer tokenizer = new StringTokenizer(line, LessonFileDatabaseConverter.DATA_DIVIDER);
                ((LessonDatabase)databaseToWrite).addLesson(new Lesson(Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken(), tokenizer.nextToken(), new Test("19341122", 100)));
                line = reader.readLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void DatabaseToFile(DatabaseCountable database, String fileToWrite) {
        if(!(database instanceof LessonDatabase)){
            return;
        }
        String data = "";
        for(Lesson lesson : ((LessonDatabase)database)){
            data += lesson.getId() + "_" + lesson.getName() + "_" + lesson.getType() + "\n";
        }
        this.writeFile(fileToWrite,data);
    }
}
