import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        OmdbApi searchMovieApi = new OmdbApi();
        List<Movie> movieList = new ArrayList<>();
        SaveInJson savingInJson = new SaveInJson();
        //declaring a constant
        final double TICKET_PRICE = 10;
        String buyANewTicket = "y";
            System.out.println("= = = = = CINEPLAY 1.2v = = = = = ");
            System.out.println("        TICKETS FOR $10");
            System.out.println("= = = = = = = = = = = = = = = = =");

            System.out.println("What's movie do you want watch?");
            String myMovie = input.nextLine();

            Movie movieClass = searchMovieApi.searchMovie(myMovie); //Searching the movie.
            savingInJson.writeJsonFile(movieClass);//Saving the searched movies in Json file
            //Charging movie's Information
            System.out.println(movieClass);
            System.out.println("= = = = = = = = = = = = = = = = =");
            movieList.add(movieClass);
            System.out.println("you will watch " +movieClass.title() + "?[y]yes[n]No");
            String watchMovie = String.valueOf(input.next().strip().toLowerCase().charAt(0));

            if(watchMovie.equalsIgnoreCase("y")){
                int ticketsQuantity = 0;
                double totalValuetoPay = 1;
                double myPay = 0;
                System.out.println("How many tickets you want?");
                ticketsQuantity = input.nextInt();

                totalValuetoPay = ticketsQuantity * TICKET_PRICE;
                System.out.println("Value $ " + totalValuetoPay);

                System.out.println("insert your payment value");
                myPay = input.nextDouble();

                if(myPay >= totalValuetoPay){
                    System.out.println("Successfull payment, good movie!");
                }else{
                    throw new Error("Transation failed! because the your payment value not sufficient.");
                }
                };
            };

        }