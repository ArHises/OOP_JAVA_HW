package HW6.Work3;

public class Greeter {
    private FormalityStyle formality;

    public String greet() {
        return switch (this.formality) {
            case FORMAL -> "Good evening, sir.";
            case CASUAL -> "Sup bro?";
            case INTIMATE -> "Hello Darling!";
            default -> "Hello.";
        };
    }

    public void setFormality(FormalityStyle formality) {
        this.formality = formality;
    }
}
