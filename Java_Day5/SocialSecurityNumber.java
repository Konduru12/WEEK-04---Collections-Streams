
public class SocialSecurityNumber{
    public static boolean validation(String ssn) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        return ssn.matches(regex);
    }
    public static void main(String[] args) {
        String[] inputs = {"123-45-6789", "123456789", "987-65-4321"};
        for (String ssn : inputs) {
            if (validation(ssn)) {
                System.out.println("\"" + ssn + "\" is valid");
            } else {
                System.out.println("\"" + ssn + "\" is invalid");
            }
        }
    }
}
