import java.util.List;
import java.util.Scanner;

/**
 * Created by SUDALKIM on 2017-06-20.
 */
public class PokerApplication {

    public static void main(String[] args){
        int money=100;
        Scanner sc = new Scanner(System.in);
        int bet;
        int whoIsWinnner;

        System.out.println("Welcome to the game of Poker.");

        while(true){
            System.out.println("You have "+money+" dollars.");
            System.out.println("How many dollars do you want to bet?  (Enter 0 to end.)");
            do{
                bet = sc.nextInt();
                if(bet<0 || bet> money){
                    System.out.println("Your answer must be between 0 and " + money + ".");
                }
            }while(bet<0 || bet > money);
            if (bet == 0){
                break;
            }
            whoIsWinnner = playPoker();
            if(whoIsWinnner == 1){//사용자가 이긴 경우
                System.out.println("\nYou got Money!");
                money = money + bet;
            }else if(whoIsWinnner == 2){//딜러가 이긴 경우
                System.out.println("\nYou lose Money. Thanks!");
                money = money - bet;
            }else if(whoIsWinnner == 3){//비긴 경우
                System.out.println("\nYou push with Dealer.");
            }else{//사용자가 Die를 택한 경우
                System.out.println("Die.");
            }
            if(money == 0){//가진 돈이 다 떨어지면 게임을 멈춘다
                System.out.println("Looks like you've are out of money!");
                break;
            }
        }

        System.out.println("You leave with "+money+".");
        System.out.println("Good Bye!");

    }

    static int playPoker(){
        Deck deck = new Deck(1);
        Hand userHand = new Hand(deck, PokerType.FIVE);
        Hand dealerHand = new Hand(deck, PokerType.FIVE);
        Evaluator evaluator = new Evaluator();

        String userResult;
        String dealerResult;
        List<Card> userList = userHand.getCardList();
        List<Card> dealerList = dealerHand.getCardList();

        int userPoint;
        int dealerPoint;

        userResult = evaluator.evaluate(userHand.getCardList()).toString();
        dealerResult = evaluator.evaluate(dealerHand.getCardList()).toString();

        Scanner sc = new Scanner(System.in);

        while(true) {
            if(userHand.getTotalCard() == 2){
                System.out.println("You can't open no more cards.");
            }else{
                System.out.print("Your cards are : ");
                Card userCard = userHand.getCard();
                System.out.println(userCard.getSuit() + " " + userCard.getRank() + " ");
                System.out.print("Dealer is showing the : ");
                Card dealerCard = dealerHand.getCard();
                System.out.println(dealerCard.getSuit() + " " + dealerCard.getRank() + " ");
            }
            System.out.println(" O(Open) / G(Go) / D(Die) ? ");
            char a;
            do{
                a = sc.nextLine().charAt(0);
                a = Character.toUpperCase(a);
                if(a != 'O' && a != 'G' && a != 'D'){
                    System.out.println("Please respond O or G or D");
                }
            }while(a != 'O' && a != 'G' && a != 'D');


        }


    }

}
