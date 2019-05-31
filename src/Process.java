class Process {
    private int size;
    private String name;
    private int id;
    // Will be used to increment PIDs
    private static int lastID = 0;

    public Process(int initSize, String initName) {
        size = initSize;
        name = initName;
        // Each new process had a PID + 1
        id = ++lastID;
    }

    public int getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Run the program -> allocate the memory for it
    public void execute() {
        try {
            Memory.malloc(this);
        } catch (OutOfMemoryException ignored) {
            // If there is not enough free RAM
        }
    }

    public void exit() {
        try {
            Memory.free(this);
        } catch (ProcessNotFoundException ignored) {
            // If you try to free a non-existent process, or the same process mutilple times
        }
    }
}
