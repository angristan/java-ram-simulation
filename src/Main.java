class Main {
    public static void main(String[] args) {
        System.out.println("Memory size max: " + Memory.maxSize + "GB");

        System.out.println("Actual state: " + Memory.getStorage());

        Process p = new Process(2, "First Program");
        Process p2 = new Process(10, "Second Program");

        System.out.println("\nFirst program execution (" + p.getSize() + "GB)");
        p.execute();
        System.out.println("Second program execution (" + p2.getSize() + "GB)");
        p2.execute();

        System.out.println("\nActual state: " + Memory.getStorage());

        System.out.println("\nQuit first program");
        p.exit();

        System.out.println("\nActual state: " + Memory.getStorage());
    }
}
