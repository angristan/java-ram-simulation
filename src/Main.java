class Main {
    public static void main(String[] args) {
        System.out.println("Memory size max: " + Memory.getmaxSize() + "B");

        System.out.println("Actual state: " + Memory.getStorage());

        Process p1 = new Process(2, "First Program");
        Process p2 = new Process(10, "Second Program");

        System.out.println("\nFirst program execution (" + p1.getSize() + "B)");
        p1.execute();
        System.out.println("Second program execution (" + p2.getSize() + "B)");
        p2.execute();

        System.out.println("\nFirst program id: " + p1.getId());
        System.out.println("Second program id: " + p2.getId());

        System.out.println("\nActual state: " + Memory.getStorage());

        System.out.println("\nQuit first program");
        p1.exit();

        System.out.println("\nActual state: " + Memory.getStorage());
    }
}
