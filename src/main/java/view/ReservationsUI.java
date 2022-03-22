package view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import interfaces.API;
import interfaces.reservations.IReservation;
import interfaces.reservations.IReservationUI;
import model.Item;
import model.Reservation;

public class ReservationsUI extends API implements IReservationUI{

    private static ReservationsUI instance;

    private ReservationsUI(){
        super();
    }

    public static ReservationsUI newInstance(){
        if(instance == null) {
            instance = new ReservationsUI();
        }
        return instance;
    }
    @Override
    public void printReservationList(Collection<Reservation> r) {
        r.forEach(this::printReservation);
    }

    @Override
    public IReservation readReservation() {
        clientView.printList(clients.listOfClientsByKey());
        String dni = view.readDNI();
        productView.printItemList(this.unreservedItems());
        Integer id = view.readID();
        LocalDateTime expected;
        do {
            expected = sc.readDateBucle("Enter expected devolution date( devolution date has to be after reservation date ): ");
        }while(expected.isBefore(LocalDateTime.now()));

        return new Reservation(id,dni,null,LocalDateTime.now(),expected,null,true);
    }

    @Override
    public void printReservation(IReservation r) {
       System.out.println("----------------------------------------------------------");
       System.out.print("ID: "+r.getID()+" , Withdrawal date: "+r.getWithdrawalDate()+" , Expected Return date: "+r.getExpectedReturnDate()
               +" , Return date: "+ ((r.getReturnDate()!=null)?(r.getReturnDate()):("Not returned yet")));
       productView.printItem(items.search(r.getItemID()));
       clientView.printClient(clients.search(r.getDNI()));
    }

    @Override
    public void printReservationListMenu() {
        System.out.println("[0] -> Go back");
        System.out.println("[1] -> Show reservations by id");
        System.out.println("[2] -> Show reservations by item id");
        System.out.println("[3] -> Show reservations by dni");
        System.out.println("[4] -> Show open reservations");
        System.out.println("[5] -> Show closed reservations");
    }

    @Override
    public Collection<Item> reservedItems() {
        Collection<Reservation> r = reservations.listOfReservationActive();
        Collection<Item> i = new ArrayList<>();
       for (Reservation re:r){
           i.add(items.search(re.getItemID()));
       }
       return i;
    }

    @Override
    public Collection<Item> unreservedItems() {
        Collection<Item> items1 = items.listOfItemsByKey();
        Collection<Item> i = new ArrayList<>();
        for(Item it :items1){
            if(reservations.getOpenReservation(it.getID()) == null){
                i.add(it);
            }
        }
        return i;
    }
}
