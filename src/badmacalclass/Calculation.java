package badmacalclass;

class Calculation {

    /**
     * @param s
     * @param min
     * @param max
     * @param flag
     * @return
     */
    String calculate(String s, int min, int max, int flag) {
        Numerals nm = new Numerals();
        int x = s.length();
        int result = 0;
        String l1 = s.substring(0, FindOperator(s));
        String l = s.substring(FindOperator(s) + 1, x);

        //to throw exception like "X+4" / "4+X", different numerical systems at the same time in the block of searching Roman numerals
        try {
            if (((FindRoman(l1) > -1) ^ (FindRoman(l) > -1))) {
                throw new difNumerals(l1, l);
            }
        } catch (difNumerals e) {
            System.out.println(e);
        }
        //to mark flag if there is any Roman numeral as input value
        if (((FindRoman(l1) > -1) & (FindRoman(l) > -1)) & (flag > 0)) {

            l1 = Numerals.romanToInt(l1);
            l = Numerals.romanToInt(l);
            flag = 2;
        }


        int y1 = Integer.parseInt(l1);
        int y = Integer.parseInt(l);

        // to eliminate any inputs except 1-10
        if ((y1 > max || y > max) || (y1 < min || y < min)) {
            y1 = 0;
            y = 0;
            System.out.println("input numeral should be in 1-10 or I-X interval");
        }

        // core calculation
        char z = (char) FindSign(s);
        switch (z) {
            case 43:
                result = y1 + y;
                break;
            case 45:
                result = y1 - y;
                break;
            case 47:
                result = y1 / y;
                break;
            case 42:
                result = y1 * y;
                break;
            default:
                System.out.println("Oooops, something is wrong!");
        }
        //to throw exception for negative output of the Roman numerals "I-II" <0
        try {
            if ((result < 0) & (flag > 1))
                throw new
                        NegRomOutput(l1, l);
        } catch (NegRomOutput e) {
            System.out.println(e);
        }

        // sophisticated output process))
        String resultRoman = Numerals.arabicToRom(result);
        if ((flag > 1) & (!resultRoman.equals(""))) {
            return (resultRoman);
        } else if ((flag > 1) & (resultRoman.equals(""))) {
            return ("No zero result for output in Roman numerals");
        } else
            return Integer.toString(result);

    }


    static int FindOperator(String name) {
        int j = 0;
        int i = 0;
        int n = 0;
        char[] c = new char[]{'+', '-', '/', '*'};
        while ((i < 1) & (j < 4)) {
            if (name.indexOf(c[j]) > 0) {
                i = i + 1;
                n = name.indexOf(c[j]);
            }
            j = j + 1;

        }

        return n;

    }

    static int FindSign(String name) {
        int j = 0;
        int i = 0;
        char m = 0;
        char[] c = new char[]{'+', '-', '/', '*'};
        while ((i < 1) & (j < 4)) {
            if (name.indexOf(c[j]) > 0) {
                i = i + 1;
                m = c[j];
            }
            j = j + 1;

        }

        return m;
    }

    static int FindRoman(String name) {
        int j = 0;
        int i = 0;
        int k = -1;
        char[] c = new char[]{'I', 'V', 'L', 'C', 'X'};
        while ((i < 1) & (j <= (c.length) - 1)) {
            if (name.indexOf(c[j]) > -1) {
                i = i + 1;
                k = name.indexOf(c[j]);
            }
            j = j + 1;

        }
        return k;
    }

}

