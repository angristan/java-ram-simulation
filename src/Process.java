class Process {
    private int size;
    private String name;

    Process(int init_size, String init_name) {
        size = init_size;
        name = init_name;

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
