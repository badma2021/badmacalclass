package badmacalclass;

import java.util.HashMap;
import java.util.Map;

class Numerals {
    int FindRoman(String name) {
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


    static String romanToInt(String s) {

        int output = 0;

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        if (s.length() == 0) return String.valueOf(0);
        if (s.length() == 1) return String.valueOf(map.get(String.valueOf(s.charAt(0))));

        for (int i = 0; i < (s.length() - 1); i++) {
            if (map.get(String.valueOf(s.charAt(i))) >=
                    map.get(String.valueOf(s.charAt(i + 1)))) {
                output = output + map.get(String.valueOf(s.charAt(i)));
            } else {
                output = output - map.get(String.valueOf(s.charAt(i)));
            }

        }
        output = output + map.get(String.valueOf(s.charAt(s.length() - 1)));
        String output1 = Integer.toString(output);
        return output1;
    }

    static String arabicToRom(int s) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "X");
        map.put(2, "XX");
        map.put(3, "XXX");
        map.put(4, "XL");
        map.put(5, "L");
        map.put(6, "LX");
        map.put(7, "LXX");
        map.put(8, "LXXX");
        map.put(9, "XC");
        map.put(10, "C");
        map.put(0, "");

        Map<Integer, String> map2 = new HashMap<Integer, String>();
        map2.put(1, "I");
        map2.put(2, "II");
        map2.put(3, "III");
        map2.put(4, "IV");
        map2.put(5, "V");
        map2.put(6, "VI");
        map2.put(7, "VII");
        map2.put(8, "VIII");
        map2.put(9, "IX");
        map2.put(0, "");

        int p = s / 10;
        int d = s % 10;
        String v = map.get(Integer.valueOf(p)) + map2.get(Integer.valueOf(d));

        return v;
    }
}
