import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
class Transaction{
    @SuppressWarnings("unused")
    int transactionId;
    int policyNumber;
    int amount;
    @SuppressWarnings("unused")
    LocalDate transactionDate;
    boolean isFraudulent;
    Transaction(int transactionId, int policyNumber, int amount, LocalDate transactionDate, boolean isFraudulent){
        this.transactionId = transactionId;
        this.policyNumber =policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}
public class FraudDetection{
    public static void main(String[] args) {
        List<Transaction> frauds = Arrays.asList(
        new Transaction(1, 101, 12000, LocalDate.of(2024, 5, 1), true),
        new Transaction(2, 101, 15000, LocalDate.of(2024, 5, 3), true),
        new Transaction(3, 101, 30000, LocalDate.of(2024, 5, 5), true),
        new Transaction(4, 101, 2000, LocalDate.of(2024, 5, 6), false),
        new Transaction(5, 102, 25000, LocalDate.of(2024, 5, 7), true),
        new Transaction(6, 102, 28000, LocalDate.of(2024, 5, 8), true),
        new Transaction(7, 102, 1000, LocalDate.of(2024, 5, 9), false),
        new Transaction(8, 103, 9000, LocalDate.of(2024, 5, 10), true),
        new Transaction(9, 101, 18000, LocalDate.of(2024, 5, 11), true),
        new Transaction(10, 101, 16000, LocalDate.of(2024, 5, 12), true));

        List<Transaction> filtered = frauds.stream()
            .filter(t -> t.isFraudulent && t.amount > 10000)
            .collect(Collectors.toList());
        
        Map<Integer, List<Transaction>> grouped = filtered.stream()
            .collect(Collectors.groupingBy(t -> t.policyNumber));

        grouped.forEach((policyNumber, txns) -> {
            int totalAmount = txns.stream().mapToInt(t -> t.amount).sum();
            long count = txns.size();

            if (count > 5 || totalAmount > 50000) {
                System.out.println("ALERT: Policy " + policyNumber +
                    " has " + count + " fraudulent transactions totaling " + totalAmount);
            }
        });    
        
    }
}