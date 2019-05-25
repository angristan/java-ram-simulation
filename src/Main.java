class Main
{
    public static void main(String[] args)
    {
        Process p = new Process(2, "test");

        System.out.println(Memory.getStorage());

        p.exit();

        System.out.println(Memory.getStorage());
    }
} 