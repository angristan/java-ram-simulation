class Main {
    public static void main(String[] args) {
        System.out.println(Memory.getStorage());

        Process p = new Process(2, "test");
        Process p2 = new Process(10, "toobig");

        System.out.println(Memory.getStorage());

        p.exit();

        System.out.println(Memory.getStorage());
    }
}
