package haxidenti.jargs;

import java.util.*;

public class JArgs {
    private static String numbers = ".0123456789";

    public static JArgs parse(String[] args) {
        Map<String, List<String>> m = new HashMap<>();
        String curName = "main";
        for (String param : args) {
            if (param.length() > 1 && param.startsWith("-") && !numbers.contains("" + param.charAt(1))) {
                curName = param.substring(1);
                continue;
            }
            put(m, curName, param);
        }
        return new JArgs(m);
    }

    private Map<String, List<String>> map;

    private JArgs(Map<String, List<String>> map) {
        this.map = map;
    }

    public String first(String name) {
        List<String> list = map.getOrDefault(name, Collections.emptyList());
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    public List<String> get(String name) {
        return map.getOrDefault(name, Collections.emptyList());
    }

    private static void put(Map<String, List<String>> m, String name, String val) {
        List<String> list = m.computeIfAbsent(name, k -> new ArrayList<>());
        list.add(val);
    }

}
