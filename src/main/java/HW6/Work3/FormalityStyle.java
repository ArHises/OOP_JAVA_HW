package HW6.Work3;

public enum FormalityStyle {
    FORMAL("Formal style for greeting"),
    CASUAL("Casual style for greeting"),
    INTIMATE("Intimate style for greeting");

    private final String formalityStyle;
    FormalityStyle(String formalityStyle) {
        this.formalityStyle = formalityStyle;
    }

    @Override
    public String toString() {
        return formalityStyle;
    }
}
