package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;
import androidx.room.Room;
import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Movement;

public class MovementRepository {

    private String DB_NAME = "se1_db_bank_2";//Se cambio nombre de la DB

    private Database databaseMovement;//Nuevo nombre de la variable utilizada para referirise a la DB
    public MovementRepository(Context context) {
        databaseMovement = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().build();
    }

    public List<Movement> getAllMovments() {
        return databaseMovement.movementDao().getAllMovements();
    }

    public List<Movement> getAllMovementById(int sourceId) {
        return databaseMovement.movementDao().getAllMovementById(sourceId);
    }

    public Movement getMovementById(int id) {
        return databaseMovement.movementDao().getMovementById(id);
    }

    public void createMovement(final Movement movement) {
        databaseMovement.movementDao().createMovement(movement);
    }


}