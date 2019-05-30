import java.util.ArrayList;

class Memory {
    private static Memory mainMemory = new Memory();
    private static int maxSize;
    private static int currentSize;
    private static ArrayList<Process> storage;
    private static boolean free;

    private Memory() {
        maxSize = 8;
        currentSize = 0;
        free = true;
        storage = new ArrayList<>();
    }

    public static Memory getInstance() {
        return mainMemory;
    }

    static void malloc(Process newProcess)
            throws OutOfMemoryException {
        if (newProcess.getSize() < (maxSize - currentSize)) {
            storage.add(newProcess);

            currentSize = currentSize - newProcess.getSize();

            if (currentSize == 0) {
                setFree(false);
            }
        } else {
            throw new OutOfMemoryException();
        }
    }

    static void free(Process oldProcess)
            throws ProcessNotFoundException {
        if (storage.contains(oldProcess)) {
            storage.remove(oldProcess);

            currentSize = currentSize + oldProcess.getSize();

            if (currentSize > 0) {
                setFree(true);
            }
        } else {
            throw new ProcessNotFoundException();
        }
    }

    static ArrayList<Process> getStorage() {
        return storage;
    }

    private static void setFree(boolean free) {
        Memory.free = free;
    }

    public static int getmaxSize() {
        return maxSize;
    }
}
