public abstract class FileDatabaseConverter {
    public static final String DATA_DIVIDER = "_";

    public void FileToDatabase(String fileToRead, DatabaseCountable databaseToWrite){
        throw new ActionNotAllowedException("This converter doesn't support this method");
    }

    public String DatabaseToFile(DatabaseCountable database, String fileToWrite){
        throw new ActionNotAllowedException("This converter doesn't support this method");
    }

}
