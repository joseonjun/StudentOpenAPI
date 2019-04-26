package study.spring.hellospring.hello;

public class Value {

  private int x;
  private int y;

  /**
  * Returns value of x
  * @return
  */
  public int getX() {
    return x;
  }

  /**
  * Returns value of y
  * @return
  */
  public int getY() {
    return y;
  }

  /**
  * Sets new value of x
  * @param
  */
  public void setX(int x) {
    this.x = x;
  }

  /**
  * Sets new value of y
  * @param
  */
  public void setY(int y) {
    this.y = y;
  }

  /**
  * Create string representation of Value for printing
  * @return
  */
  @Override
  public String toString() {
    return "Value [x=" + x + ", y=" + y + "]";
  }
}
