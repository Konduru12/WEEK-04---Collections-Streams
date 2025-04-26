public class CreditCardNumber{
    public static String validation(String cardNumber) {
        String visaRegex = "^4\\d{15}$";
        String masterRegex = "^5\\d{15}$";
        if (cardNumber.matches(visaRegex)) {
            return "Valid Visa Card";
        } else if (cardNumber.matches(masterRegex)) {
            return "Valid MasterCard";
        } else {
            return "Invalid Card";
        }
    }

    public static void main(String[] args) {
        String[] cards = {"4123456789012345", "5123456789012345", "6123456789012345", "41234567890123"};
        for (String card : cards) {
            System.out.println(card + " --> " + validation(card));
        }
    }
}
