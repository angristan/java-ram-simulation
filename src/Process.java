class Process {
    private int size;
    private String name;
    private int id;
    private static int lastID = 0;

    Process(int initSize, String initName) {
        size = initSize;
        name = initName;
        lastID++;
        id = lastID;
    }

    int getSize() {
        return size;
    }

    public void execute() {
        try {
            Memory.malloc(this);
        } catch (OutOfMemoryException ignored) {
        }
    }

    void exit() {
        try {
            Memory.free(this);
        } catch (ProcessNotFoundException ignored) {
        }
    }

    public int getId() {
        return id;
    }
}
