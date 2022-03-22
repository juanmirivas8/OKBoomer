package controller;

import interfaces.API;
import interfaces.clients.IClient;
import interfaces.products.IItem;
import interfaces.reservations.IReservation;
import interfaces.reservations.IReservationController;

import java.time.LocalDateTime;

public class ReservationController extends API implements IReservationController {

    private static ReservationController instance;
    private ReservationController(){
        super();
    }

    public static ReservationController newInstance(){
        if(instance==null){
            instance=new ReservationController();
        }
        return instance;
    }

    @Override
    public void reservationsMenu(Integer opcion) {
        switch (opcion) {
            case 16 -> this.makeReservation();

            case 17 -> this.closeReservation();

            case 18 -> this.deleteReservation();

            case 19 -> this.listReservations();

            case 20 -> this.searchReservation();

        }
    }

    @Override
    public void makeReservation() {
        IReservation r = reservationView.readReservation();
        IClient c = clients.search(r.getDNI());
        IItem i = items.search(r.getItemID());
        Boolean res = false;
        if(c != null && i != null && reservations.getOpenReservation(r.getItemID())==null){
            res = reservations.add(r);
        }
        view.operationResult(res);
    }

    @Override
    public void closeReservation() {
        reservationView.printReservationList(reservations.listOfReservationActive());
        Integer id = view.readID();
        IReservation r = reservations.search(id);

        if(r != null && r.getStatus()==true){
            r.setStatus(false);
            r.setReturnDate(LocalDateTime.now());
            view.operationResult(true);
        }else{
            view.operationResult(false);
        }
    }

    @Override
    public void deleteReservation() {
        reservationView.printReservationList(reservations.listOfReservationClosed());
        Integer id = view.readID();
        IReservation r = reservations.search(id);

        if(r != null && r.getStatus()==false){
            reservations.delete(id);
            view.operationResult(true);
        }else{
            view.operationResult(false);
        }
    }

    @Override
    public void searchReservation() {
        reservationView.printReservationList(reservations.listOfReservationByID());
        Integer id = view.readID();
        IReservation r = reservations.search(id);

        if(r != null){
            reservationView.printReservation(r);
        }else{
            view.operationResult(false);
        }
    }

    @Override
    public void listReservations() {
        Integer option = 0;

        do{
            reservationView.printReservationListMenu();
            option = view.readOption(0,5);

            switch (option){
                case 0->{view.printReturnBack();}

                case 1 ->{reservationView.printReservationList(reservations.listOfReservationByID());}

                case 2->{reservationView.printReservationList(reservations.listOfReservationByItemID());}

                case 3->{reservationView.printReservationList(reservations.listOfReservationByDNI());}

                case 4->{reservationView.printReservationList(reservations.listOfReservationActive());}

                case 5->{reservationView.printReservationList(reservations.listOfReservationClosed());}

            }

        }while(option != 0);
    }
}
