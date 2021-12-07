package badmacalclass;

class NegRomOutput extends Exception {
    String a;
    String b;

    NegRomOutput(String i, String j) {
        a = i;
        b = j;
    }

    public String toString() {
        return "The first value is lower than the second. There is no negative output/value in the Roman numerals";
    }
}

class difNumerals extends Exception {
    String a;
    String b;

    difNumerals(String i, String j) {
        a = i;
        b = j;
    }

    public String toString() {
        return "different numerical systems are involved";
    }
}
