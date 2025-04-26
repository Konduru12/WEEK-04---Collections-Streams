import java.util.*;

class Patient {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
class PatientComparsion implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        return p2.severity - p1.severity;
    }
}

public class HospitalTriageSystem{
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new PatientComparsion());
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));
        while (!triageQueue.isEmpty()) {
            Patient p = triageQueue.poll();
            System.out.println(p.name);
        }
    }
}
