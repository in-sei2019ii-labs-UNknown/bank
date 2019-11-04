package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import co.edu.unal.se1.dataAccess.model.Movement;

@Dao
public interface MovementDao {

    @Query("SELECT * FROM movement")
    List<Movement> getAllMovements();

    @Query("SELECT * FROM movement WHERE id = :id")
    Movement getMovementById(int id);

    @Insert
    void createMovement(Movement movement);

}