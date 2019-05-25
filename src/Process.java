class Process {
    private int size;
    private String name;

    Process(int init_size, String init_name) {
        size = init_size;
        name = init_name;

        Memory.malloc(this);
    }

    int getSize() {
        return size;
    }

    public void exit() {
        Memory.free(this);
    }
}
