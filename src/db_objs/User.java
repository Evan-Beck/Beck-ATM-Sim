package db_objs;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class User {
    private final int id;
    private final String username, password;
    private BigDecimal currentBalance;

    public User(int id, String username, String password, BigDecimal currentBalance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.currentBalance = currentBalance;
    }


    public int getId() {
        return id;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(BigDecimal newBalance) {
        currentBalance = newBalance.setScale(2, RoundingMode.FLOOR);
    }
}
