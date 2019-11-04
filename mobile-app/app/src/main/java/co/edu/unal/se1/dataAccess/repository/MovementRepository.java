package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;
import androidx.room.Room;
import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Movement;
import co.edu.unal.se1.dataAccess.model.User;

public class MovementRepository {

    private String DB_NAME = "se1_db_bank";

    private Database database;
    public MovementRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().build();
    }

    public List<Movement> getAllUsers() {
        return database.userDao().getAllUsers();
    }

    public User getUserById(int id) {
        return database.userDao().getUserById(id);
    }

    public void createUser(final User user) {
        database.userDao().createUser(user);
    }


}