package doMain;


import java.sql.Timestamp;
import java.util.Date;

public class PlInfo {
    private int id;
    private String carNumber;
    private Timestamp time;



    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }




  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getCarNumber() {
    return carNumber;
  }

  public void setCarNumber(String carNumber) {
    this.carNumber = carNumber;
  }

    @Override
    public String toString() {
        return "PlInfo{" +
                "id='" + id + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", time=" + time +
                '}';
    }
}
