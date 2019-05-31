class Process {
    private int size;
    private String name;
    private int id;
    private static int lastID = 0;

    public Process(int initSize, String initName) {
        size = initSize;
        name = initName;
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

    public void execute() {
        try {
            Memory.malloc(this);
        } catch (OutOfMemoryException ignored) {
        }
    }

    public void exit() {
        try {
            Memory.free(this);
        } catch (ProcessNotFoundException ignored) {
        }
    }
}
