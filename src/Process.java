class Process {
    private int size;
    private String name;

    Process(int initSize, String initName) {
        size = initSize;
        name = initName;

        try {
            Memory.malloc(this);
        } catch (OutOfMemoryException ignored) {
        }
    }

    int getSize() {
        return size;
    }

    void exit() {
        try {
            Memory.free(this);
        } catch (ProcessNotFoundException ignored) {
        }
    }
}
