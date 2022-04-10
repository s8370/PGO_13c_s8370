package g13c.cw3.zad1;

public class zad1 {
    public static void main(String[] args) {
        RailwayStation rs = new RailwayStation("station");
        Train t1 = rs.LaunchTrain("train 1");
        Train t2 = rs.LaunchTrain("train 2");
        Train t3 = rs.LaunchTrain("train 3");
        t1.AddCar(4);
        t1.AddCar(3);
        t2.AddCar(7);
        t3.AddCar(1);
        t3.AddCar(2);
        t3.AddCar(3);
        t3.AddCar(4);
        System.out.println(rs.toString());
    }
}