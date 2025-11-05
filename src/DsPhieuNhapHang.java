

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class DsPhieuNhapHang {
    private int n;
    private PhieuNhapHang[] dspnh = new PhieuNhapHang[1];

    public DsPhieuNhapHang(){}

    public DsPhieuNhapHang(int n) {
    this.n = n;
    this.dspnh = new PhieuNhapHang[n];
}
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong phieu nhap hang: ");
        n = sc.nextInt();
        sc.nextLine();

        dspnh = new PhieuNhapHang[n];

        for(int i = 0;i < n;i++){
            System.out.println("Danh sach phieu nhap hang thu " +(i + 1));
            dspnh[i] = new PhieuNhapHang();
            dspnh[i].nhap();
        }
    }

    public void xuat(){
        System.out.println("================DANH SACH PHIEU NHAP HANG===========");
        for(int i = 0; i < n;i++){
            dspnh[i].xuat();
        }
    }

    public void thempnh(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin phieu nhap hang can them");
        n = dspnh.length;
        dspnh = Arrays.copyOf(dspnh, n + 1);
        dspnh[n] = new PhieuNhapHang();
        dspnh[n].nhap();
        n++;
    }

    public void thempnh(PhieuNhapHang x){
        System.out.println("Them thong tin cho phieu nhap hang "+ x + ":");
        n = dspnh.length;
        dspnh = Arrays.copyOf(dspnh, n + 1);
        dspnh[n] = new PhieuNhapHang(x);
        n++;
    }

    public void suamapnh(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma phieu can sua thong tin: ");
        String masua = sc.nextLine();

        boolean timthay = false;
        for(int i = 0; i < n;i++){
            if(dspnh[i].getMapnh().equals(masua)){
                System.out.println("Nhap thong tin cho" + masua + ":");
                dspnh[i].nhap();
                timthay = true;
                break;
            }
        }
        if(!timthay){
            System.out.println("Khong tim thay ma phieu can sua: ");
        }
    }

    public void suamapnh(PhieuNhapHang mapnh){
        boolean timthay = false;
        for(int i = 0;i < n;i++){
            if(dspnh[i].getMapnh().equals(mapnh.getMapnh())){
                System.out.println("Sua thong tin phieu nhap hang cho ma so: " + mapnh);
                dspnh[i].nhap();
                timthay = true;
                break;
            }
        }
        if(!timthay){
            System.out.println("Khong tim thay ma so: " + mapnh);
        }
    }

    public void xoapnh(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma cua phieu thong tin can xoa: ");
        String maxoa = sc.nextLine();

        boolean timthay = false;
        for(int i = 0;i < n;i++){
            if(dspnh[i].getMapnh().equals(maxoa)){
                for(int j = i; j < n - 1;j++){
                    dspnh[j] = dspnh[j + 1];

                }
                n--;
                dspnh = Arrays.copyOf(dspnh, n);
                timthay = true;
                System.out.println("Da xoa phieu nhap hang co ma: " + maxoa +":");
                break;
        }
    }
    if(!timthay){
        System.out.println("Khong tim thay phieu nhap hang co ma: " + maxoa +":");
    }
    
    }
    public void xoapnh(PhieuNhapHang mapnh){
        boolean timthay = false;
        for(int i = 0;i < n;i++){
            if(dspnh[i].getMapnh().equals(mapnh.getMapnh())){
                for(int j = i; j < n - 1;j++){
                    dspnh[j] = dspnh[j + 1];
                }
                n--;
                dspnh = Arrays.copyOf(dspnh, n);
                timthay = true;
                System.out.println("Da xoa phieu nhap hang co ma: "+ mapnh);
            }
        }
        if(!timthay){
            System.out.println("Khong tim thay phieu nhap hang co ma: " + mapnh);
        }
    }

    public PhieuNhapHang timpnh(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma phieu nhap hang: ");
        String matim = sc.nextLine();
        for(int i = 0; i < n;i++){
            if(dspnh[i].getMapnh().equals(matim)){
                return dspnh[i];
            }
        }
        return null;
    }

    public PhieuNhapHang timpnh(PhieuNhapHang mapnh){
        boolean timthay = false;
        for(int i = 0;i < n;i++){
            if(dspnh[i].getMapnh().equals(mapnh.getMapnh())){
                return dspnh[i];
            }
        }
        return null;

    }

    public PhieuNhapHang timncc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap: ");
        String matim = sc.nextLine();
        for(int i = 0; i < n;i++){
            if(dspnh[i].getMapnh().equals(matim)){
                return dspnh[i];
            }
        }
        return null;
    }

    public PhieuNhapHang timncc(PhieuNhapHang mancc){
        boolean timthay = false;
        for(int i = 0;i < n;i++){
            if(dspnh[i].getMancc().equals(mancc.getMancc())){
                return dspnh[i];
            }
        }
        return null;

    }
    public int thongkeTheoNam(int nam) {
    int dem = 0;
    for (int i = 0; i < n; i++) {
        if (dspnh[i].getNgaynhap().getYear() == nam) {
            dem++;
        }
    }
    return dem;
}
       public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("phieunhaphang.txt"))) {
            for (int i = 0; i < n; i++) {
                bw.write(dspnh[i].getMapnh() + "," +
                         dspnh[i].getManv() + "," +
                         dspnh[i].getMancc() + "," +
                         dspnh[i].getNgaynhap());
                         dspnh[i].getThanhtien();
                bw.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("phieunhaphang.txt"))) {
            String line;
            n = 0;
            dspnh = new PhieuNhapHang[100];
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String mapnh = parts[0];
                    String manv = parts[1];
                    String mancc = parts[2];
                    LocalDate ngaynhap = LocalDate.parse(parts[3]);
                    long thanhtien = Long.parseLong(parts[3]);
                    dspnh[n] = new PhieuNhapHang(mapnh, manv, mancc, ngaynhap,thanhtien);
                    n++;
                }
            }
            dspnh = Arrays.copyOf(dspnh, n);
            System.out.println("Doc file thanh cong! Co " + n + " phieu nhap hang.");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

   
}
   

     




