
package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.model.Movement;
import co.edu.unal.se1.dataAccess.repository.UserRepository;
import co.edu.unal.se1.dataAccess.repository.MovementRepository;

public class  UserController {

    private UserRepository userRepository;
    private MovementRepository movementRepository;

    public UserController() {

    }

    public void createUser(User user, Context context) {

        userRepository = new UserRepository(context);
        userRepository.createUser(user);
        System.out.println("¡Usuario creado satisfactoriamente!");
    }

    public boolean sendMoney(int sourceId, int targetId, double value, Context context) {

        userRepository = new UserRepository(context);

        final User sourceUser = userRepository.getUserById(sourceId);
        System.out.println("Source User - ID: " + sourceUser.getId() +
                ", Name: " + sourceUser.getName() +
                ", Balance: " + sourceUser.getBalance());

        if (sourceUser.getBalance() >= value) {

            final User targetUser = userRepository.getUserById(targetId);
            System.out.println("Target User - ID: " + targetUser.getId() +
                    ", Name: " + targetUser.getName() +
                    ", Balance: " + targetUser.getBalance());

            sourceUser.setBalance(sourceUser.getBalance() - value);
            targetUser.setBalance(targetUser.getBalance() + value);
            userRepository.updateUser(sourceUser);
            userRepository.updateUser(targetUser);

            final User updatedSourceUser = userRepository.getUserById(sourceId);
            System.out.println("Source User (updated) - ID: " + updatedSourceUser.getId() +
                    ", Name: " + updatedSourceUser.getName() +
                    ", Balance: " + updatedSourceUser.getBalance());

            final User updatedTargetUser = userRepository.getUserById(targetId);
            System.out.println("Target User (updated) - ID: " + updatedTargetUser.getId() +
                    ", Name: " + updatedTargetUser.getName() +
                    ", Balance: " + updatedTargetUser.getBalance());

            //Movement creation, Type: transaction

            Movement movement = new Movement();
            movement.setId(sourceId);
            movement.setReceiverId(targetId);
            movement.setDate("Today"); // Pending
            movement.setType("Transaction");


            movementRepository = new MovementRepository(context);
            movementRepository.createMovement(movement);
            System.out.println("Movimiento respectavamente generado");

            return true;

        } else {

            return false;
        }

    }

    public void deposit(int targetId, double value, Context context) {

        userRepository = new UserRepository(context);

        final User targetUser = userRepository.getUserById(targetId);
        System.out.println("Target User - ID: " + targetUser.getId() +
                ", Name: " + targetUser.getName() +
                ", Balance: " + targetUser.getBalance());

        targetUser.setBalance(targetUser.getBalance() + value);

        userRepository.updateUser(targetUser);

        final User updatedTargetUser = userRepository.getUserById(targetId);
        System.out.println("Target User (updated) - ID: " + updatedTargetUser.getId() +
                ", Name: " + updatedTargetUser.getName() +
                ", New balance: " + updatedTargetUser.getBalance());

        //Movement creation, Type: Deposit

        Movement movement = new Movement();
        movement.setId(targetId);
        movement.setReceiverId(-1);
        movement.setDate("Today"); // Pending
        movement.setType("Deposit");


        movementRepository = new MovementRepository(context);
        movementRepository.createMovement(movement);
        System.out.println("Movimiento respectavamente generado");
    }


    public void changePasswaord(int sourceId, String newPassword, Context context) {

        boolean flag1=true;
        userRepository = new UserRepository(context);
        final User sourceUser = userRepository.getUserById(sourceId);
        if(newPassword.length()<=6){
            for(int i=0; i<6; i++){
                if(!isDigit(newPassword.charAt(i))){
                    flag1=false;
                }
            }
        }


        if(flag1==true){
            sourceUser.setPassword(newPassword);
            System.out.println("¡Contraseña cambiada satisfactoriamente!");
        }else{
            System.out.println("La contraseña ingresada no esta permitida");
        }

    }
}