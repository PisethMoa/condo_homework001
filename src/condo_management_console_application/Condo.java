package condo_management_console_application;
import java.util.Scanner;
public class Condo{
    public static void press(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press any key to continue!!!");
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int option = 0;
        int floor = 0;
        int room = 0;
        String[][] condo = new String[0][];
        boolean isFloorExist = false;
        boolean isRoomExist = false;
        do{
            System.out.println("=============== Set up condo (floor and room) ===============");
            System.out.print("Please input number of floor = ");
            floor = input.nextInt();
            if(floor > 0){
                isFloorExist = true;
                System.out.print("Please input number of room = ");
                room = input.nextInt();
                if(room > 0){
                    isRoomExist = true;
                    condo = new String[floor][room];
                    if(floor > 1){
                        System.out.println("Floor is = "+floor+" floors.");
                    }else{
                        System.out.println("Floor is = "+floor+" floor.");
                    }
                    if(room > 1){
                        System.out.println("Room is = "+room+" rooms.");
                    }else{
                        System.out.println("Room is = "+room+" room.");
                    }
                    if((floor*room) > 1){
                        System.out.println("Total of rooms are "+(floor * room)+" rooms.");
                    }else{
                        System.out.println("Total of room is "+(floor * room)+" room.");
                    }
                    System.out.println("Congratulations, Your condo set up successfully...!");
                }else{
                    System.out.println("You input room can't be zero or negative! Please try again!!!");
                }
            }else{
                System.out.println("You input floor can't be zero or negative! Please try again!!!");
            }
        }while(!isFloorExist || !isRoomExist);
        do{
            System.out.println("_______________ Welcome to My Condo _______________");
            System.out.println("1. Buy Condo");
            System.out.println("2. Sell Condo");
            System.out.println("3. Search Condo Owner");
            System.out.println("4. Show Condo");
            System.out.println("5. Exit the program.");
            System.out.print("Please choose your option = ");
            option = input.nextInt();
            switch(option){
                case 1:
                    int wantFloor = 0;
                    int wantRoom = 0;
                    String owner = null;
                    boolean isCondition = false;
                    System.out.println("--------------- Buy Condo ---------------");
                    System.out.print("Please input your floor that you want to buy = ");
                    wantFloor = input.nextInt();
                    if(wantFloor>0 && wantFloor<=floor){
                        isFloorExist = true;
                        System.out.print("Please input your room that you want to buy= ");
                        wantRoom = input.nextInt();
                        if(wantRoom>0 && wantRoom<=room) {
                            if (condo[wantFloor - 1][wantRoom - 1] == null) {
                                isRoomExist = true;
                                isCondition = true;
                                System.out.print("Please input your name = ");
                                input.nextLine();
                                owner = input.nextLine();
                                condo[wantFloor - 1][wantRoom - 1] = owner;
                                System.out.println("Congratulations, You bought condo successfully!!!");
                            } else {
                                System.out.println("This room has already been purchased!");
                            }
                        }else{
                            System.out.println("You put room number is invalid!!!");
                        }
                    }else{
                        System.out.println("You put floor number is invalid!!!");
                        isFloorExist = false;
                    }
                    break;
                case 2:
                    int buyOption = 0;
                    System.out.println("--------------- Sell Condo ---------------");
                    System.out.print("Please input your floor that you want to sell = ");
                    wantFloor = input.nextInt();
                    System.out.print("Please input your room that you want to sell = ");
                    wantRoom = input.nextInt();
                    if((wantFloor>0&&wantFloor<=floor) && (wantRoom>0&&wantRoom<=room)){
                        if(condo[wantFloor-1][wantRoom-1] != null){
                            condo[wantFloor-1][wantRoom-1] = null;
                            System.out.println("Congratulations, You sold the condo successfully.");
                        }else{
                            System.out.println("The condo doesn't belong to you!");
                        }
                    }else{
                        System.out.println("You input floor and room is invalid!!!");
                    }
                    break;
                case 3:
                    int searchCondo = 0;
                    int searchFloor = 0;
                    System.out.println("--------------- Search Condo Owner ---------------");
                    System.out.println("1. Search by Floor");
                    System.out.println("2. Search by owner's name");
                    System.out.println("3. Exit the Program.");
                    System.out.print("Please choose your option = ");
                    searchCondo = input.nextInt();
                    switch(searchCondo){
                        case 1 ->{
                            System.out.println("############### Search by Floor ###############");
                            System.out.print("Please input the floor to search = ");
                            searchFloor = input.nextInt();
                            if(searchFloor>0 && searchFloor<=floor){
                                System.out.print("Floor "+"["+searchFloor+"]"+" is = ");
                                for(int c=0; c<condo[searchFloor-1].length; c++){
                                    System.out.print("\t\t"+condo[searchFloor-1][c]);
                                }
                                System.out.println();
                            }else{
                                System.out.println("You choose invalid floor. Please choose your floor from 1 to "+floor+" .");
                            }
                        }
                        case 2 -> {
                            String searchOwnerName;
                            boolean isCondoExist = false;
                            System.out.println("############### Search by owner's name ###############");
                            System.out.print("Please input owner name to search = ");
                            input.nextLine();
                            searchOwnerName = input.nextLine();
                            for(int d=0; d<condo.length; d++){
                                for(int e=0; e<condo[d].length; e++){
                                    if(searchOwnerName.equalsIgnoreCase(condo[d][e])){
                                        System.out.println("Owner name "+searchOwnerName+" stay in my condo in floor "+(d+1)+" room "+(e+1)+" .");
                                        isCondoExist = true;
                                    }
                                }
                            }
                            if(!isCondoExist){
                                System.out.println("Owner name "+searchOwnerName+" doesn't exist into my system.");
                            }
                        }
                        case 3 ->
                                System.out.println("Exiting the Program!!!!");
                        default ->
                                System.out.println("You choose wrong option. Please try again!!!");
                    }
                    break;
                case 4:
                    System.out.println("--------------- Show owner that they stay in condo ---------------");
                    for(int a=condo.length-1; a>=0; a--){
                        System.out.print("Floor "+"["+(a + 1)+"]"+" is = ");
                        for(int b=0; b< condo[a].length; b++){
                            System.out.print("\t\t"+condo[a][b]);
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Program!!!");
                    break;
                default:
                    System.out.println("You choose wrong option! please try again.");
                    break;
            }
            press();
        }while(option != 5);
    }
}
