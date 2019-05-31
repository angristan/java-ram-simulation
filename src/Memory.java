import java.util.ArrayList;

class Memory {
    private static int maxSize;
    private static int currentSize;
    private static ArrayList<Process> storage; // List of processes
    private static boolean free; // Is there free space in the memory?

    // Initiate the singleton
    private static Memory mainMemory = new Memory();

    private Memory() {
        maxSize = 8; // Let's say 8 bytes
        currentSize = 0; // No process yet so 0 byte used
        free = true; // Same, there is free RAM
        storage = new ArrayList<>(); // Init empty process list
    }

    // Method to get the singleton instance if needed
    public static Memory getInstance() {
        return mainMemory;
    }

    // Add process to memory if it fits
    public static void malloc(Process newProcess) throws OutOfMemoryException {

        if (newProcess.getSize() < (maxSize - currentSize)) {

            storage.add(newProcess);

            // Available RAM is decreased
            currentSize -= newProcess.getSize();

            // Set free flag to false if the memory is completely filled
            if (currentSize == 0) {
                setFree(false);
            }

        } else {
            // If there is not enough RAM availabl
            throw new OutOfMemoryException();
        }
    }

    // Remove process from memory if it exists
    public static void free(Process oldProcess) throws ProcessNotFoundException {
        if (storage.contains(oldProcess)) {
            storage.remove(oldProcess);

            // Avaibled RAM is increased
            currentSize += oldProcess.getSize();

            // If there is whatever amount of RAM avaible, toggle the free flag
            if (currentSize > 0) {
                setFree(true);
            }

        } else {
            // If the Process does not exist...
            throw new ProcessNotFoundException();
        }
    }

    // Returns the list of processes
    public static ArrayList<Process> getStorage() {
        return storage;
    }

    // Toggle the free flag if RAM is available
    public static void setFree(boolean free) {
        Memory.free = free;
    }

    // Check if RAM is available
    public static boolean isFree() {
        return free;
    }

    public static int getmaxSize() {
        return maxSize;
    }
}
