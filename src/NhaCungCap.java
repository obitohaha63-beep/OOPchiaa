
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NhaCungCap{
    private String mancc;
    private String tenncc;
    private String diachi;
    private String sdt;

    public  NhaCungCap(){}

    public NhaCungCap(String mancc, String tenncc,String diachi, String sdt){
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.diachi = diachi;
        this.sdt = sdt;
    }
    
    public NhaCungCap(NhaCungCap x){
        this.mancc = x.mancc;
        this.tenncc = x.tenncc;
        this.diachi = x.diachi;
        this.sdt = x.sdt;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap:");
        mancc = sc.nextLine();

        System.out.println("Nhap ten nha cung cap:");
        tenncc = sc.nextLine();

        System.out.println("Nhap dia chi nha cung cap:");
        diachi = sc.nextLine();

        System.out.println("Nhap ma nha cung cap:");
        sdt = sc.nextLine();

    }

    public void xuat(){
        System.out.println("==========DANH SACH NHA CUNG CAP==========");
        System.out.printf("%-10s %-10s %-10s %-10s",
        mancc, tenncc, diachi, sdt);
    }


    public String getMancc(){
        return mancc;
    }

    public void setMancc(String mancc){
        this.mancc = mancc;
    }

    
    public String getTenncc(){
        return tenncc;
    }

    public void setTenncc(String tenncc){
        this.tenncc = tenncc;
    }

    
    public String getDiachi(){
        return diachi;
    }

    public void setDiachi(String diachi){
        this.diachi = diachi;
    }

    

    
    public String getSdt(){
        return sdt;
    }

    public void setSdt(String sdt){
        this.sdt = sdt;
    }

    public void ghiFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("nhacungcap.txt", true))) {
            bw.write(mancc + "," + tenncc + "," + diachi + "," + sdt);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    
}
    

