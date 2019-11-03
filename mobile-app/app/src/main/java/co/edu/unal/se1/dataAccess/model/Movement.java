package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;


@Entity
public class Movement implements Serializable {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "receiver_id")
    public int receiverId;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "date")
    public  String date; //Data type pending

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getReceiverIdId() {
        return receiverId;
    }

    public void setReceiverIdId(int receiverId) {
        this.receiverId = receiverId;
    }


    public boolean getType() {return type;}

    public void setType(boolean type) {this.type = type;}


    public String getDate(){return date;}

    public void setDate(String date) {this.date = date;}

}
