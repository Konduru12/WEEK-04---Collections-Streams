import java.util.*;
import java.util.stream.Collectors;

class Book{
    String title;
    @SuppressWarnings("unused")
    String author;
    String genre;
    double rating;
    Book(String title, String author, String genre, double rating){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}
class BookRecomdation{
    String title;
    double rating;
    BookRecomdation(String title, double rating){
        this.title = title;
        this.rating = rating;
    }
    @Override
    public String toString(){
        return "Title: " + title + " Rating: " + rating;
    }
}
public class BookRecoomdations{
    static List<List<BookRecomdation>> bookrecommdationlist(List<Book> books){
        List<Book> filtering = books.stream()
        .filter(book -> book.genre.equalsIgnoreCase("Science Fiction") && book.rating > 4.0)
        .collect(Collectors.toList());

        List<BookRecomdation> recommdations = filtering.stream()
        .map(book -> new BookRecomdation(book.title, book.rating))
        .sorted((a,b) -> Double.compare(b.rating, a.rating))
        .limit(10)
        .collect(Collectors.toList());

        List<List<BookRecomdation>> pages = new ArrayList<>();
        for(int i = 0; i < recommdations.size(); i += 5){
            pages.add(recommdations.subList(i, Math.min(i + 5, recommdations.size())));
        }
        return pages;
    } 
    public static void main(String[] args){
        List<Book> books = Arrays.asList(
            new Book("Harry Pother" , " Harry", "Science Fiction", 4.5),
            new Book("Foundation", "Issac", "Science Fition", 4.2),
            new Book("1984", " George", "Historical", 3.5),
            new Book("Alone", "Bharath", "Generic" , 5.0),
            new Book("Devil", "Author", "Horror", 2.5)
        );
        List<List<BookRecomdation>> paginated = bookrecommdationlist(books);
        for(int i = 0; i < paginated.size(); i++){
            System.out.println("Page" + (i + 1) + ":");
            paginated.get(i).forEach(System.out::println);
            System.out.println();
        }
    }
}