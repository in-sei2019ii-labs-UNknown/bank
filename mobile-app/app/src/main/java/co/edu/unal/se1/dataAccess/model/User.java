package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import java.time.*;

@Entity
public class User implements Serializable {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name") //This is the e-mail instead
    public String name;

    @ColumnInfo(name = "balance")
    public double balance;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "creation_time")
    public  String creationTime; //Data type pending

    @ColumnInfo(name = "password_time")
    public  String passwordTime; //Data type pending

    @ColumnInfo(name = "transaction_num")
    public  int transactionNum; //Data type pending

    @ColumnInfo(name = "state")
    public boolean state;

    @ColumnInfo(name = "type")
    public boolean type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword(){return password;}

    public void setPassword(String password) {this.password = password;}

    public String getCreationTime(){return creationTime;}

    public void setCreationTime(String creationTime) {this.creationTime = creationTime;}

    public String getPasswordTime(){return passwordTime;}

    public void setPasswordTime(String passwordTime) {this.passwordTime = passwordTime;}

    public int getTransactioNum(){return transactionNum;}

    public void setTransactioNum(int transactionNum) {this.transactionNum = transactionNum;}

    public boolean getState() {return state;}

    public void setState(boolean state) {this.state = state;}

    public boolean getType() {return type;}

    public void setType(boolean type) {this.type = type;}

}
