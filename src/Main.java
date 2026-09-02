public class Main {
    public static void main(String[] args) {
        int exitCode = run(args);
        System.exit(exitCode);
    }

    private static int run(String[] args) {
        if (args.length == 0) {
            printUsage();
            return 0;
        }

        String command = args[0];

        return switch (command) {
            case "help" -> {
                printUsage();
                yield 0;
            }
            case "add" -> handleAdd(args);
            default -> {
                System.err.println("Error: Unknown command: " + command);
                printUsage();
                yield 1;
            }
        };
    }

    private static int handleAdd(String[] args) {
        if (args.length < 2 || args[1].isBlank()) {
            System.err.println("Error: Task description cannot be empty.");
            System.err.println("Usage: add \"description\"");
            return 1;
        }

        if (args.length > 2) {
            System.err.println("Error: Put descriptions containing spaces in quotes.");
            System.err.println("Usage: add \"description\"");
            return 1;
        }

        String description = args[1].trim();

        System.out.println("Add command received.");
        System.out.println("Description: " + description);
        return 0;
    }

    private static void printUsage() {
        System.out.println("Task Tracker CLI");
        System.out.println("Available commands:");
        System.out.println("  add \"description\"");
        System.out.println("  help");
    }
}
