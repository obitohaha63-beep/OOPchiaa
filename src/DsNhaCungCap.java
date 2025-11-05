import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DsNhaCungCap {
    private NhaCungCap[] ncc;
    private int n;

    public DsNhaCungCap() {
    }

    public DsNhaCungCap(int n) {
        this.ncc = new NhaCungCap[n];
        this.n = n;
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nha cung cap: ");
        n = sc.nextInt();
        sc.nextLine();
        ncc = new NhaCungCap[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin nha cung cap " + (i + 1) + ":");
            ncc[i] = new NhaCungCap();
            ncc[i].nhap();
        }
        sc.close();
    }

    public void xuat(){
        for(int i = 0;i < n;i++){
            ncc[i].xuat();
            System.out.println();
        }
    }

    public void themncc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin nha cung cap can them: ");
        n = ncc.length;
        ncc = Arrays.copyOf(ncc, n + 1);
        ncc[n] = new NhaCungCap();
        ncc[n].nhap();
        n++;

    }

    public void themncc(NhaCungCap x){
        System.out.println("Thong tin nha cung cap can them: ");
        n = ncc.length;
        ncc = Arrays.copyOf(ncc, n + 1);
        ncc[n] = new NhaCungCap(x);
        n++;
    }

    public void suamancc(){
        Scanner sc = new Scanner(System.in);
        String masua = sc.nextLine();
        boolean timthay = false;
        for(int i = 0; i < n;i++){
            if(ncc[i].getMancc().equals(masua)){
                System.out.println("Nhap ma nha cung cap moi cho ma nha cung cung cap "+ masua +":");
                ncc[i].nhap();
                timthay = true;
                break;
            }
        }
        if(!timthay){
            System.out.println("Khong tim thay sinh vien co ma " + masua);
        }
    }

    public void suamancc(NhaCungCap mancc){
        boolean timthay = false;
        for(int i = 0;i < n;i++){
            if(ncc[i].getMancc().equals(mancc.getMancc())){
                System.out.println("Ma nha cung cap moi cho ma nha cung cung cap "+ mancc +":");
                ncc[i].nhap();
                timthay = true;
            }
        }
        if(!timthay){
            System.out.println("Khong tim thay sinh vien co ma " + mancc.getMancc());
        }
    }

    public void xoamancc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap can xoa: ");
        String maxoa = sc.nextLine();
        boolean timthay = false;

        for(int i = 0;i < n;i++){
            if(ncc[i].getMancc().equals(maxoa)){
                for(int j = i; j < n -1;j++){
                    ncc[j] = ncc[j + 1];
                }
                n--;
                ncc = Arrays.copyOf(ncc, n);
                timthay = true;
                System.out.println("Da xoa sinh vien co ma: "+ maxoa);
                break;
            }
        }
        if(!timthay){
            System.out.println("khong thay sinh vien co ma: "+ maxoa);
        }
        }

    public void xoamancc(NhaCungCap mancc){
        System.out.println("Ma nha cung cap can xoa la: "+ mancc);
        boolean timthay = false;
        for(int i = 0;i < n;i++){
            if(ncc[i].getMancc().equals(mancc.getMancc())){
                for(int j = i; j < n - 1;j++){
                    ncc[j] = ncc[j + 1];    
                }
                n--;
                ncc = Arrays.copyOf(ncc, n);
                timthay = true;
                System.out.println("Da xoa sinh vien co ma: "+ mancc);
                break;
            }
        }
        if(!timthay){
            System.out.println("khong thay sinh vien co ma: "+ mancc);
        }
    }

    public NhaCungCap timncctheoma(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap: ");
        String timma = sc.nextLine();

        for(int i = 0;i < n;i++){
            if(ncc[i].getMancc().equals(timma)){
                return ncc[i];
            }
        }
        return null;
    }

    public NhaCungCap timncctheoma(NhaCungCap mancc){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Ma nha cung cap " + mancc);

        for(int i = 0;i < n;i++){
            if(ncc[i].getMancc().equals(mancc.getMancc())){
                return ncc[i];
            }
        }
        return null;
    }

    public NhaCungCap timncctheoten(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Nhap ten nha cung cap: " );
        String timten = sc.nextLine();
        for(int i = 0;i < n;i++){
            if(ncc[i].getMancc().equals(timten)){
                return ncc[i];
            }
        }
        return null;
    }

    public NhaCungCap timncctheoten(NhaCungCap tenncc){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Ma nha cung cap " + tenncc);

        for(int i = 0;i < n;i++){
            if(ncc[i].getMancc().equals(tenncc.getMancc())){
                return ncc[i];
            }
        }
        return null;
    }

    public int thongketheodouong(){
        int tphcm = 0;

        for(int i = 0;i < n;i++){
            if(ncc[i] != null && ncc[i].getDiachi().equalsIgnoreCase("TPHCM")){
                tphcm++;
            }
        }
        return tphcm;
    }

     public void ghiFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("nhacungcap.txt"))) {
            for (int i = 0; i < n; i++) {
                // mỗi dòng là 1 nhà cung cấp, cách nhau bằng dấu phẩy
                bw.write(ncc[i].getMancc() + "," +
                         ncc[i].getTenncc() + "," +
                         ncc[i].getDiachi() + "," +
                         ncc[i].getSdt());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("nhacungcap.txt"))) {
            String line;
            n = 0;
            ncc = new NhaCungCap[100]; // cấp phát tạm
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    ncc[n] = new NhaCungCap(parts[0], parts[1], parts[2], parts[3]);
                    n++;
                }
            }
            ncc = Arrays.copyOf(ncc, n); // cắt đúng kích thước
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
   

}
