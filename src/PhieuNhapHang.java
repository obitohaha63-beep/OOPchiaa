import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
public class PhieuNhapHang{
    private String mapnh;
    private String manv;
    private String mancc;
    private LocalDate ngaynhap;
    private Long thanhtien;

    public PhieuNhapHang(){}

    public PhieuNhapHang(String mapnh, String manv, String mancc, LocalDate ngaynhap, Long thanhtien){
        this.mapnh = mapnh;
        this.manv = manv;
        this.mancc = mancc;
        this.ngaynhap = ngaynhap;
        this.thanhtien = thanhtien;
    }

    public PhieuNhapHang(PhieuNhapHang x){
        this.mapnh = x.mapnh;
        this.manv = x.manv;
        this.mancc = x.mancc;
        this.ngaynhap = x.ngaynhap;
        this.thanhtien = x.thanhtien;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma phieu nhap hang: ");
        mapnh = sc.nextLine();

        System.out.println("Nhap ma nhan vien: ");
        manv = sc.nextLine();

        System.out.println("Nhap ma nha cung cap:" );
        mancc = sc.nextLine();

        System.out.println("Nhap ngay nhap (yyyy-MM-dd): ");
        String ns = sc.nextLine();
        ngaynhap = LocalDate.parse(ns);
    }

    public void xuat(){
        System.out.printf("%-10s %-10s %-10s %-15s%n %-10s", mapnh, manv, mancc, ngaynhap,thanhtien);
    }

    public void ghiFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("phieunhaphang.txt", true))) {
            bw.write(mapnh + "," + manv + "," + mancc + "," + ngaynhap + "," + thanhtien);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    
    //-----------------------------------------------------
    public String getMapnh(){
        return mapnh;
    }

    public void setMapnh(String mapnh){
        this.mapnh = mapnh;
    }

    //-----------------------------------------------------
    public String getManv(){
        return manv;
    }

    public void setManv(String manv){
        this.manv = manv;
    }
    //-----------------------------------------------------
    public String getMancc(){
        return mancc;
    }

    public void setMancc(String mancc){
        this.mancc = mancc;
    }
    //-----------------------------------------------------
    public LocalDate getNgaynhap(){
        return ngaynhap;
    }

    public void setNgaynhap(LocalDate ngaynhap){
        this.ngaynhap = ngaynhap;
    }
    //-----------------------------------------------------

    public int getNam(){
        return ngaynhap.getYear();
    }

    public Long getThanhtien(){
        return thanhtien;
    }

    public void setThanhtien(Long thanhtien){
        this.thanhtien = thanhtien;
    }
}