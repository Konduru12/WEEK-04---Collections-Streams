import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Claims {
    int claimId;
    int policyNumber;
    int claimAmount;
    LocalDate claimDate;
    String status;

    Claims(int claimId, int policyNumber, int claimAmount, LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public int getClaimAmount() {
        return claimAmount;
    }

    @Override
    public String toString() {
        return "ClaimID: " + claimId + ", Amount: " + claimAmount + ", Date: " + claimDate + ", Status: " + status;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claims> accounts = Arrays.asList(
            new Claims(123, 432, 200000, LocalDate.of(2024, 5, 3), "Approved"),
            new Claims(234, 9870, 30000, LocalDate.of(2025, 9, 23), "Approved"),
            new Claims(421, 89012, 124599, LocalDate.of(2025, 8, 29), "Not Approved"),
            new Claims(345, 22134, 90000, LocalDate.of(2024, 7, 9), "Not Approved"),
            new Claims(128, 9012, 890000, LocalDate.of(2025, 9, 12), "Approved")
        );

        List<Claims> filtered = accounts.stream()
            .filter(c -> "Approved".equalsIgnoreCase(c.status) && c.claimAmount > 5000)
            .collect(Collectors.toList());

        Map<Integer, List<Claims>> groupedClaims = filtered.stream()
            .collect(Collectors.groupingBy(Claims::getPolicyNumber));

        Map<Integer, Map<String, Double>> Aggregates = groupedClaims.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> {
                    List<Claims> claims = entry.getValue();
                    double total = claims.stream().mapToInt(Claims::getClaimAmount).sum();
                    double average = claims.stream().mapToInt(Claims::getClaimAmount).average().orElse(0.0);
                    Map<String, Double> stats = new HashMap<>();
                    stats.put("Total", total);
                    stats.put("Average", average);
                    return stats;
                }
            ));

        
        Aggregates.forEach((policy, stats) -> 
            System.out.println("Policy: " + policy + ", Total: $" + stats.get("Total") + ", Average: $" + stats.get("Average"))
        );

        List<Map.Entry<Integer, Map<String, Double>>> topPolicies = Aggregates.entrySet().stream()
            .sorted((e1, e2) -> Double.compare(e2.getValue().get("Total"), e1.getValue().get("Total")))
            .limit(3)
            .collect(Collectors.toList());

        System.out.println("\nTop 3 Policies");
        topPolicies.forEach(entry -> 
            System.out.println("Policy: " + entry.getKey() + ", Total: $" + entry.getValue().get("Total"))
        );
    }
}
