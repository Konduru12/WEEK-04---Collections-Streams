import java.time.*;
import java.util.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return policyNumber + " | " + holderName + " | " + expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        hashSet.forEach(System.out::println);
    }

    public void displayExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        System.out.println("Policies expiring in next 30 days:");
        treeSet.stream().filter(p -> !p.expiryDate.isAfter(threshold)).forEach(System.out::println);
    }

    public void displayByCoverageType(String type) {
        System.out.println("Policies with coverage type: " + type);
        hashSet.stream().filter(p -> p.coverageType.equalsIgnoreCase(type)).forEach(System.out::println);
    }

    public void checkDuplicates(List<Policy> policies) {
        Set<String> policyNumbers = new HashSet<>();
        System.out.println("Duplicate policies:");
        for (Policy p : policies) {
            if (!policyNumbers.add(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }

    public void performanceTest() {
        int n = 10000;
        List<Policy> policies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            policies.add(new Policy("PN" + i, "Name" + i, LocalDate.now().plusDays(i), "Health", 1000 + i));
        }

        System.out.println("Performance Comparison:");
        testSetPerformance(new HashSet<>(), policies, "HashSet");
        testSetPerformance(new LinkedHashSet<>(), policies, "LinkedHashSet");
        testSetPerformance(new TreeSet<>(), policies, "TreeSet");
    }

    private void testSetPerformance(Set<Policy> set, List<Policy> policies, String type) {
        long start = System.nanoTime();
        set.addAll(policies);
        long addTime = System.nanoTime() - start;

        start = System.nanoTime();
        set.contains(policies.get(policies.size() / 2));
        long searchTime = System.nanoTime() - start;

        start = System.nanoTime();
        set.remove(policies.get(0));
        long removeTime = System.nanoTime() - start;

        System.out.println(type + " - Add: " + addTime + " ns, Search: " + searchTime + " ns, Remove: " + removeTime + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        system.addPolicy(new Policy("P1", "Alice", LocalDate.now().plusDays(15), "Health", 5000));
        system.addPolicy(new Policy("P2", "Bob", LocalDate.now().plusDays(60), "Auto", 3000));
        system.addPolicy(new Policy("P3", "Charlie", LocalDate.now().plusDays(25), "Home", 7000));

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Health");

        List<Policy> duplicateCheckList = Arrays.asList(
                new Policy("P1", "Alice", LocalDate.now().plusDays(15), "Health", 5000),
                new Policy("P4", "David", LocalDate.now().plusDays(40), "Health", 6000),
                new Policy("P1", "Alice", LocalDate.now().plusDays(15), "Health", 5000)
        );
        system.checkDuplicates(duplicateCheckList);

        system.performanceTest();
    }
}
