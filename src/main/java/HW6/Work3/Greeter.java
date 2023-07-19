package HW6.Work3;

public class Greeter {
    private String formality;

    public String greet() {
        return switch (FormalityStyle.valueOf(this.formality)) {
            case FORMAL -> "Good evening, sir.";
            case CASUAL -> "Sup bro?";
            case INTIMATE -> "Hello Darling!";
            default -> "Hello.";
        };
    }

    public void setFormality(String formality) {
        this.formality = formality;
    }
}
