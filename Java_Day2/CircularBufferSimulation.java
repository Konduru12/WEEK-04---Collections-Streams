class CircularBufferSimulation {
    final private int[] buffer;
    private int head;
    private int size;
    final private int capacity;

    public CircularBufferSimulation(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        head = 0;
        size = 0;
    }
    public void insert(int value) {
        int index = (head + size) % capacity;
        buffer[index] = value;
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; 
        }
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            System.out.print(buffer[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBufferSimulation cb = new CircularBufferSimulation(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();
        System.out.println("After Inserting element");
        cb.insert(4);
        cb.display(); 
    }
}
