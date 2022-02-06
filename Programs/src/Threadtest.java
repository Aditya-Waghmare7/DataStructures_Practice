public class Threadtest extends Thread {

  public void run(){
    System.out.println("running");
  }
  public static void main(String[] args) {
    Threadtest t1 = new Threadtest();
    System.out.println(t1.getName());
    t1.start();
    t1.setName("Thread test");
    System.out.println(t1.getName());
  }
}
