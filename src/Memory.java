import java.util.ArrayList;
import java.util.List;

class Memory {
    private static Memory main_memory = new Memory();
    private static int max_size;
    private static int current_size;
    private static List<Process> storage;
    private static boolean free;

    private Memory() {
        max_size = 8;
        current_size = 0;
        free = true;
        storage = new ArrayList<>();
    }

    public static Memory getInstance() {
        return main_memory;
    }

    static void malloc(Process new_process)
            throws OutOfMemoryException {
        if (new_process.getSize() < (max_size - current_size)) {
            storage.add(new_process);

            current_size = current_size - new_process.getSize();

            if (current_size == 0) {
                setFree(false);
            }
        } else {
            throw new OutOfMemoryException();
        }
    }

    static void free(Process old_process)
            throws ProcessNotFoundException {
        if (storage.contains(old_process)) {
            storage.remove(old_process);

            current_size = current_size + old_process.getSize();

            if (current_size > 0) {
                setFree(true);
            }
        } else {
            throw new ProcessNotFoundException();
        }
    }

    static List<Process> getStorage() {
        return storage;
    }

    private static void setFree(boolean free) {
        Memory.free = free;
    }

    public static int getMax_size() {
        return max_size;
    }
}


