import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ChiTietPNH{
    private String mapnh;
    private String masp;
    private int soluong;
    private long dongia;

    public ChiTietPNH(){}

    public ChiTietPNH(String mapnh, String masp, int soluong, long dongia){
        this.mapnh = mapnh;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;

    }

    public ChiTietPNH(ChiTietPNH x){
        this.mapnh = x.mapnh;
        this.masp = x.masp;
        this.soluong = x.soluong;
        this.dongia = x.dongia;

    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma phieu nhap hang: ");
        mapnh = sc.nextLine();

        System.out.println("Nhap ma san pham: ");
        masp = sc.nextLine();

        System.out.println("Nhap so luong san pham: ");
        soluong = sc.nextInt();


        System.out.println("Nhap don gia san pham: ");
        dongia = sc.nextLong();

    }

    public void xuat(){
        System.out.printf("%-10s %-10s %-5s %-10s %-10s \n",
        mapnh, masp, soluong, dongia, getThanhtien());
    }

    public void ghiFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ChiTietPNH.txt", true))) {
            bw.write(mapnh + "," + masp + "," + soluong + "," + dongia);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public String getMapnh(){
        return mapnh;
    }

    public void setMapnh(String mapnh){
        this.mapnh = mapnh;
    }

    public String getMasp(){
        return masp;
    }

    public void setMasp(String masp){
        this.masp = masp;
    }

    public int getSoluong(){
        return soluong;
    }

    public void setSoluong(int soluong){
        this.soluong = soluong;
    }

    public long getDongia(){
        return dongia;
    }

    public void setDongia(long dongia){
        this.dongia = dongia;
    }

    public long getThanhtien(){
        return getSoluong() * getDongia();
    }
}
