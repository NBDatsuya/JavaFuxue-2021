public class ActionNotAllowedException extends RuntimeException{

    public ActionNotAllowedException() {
    }

    public ActionNotAllowedException(String message) {
        super(message);
    }
}
