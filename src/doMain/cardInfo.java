package doMain;


public class cardInfo {

  private String username;
  private int money;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "cardInfo{" +
            "username='" + username + '\'' +
            ", money=" + money +
            '}';
  }
}
