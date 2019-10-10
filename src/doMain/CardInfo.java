package doMain;


public class CardInfo {

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
    return "CardInfo{" +
            "username='" + username + '\'' +
            ", money=" + money +
            '}';
  }
}
