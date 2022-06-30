# JARGS - Parser

* Parse arguments with `-name val`

# API
```java
class Main {
    public static void main(String[] args) {
        // Parse args from params in main func
        JArgs args = JArgs.parse(args);

        // Get unnamed args list (Main)
        List<String> items = args.get("main");
        
        // Get first param value or null if not present
        String name = args.first("name");

        // Get values list or empty list if not present
        List<String> items = args.get("items");
    }
}
```