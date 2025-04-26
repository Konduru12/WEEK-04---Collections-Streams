import java.util.*;
import java.util.stream.Collectors;
class Policy{
    int holderId;
    String name;
    int age;
    String policyType;
    int premiumAmount;
    Policy(int holderId, String name, int age, String policyType, int premiumAmount){
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getpolicyType(){
        return policyType;
    }
    public int getpremiunAmount(){
        return premiumAmount;
    }
}
    class RiskAssessment {
    int holderId;
    String name;
    double riskScore;

    RiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return "ID: " + holderId + ", Name: " + name + ", Risk Score: " + riskScore;
    }
}
public class PolicyHolderRisk{
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(new Policy(123, "Abhinaya", 21, "Life", 20000),
        new Policy(234,"Sasanka",60,"Business",1000000),
        new Policy(345,"Bharath",69,"Life", 2000000),
        new Policy(456, "Shasank",79, "Business",190000),
        new Policy(567, "Hemateja", 62, "Business", 230000));
    
        List<Policy> filtered = policies.stream()
        .filter(p -> "Life".equalsIgnoreCase(p.getpolicyType()) && p.getAge() > 60)
        .collect(Collectors.toList());

        List<RiskAssessment> riskList = filtered.stream()
            .map(p -> new RiskAssessment(
                p.holderId,
                p.getName(),
                p.premiumAmount / (double) p.getAge()
            ))
            .collect(Collectors.toList()); 
        List<RiskAssessment> sortedList = riskList.stream()
        .sorted(Comparator.comparingDouble(r -> r.riskScore)) 
        .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorized = sortedList.stream()
        .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        categorized.forEach((category, list) -> {
        System.out.println(category + ":");
        list.forEach(System.out::println);
});


}
}
