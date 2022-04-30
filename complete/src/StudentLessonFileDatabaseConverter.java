public class StudentLessonFileDatabaseConverter extends FileDatabaseConverter{
    @Override
    public void FileToDatabase(String fileToRead, DatabaseCountable databaseToWrite) {
        super.FileToDatabase(fileToRead, databaseToWrite);
    }

    @Override
    public void DatabaseToFile(DatabaseCountable database, String fileToWrite) {
        super.DatabaseToFile(database, fileToWrite);
    }
}
