package g13c.cw7.zad3;

class StoryViolationException extends RuntimeException {

    public StoryViolationException(String message) {
        super(message);
    }

    public void printMessage() {
        System.out.println(super.getMessage());
    }
}